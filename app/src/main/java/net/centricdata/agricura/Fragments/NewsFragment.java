package net.centricdata.agricura.Fragments;


import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import net.centricdata.agricura.Adapters.NewsAdapter;
import net.centricdata.agricura.Models.News;
import net.centricdata.agricura.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment implements NewsAdapter.OnItemClickListener {

    private RecyclerView myRecycleView;
    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private List<News> newsList;
    private NewsAdapter adapter;
    //NewsAdapter newsAdapter;

    private String url = "http://167.86.73.213/agricura_php_apis/newslist.php";


    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("News");
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        //code goes here

        myRecycleView = view.findViewById(R.id.recycle_news);

        newsList = new ArrayList<>();

        adapter = new NewsAdapter(getContext(),newsList);

        linearLayoutManager = new LinearLayoutManager(getContext());

        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        dividerItemDecoration = new DividerItemDecoration(myRecycleView.getContext(), linearLayoutManager.getOrientation());

        myRecycleView.setHasFixedSize(true);

        myRecycleView.setLayoutManager(linearLayoutManager);

        myRecycleView.addItemDecoration(dividerItemDecoration);

        myRecycleView.setAdapter(adapter);
        getData();

        adapter.setOnItemClickListener(this);



        /*myRecycleView.addOnItemTouchListener(
                new RecyclerView.OnItemTouchListener() {
                    @Override
                    public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
                        return false;
                    }

                    @Override
                    public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {



                    }

                    @Override
                    public void onRequestDisallowInterceptTouchEvent(boolean b) {

                    }
                }
        );*/



        return  view;
    }

    private void getData() {

        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage(
                "Loading...");
        progressDialog.show();

        JsonArrayRequest jsonArrayRequest =
                new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
                    @Override

                    public void onResponse(JSONArray response) {

                        for (int i = 0; i < response.length(); i++) {

                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                News news = new News();

                                news.setNewsHeadline(jsonObject.getString("Headline"));
                                news.setNewsDetails(jsonObject.getString("Content"));
                                news.setNewsImageUrl(jsonObject.getString("ImageUrl"));


                                newsList.add(news);
                                //Log.e("numbers", String.valueOf(response));
                            }
                            catch (JSONException e) {
                                e.printStackTrace();
                                progressDialog.dismiss();
                            }
                        }


                        adapter.notifyDataSetChanged();
                        progressDialog.dismiss();
                    }
                },
                        new Response.ErrorListener() {
                            @Override

                            public void onErrorResponse(VolleyError error) {
                                Log.
                                        e("Volley", error.toString());
                                progressDialog.dismiss();
                            }
                        });
        RequestQueue requestQueue = Volley.
                newRequestQueue(getContext());
        requestQueue.add(jsonArrayRequest);
    }


    @Override
    public void onItemClick(int poz) {
        News myNews = newsList.get(poz);
        String newsID = String.valueOf(myNews.getNewsId());

        Log.i("myKey", "click click");

    }
}