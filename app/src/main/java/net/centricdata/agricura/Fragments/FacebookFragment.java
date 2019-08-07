package net.centricdata.agricura.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import net.centricdata.agricura.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FacebookFragment extends Fragment {

    private WebView webView;
    private View view;
    private SwipeRefreshLayout myFacebookFeedSwipe;

    public FacebookFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_facebook, container, false);
        getActivity().setTitle("Agricura Facebook");

        fetchFacebookFeed();
        myFacebookFeedSwipe = view.findViewById(R.id.facebook_refresh_layout);
        myFacebookFeedSwipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                fetchFacebookFeed();
            }
        });

        if (myFacebookFeedSwipe.isRefreshing()){
            myFacebookFeedSwipe.setRefreshing(false);
        }

        return view;
    }

    private void fetchFacebookFeed() {
        webView = (WebView) view.findViewById(R.id.facebookWebView);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://www.facebook.com/AgricuraZim");

        myFacebookFeedSwipe = view.findViewById(R.id.facebook_refresh_layout);
        myFacebookFeedSwipe.setRefreshing(false);
    }

}
