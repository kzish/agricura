package net.centricdata.agricura.Fragments;


import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.cardview.widget.CardView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.centricdata.agricura.R;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

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
    ImageView weather_icon;
    TextView current_location, current_temp;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Home");
        View view = inflater.inflate(R.layout.fragment_home, container, false);

/*
        String content;
        WeatherFetch myWeather = new WeatherFetch();
        try {
            content = myWeather.execute("https://openweathermap.org/data/2.5/weather?q=Harare&appid=b6907d289e10d714a6e88b30761fae22").get();

            Log.i("contentData", content);
            //JSON
            JSONObject jsonObject = new JSONObject(content);
            String weatherData = jsonObject.getString("weatherData");
            Log.i("weatherData", weatherData);

            JSONArray array = new JSONArray(weatherData);


        } catch (Exception e) {
            e.printStackTrace();
        }
*/

        //setting variable programmatically
        weather_icon = view.findViewById(R.id.imgViewWeatherIcon);
        weather_icon.setImageResource(R.drawable.sun_icon);
        weather_icon.setBackgroundColor(Color.TRANSPARENT);

        current_location = view.findViewById(R.id.textViewLocation);
        current_temp = view.findViewById(R.id.textViewCurrentTemp);

        current_location.setText("Graniteside, Harare");
        current_temp.setText("19\'");


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

                        Fragment fragment = new ProductCategoriesFragment();

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

    class WeatherFetch extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... address) {

            try {
                URL url = new URL(address[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                connection.connect();

                InputStream is = connection.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);

                int data = isr.read();
                String content = "";
                char ch;

                while (data != 1){
                    ch = (char) data;
                    content = content + ch;
                    data = isr.read();
                }

                return content;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }
}
