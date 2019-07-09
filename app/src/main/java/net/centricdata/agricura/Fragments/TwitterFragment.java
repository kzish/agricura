package net.centricdata.agricura.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.DefaultLogger;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterConfig;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetui.TimelineResult;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;
import com.twitter.sdk.android.tweetui.UserTimeline;

import net.centricdata.agricura.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TwitterFragment extends ListFragment {


    public TwitterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =   inflater.inflate(R.layout.tweetui_swipe_timeline, container, false);

        TwitterConfig config = new TwitterConfig.Builder(getActivity().getBaseContext())
                .logger(new DefaultLogger(Log.DEBUG))
                .twitterAuthConfig(new TwitterAuthConfig("WLgYgzeXyJU73WnoOPO1RKx39", "ellWxMdvMkT0DsWG9gMdjNVqZG1uFtsX59RoCkgBfVvYzqbD1M"))
                .debug(true)
                .build();
        //Twitter.initialize(config);
        final ListView listView = (ListView) view.findViewById(android.R.id.list);
        final View emptyView = view.findViewById(android.R.id.empty);

        //listView.setEmptyView(emptyView);

        Twitter.initialize(config);
        //new Thread((Runnable) TweetUi.getInstance()).start();

            /*final UserTimeline userTimeline = new UserTimeline.Builder()
                    .screenName("NetOneCellular")
                    .build();
            final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter.Builder(getActivity().getBaseContext())
                    .setTimeline(userTimeline)
                    .build();
            setListAdapter(adapter);*/

        final SwipeRefreshLayout swipeLayout =  view.findViewById(R.id.swipe_layout);
        final UserTimeline userTimeline = new UserTimeline.Builder()
                .screenName("Agricura_ZW")
                .build();
        final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter.Builder(getActivity().getBaseContext())
                .setTimeline(userTimeline)
                .build();
        setListAdapter(adapter);


        ////
        // set custom scroll listener to enable swipe refresh layout only when at list top
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            boolean enableRefresh = false;
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {}
            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount,
                                 int totalItemCount) {
                if (listView != null && listView.getChildCount() > 0) {
                    // check that the first item is visible and that its top matches the parent
                    enableRefresh = listView.getFirstVisiblePosition() == 0 &&
                            listView.getChildAt(0).getTop() >= 0;
                } else {
                    enableRefresh = false;
                }
                swipeLayout.setEnabled(enableRefresh);
            }
        });

        ///


        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeLayout.setRefreshing(true);
                adapter.refresh(new Callback<TimelineResult<Tweet>>() {
                    @Override
                    public void success(Result<TimelineResult<Tweet>> result) {
                        swipeLayout.setRefreshing(false);
                    }

                    @Override
                    public void failure(TwitterException exception) {
                        // Toast or some other action
                    }
                });

            }

        });

        return view;
    }

}
