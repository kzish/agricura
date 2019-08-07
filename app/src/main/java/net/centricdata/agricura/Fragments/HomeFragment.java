package net.centricdata.agricura.Fragments;


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

import com.bumptech.glide.Glide;
import com.kwabenaberko.openweathermaplib.constants.Lang;
import com.kwabenaberko.openweathermaplib.constants.Units;
import com.kwabenaberko.openweathermaplib.implementation.OpenWeatherMapHelper;
import com.kwabenaberko.openweathermaplib.implementation.callbacks.CurrentWeatherCallback;
import com.kwabenaberko.openweathermaplib.models.currentweather.CurrentWeather;

import net.centricdata.agricura.R;

import im.delight.android.location.SimpleLocation;

import static com.crashlytics.android.core.CrashlyticsCore.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    double latitude = 0;
    double longitude = 0;
    CardView mybranch;
    CardView news;
    CardView calendar;
    CardView our_products;
    CardView weather;
    CardView income_sta;
    CardView productionGuide;
    CardView sales;
    CardView my_acc;
    CardView my_weather;
    ImageView weather_icon;
    private TextView current_location, min_temp, max_temp;
    private SimpleLocation location;
    String myIcon;
    View view;



    public HomeFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Home");
        view = inflater.inflate(R.layout.fragment_home, container, false);

        DoLocation();

       //setting variable programmatically
        //weather_icon = view.findViewById(R.id.imgViewWeatherIcon);
        //weather_icon.setImageResource(R.drawable.sunny);
        //weather_icon.setBackgroundColor(Color.TRANSPARENT);



        current_location = view.findViewById(R.id.textViewLocation);
        min_temp = view.findViewById(R.id.textViewMinTemp);
        max_temp = view.findViewById(R.id.textViewMaxTemp);


        mybranch = view.findViewById(R.id.card_branches);
        news = view.findViewById(R.id.card_news);
        calendar = view.findViewById(R.id.card_calendar);
        our_products = view.findViewById(R.id.card_products);
        weather = view.findViewById(R.id.nav_weather);
        income_sta = view.findViewById(R.id.card_income);
        my_weather = view.findViewById(R.id.card_weather);
        productionGuide = view.findViewById(R.id.card_production);
        my_acc = view.findViewById(R.id.card_myaccc);

            WeatherProcessing();

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

        productionGuide.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bundle bundle = new Bundle();

                        Fragment fragment = new ProductionGuidelinesFragment();

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





    private double[] DoLocation() {
        location = new SimpleLocation(getActivity());

        if (!location.hasLocationEnabled()){
            //asking the user for permissions for location access
            SimpleLocation.openSettings(getActivity());
        }

        double latitude = location.getLatitude();
        double longitude = location.getLongitude();


        return new double[]{latitude, longitude};
    }

    private void WeatherProcessing() {

        OpenWeatherMapHelper helper = new OpenWeatherMapHelper(getString(R.string.OPEN_WEATHER_MAP_API_KEY));
        helper.setUnits(Units.METRIC);
        helper.setLang(Lang.ENGLISH);

        double[] coordinates = DoLocation();

        latitude = coordinates[0];
        longitude = coordinates[1];



        helper.getCurrentWeatherByGeoCoordinates(latitude, longitude, new CurrentWeatherCallback() {
            @Override
            public void onSuccess(CurrentWeather currentWeather) {

                double temp_min = currentWeather.getMain().getTemp();
                double temp_max = currentWeather.getMain().getTempMax();
                String actualLocation = currentWeather.getName() + ", " + currentWeather.getSys().getCountry();

                weather_icon = view.findViewById(R.id.imgViewWeatherIcon);
                myIcon = currentWeather.getWeather().get(0).getIcon();


                String temp_minim = String.valueOf(temp_min);
                String temp_maxim = String.valueOf(temp_max);

                current_location.setText(actualLocation);


             //   ImageLoader imageLoader = ImageLoader.getInstance();
             //   imageLoader.displayImage(imageUri, weather_icon);

                String imageUri = "http://openweathermap.org/img/wn/"+ myIcon +"@2x.png";
                Glide.with(getActivity()).load(imageUri).into(weather_icon);


                //current_temp.setText((int) currentWeather.getMain().getTempMax());
                min_temp.setText("Min Temp: " + temp_minim + "°C" );
                max_temp.setText("Max Temp: " + temp_maxim + "°C" );
            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.v(TAG, throwable.getMessage());

            }
        });
    }

}
