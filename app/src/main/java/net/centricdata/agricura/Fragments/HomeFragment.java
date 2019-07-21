package net.centricdata.agricura.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.centricdata.agricura.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    CardView mybranch;
    CardView news;
    CardView calendar;
    CardView our_products;
    CardView weather;
    CardView income_sta;
    CardView productive;
    CardView sales;
    CardView my_acc;
    CardView my_weather;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Home");
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        mybranch = view.findViewById(R.id.card_branches);
        news = view.findViewById(R.id.card_news);
        calendar = view.findViewById(R.id.card_calendar);
        our_products = view.findViewById(R.id.card_products);
        weather = view.findViewById(R.id.nav_weather);
        income_sta = view.findViewById(R.id.card_income);
        my_weather = view.findViewById(R.id.card_weather);
        productive = view.findViewById(R.id.card_productive);
        my_acc = view.findViewById(R.id.card_myaccc);



        news.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bundle bundle = new Bundle();

                        Fragment fragment = new NewsFragment();

                        fragment.setArguments(bundle);

                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.content_main, fragment);
                        ft.addToBackStack(null);
                        ft.commit();
                    }
                }
        );

        our_products.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bundle bundle = new Bundle();

                        Fragment fragment = new ProductsFragment();

                        fragment.setArguments(bundle);

                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.content_main, fragment);
                        ft.addToBackStack(null);
                        ft.commit();
                    }
                }
        );

        calendar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bundle bundle = new Bundle();

                        Fragment fragment = new CalendarFragment();

                        fragment.setArguments(bundle);

                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.content_main, fragment);
                        ft.addToBackStack(null);
                        ft.commit();
                    }
                }
        );

        productive.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bundle bundle = new Bundle();

                        Fragment fragment = new ProductiveGuidelinesFragment();

                        fragment.setArguments(bundle);

                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.content_main, fragment);
                        ft.addToBackStack(null);
                        ft.commit();
                    }
                }
        );

        mybranch.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bundle bundle = new Bundle();

                        Fragment fragment = new BranchesFragment();

                        fragment.setArguments(bundle);

                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.content_main, fragment);
                        ft.addToBackStack(null);
                        ft.commit();
                    }
                }
        );

        my_weather.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bundle bundle = new Bundle();

                        Fragment fragment = new WeatherFragment();

                        fragment.setArguments(bundle);

                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.content_main, fragment);
                        ft.addToBackStack(null);
                        ft.commit();
                    }
                }
        );

        calendar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bundle bundle = new Bundle();

                        Fragment fragment = new CalendarFragment();

                        fragment.setArguments(bundle);

                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.content_main, fragment);
                        ft.addToBackStack(null);
                        ft.commit();
                    }
                }
        );

        our_products.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bundle bundle = new Bundle();

                        Fragment fragment = new ProductsFragment();

                        fragment.setArguments(bundle);

                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.content_main, fragment);
                        ft.addToBackStack(null);
                        ft.commit();
                    }
                }
        );

        income_sta.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bundle bundle = new Bundle();

                        Fragment fragment = new IncomeStatementFragment();

                        fragment.setArguments(bundle);

                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.content_main, fragment);
                        ft.addToBackStack(null);
                        ft.commit();
                    }
                }
        );

        my_acc.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bundle bundle = new Bundle();

                        Fragment fragment = new MyAccountFragment();

                        fragment.setArguments(bundle);

                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.content_main, fragment);
                        ft.addToBackStack(null);
                        ft.commit();
                    }
                }
        );



        return view;
    }

}
