package net.centricdata.agricura.Fragments;


import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import net.centricdata.agricura.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsDetailsFragment extends Fragment {

    private String newsHeadlines, newsDetails, newsUrl;

    ImageView newsPic;
    TextView headLines, story;
    Context context;


    public NewsDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news_details, container, false);

        newsHeadlines = getArguments().getString("newzHead");
        newsDetails = getArguments().getString("newzDet");
        newsUrl = getArguments().getString("newzImg");

        getActivity().setTitle(newsHeadlines);


        newsPic = view.findViewById(R.id.imgNews);
        headLines = view.findViewById(R.id.txtHeadline);
        story = view.findViewById(R.id.txtStory);


        story.setText(newsDetails);
        headLines.setText(newsHeadlines);
        Picasso.with(context)
                .load(newsUrl)
                .fit()
                .into(newsPic);




        return view;
    }

}
