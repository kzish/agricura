package net.centricdata.agricura.Adapters;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import net.centricdata.agricura.Fragments.NewsDetailsFragment;
import net.centricdata.agricura.Models.News;
import net.centricdata.agricura.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private Context ctx;
    private List<News> newsList;

    public String headlines = "";

    private ArrayList<HashMap<String,String>> mDataset;

    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        listener = listener;
    }


    public interface OnItemClickListener {
        void onItemClick(int poz);
    }

    public void add(int position, HashMap<String,String> item) {
        mDataset.add(position, item);
        notifyItemInserted(position);
    }

    public void remove( HashMap<String,String> item) {
        int position = mDataset.indexOf(item);
        mDataset.remove(position);
        notifyItemRemoved(position);
    }

    public NewsAdapter(Context ctx, List<News> newsList) {
        this.ctx = ctx;
        this.newsList = newsList;
    }



    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.
                from(ctx).inflate(R.layout.row_news, viewGroup, false);

        return new NewsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder newsViewHolder, final int position) {

        newsViewHolder.nHeadline.setText(newsList.get(position).getNewsHeadline());
        final int newsId = newsList.get(position).getNewsId();
        newsViewHolder.nDetails.setText(newsList.get(position).getNewsDetails());
        newsViewHolder.nDate.setText(newsList.get(position).getNewsDatePosted());
        String img = newsList.get(position).getNewsImageUrl();

        headlines = String.valueOf(newsList.get(position).getNewsId());

        Picasso.with(ctx)
                .load(img)
                //.placeholder()
                .fit()
                .into(newsViewHolder.myImage);

        Log.e("urlImage", img);

        //newsId

        /*newsViewHolder.newsCard.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AppCompatActivity activity = (AppCompatActivity) v.getContext();

                        //Log.e("position", String.valueOf(position));
                        final  String branchKey = String.valueOf(newsId)  ;
                        Log.e("branchID", String.valueOf(position));

                        Bundle bundle = new Bundle();
                        bundle.putString("branchID" ,headlines );

                        Fragment fragment = new NewsDetailsFragment();

                        fragment.setArguments(bundle);


                        FragmentTransaction ft =  activity.getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.content_main, fragment);
                        ft.addToBackStack("branches");
                        ft.commit();
                    }
                }
        );*/


    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public  class NewsViewHolder extends RecyclerView.ViewHolder{

        String nImageUrl;
        TextView nHeadline, nDetails, nDate;
        Integer nID;
        CardView newsCard;
        ImageView myImage;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);

            View myNewsView = itemView;


            nDate = myNewsView.findViewById(R.id.txtNewsDate);
            nDetails = myNewsView.findViewById(R.id.txtNewsDetails);
            nHeadline = myNewsView.findViewById(R.id.txtNewsHeadline);
            newsCard = myNewsView.findViewById(R.id.card_news);
            myImage = myNewsView.findViewById(R.id.imgNewsImage);

            itemView.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(listener != null){
                                int poz = getAdapterPosition();
                                if(poz != RecyclerView.NO_POSITION){
                                    listener.onItemClick(poz);
                                }
                            }
                        }
                    }
            );



        }
    }


}
