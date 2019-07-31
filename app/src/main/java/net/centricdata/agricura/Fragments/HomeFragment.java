package net.centricdata.agricura.Fragments;


import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.cardview.widget.CardView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kwabenaberko.openweathermaplib.constants.Lang;
import com.kwabenaberko.openweathermaplib.constants.Units;
import com.kwabenaberko.openweathermaplib.implementation.OpenWeatherMapHelper;
import com.kwabenaberko.openweathermaplib.implementation.callbacks.CurrentWeatherCallback;
import com.kwabenaberko.openweathermaplib.models.currentweather.CurrentWeather;

import net.centricdata.agricura.R;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static com.crashlytics.android.core.CrashlyticsCore.TAG;

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
    TextView current_location, min_temp, max_temp;


    public HomeFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Home");
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        OpenWeatherMapHelper helper = new OpenWeatherMapHelper(getString(R.string.OPEN_WEATHER_MAP_API_KEY));
        helper.setUnits(Units.METRIC);
        helper.setLang(Lang.ENGLISH);

        

        //setting variable programmatically
        weather_icon = view.findViewById(R.id.imgViewWeatherIcon);
        weather_icon.setImageResource(R.drawable.sun_icon);
        weather_icon.setBackgroundColor(Color.TRANSPARENT);

        current_location = view.findViewById(R.id.textViewLocation);
        min_temp = view.findViewById(R.id.textViewMinTemp);
        max_temp = view.findViewById(R.id.textViewMaxTemp);

        current_location.setText("Graniteside, Harare");

        helper.getCurrentWeatherByCityName("Harare", new CurrentWeatherCallback() {
            @Override
            public void onSuccess(CurrentWeather currentWeather) {
                double temp_min = currentWeather.getMain().getTemp();
                double temp_max = currentWeather.getMain().getTempMax();

                String temp_minim = String.valueOf(temp_min);
                String temp_maxim = String.valueOf(temp_max);

                //current_temp.setText((int) currentWeather.getMain().getTempMax());
                min_temp.setText("Min Temp: " + temp_minim + "°C" );
                max_temp.setText("Max Temp: " + temp_maxim + "°C" );
            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.v(TAG, throwable.getMessage());

            }
        });


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

}
