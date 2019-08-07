package net.centricdata.agricura.Fragments;


import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kwabenaberko.openweathermaplib.constants.Lang;
import com.kwabenaberko.openweathermaplib.constants.Units;
import com.kwabenaberko.openweathermaplib.implementation.OpenWeatherMapHelper;
import com.kwabenaberko.openweathermaplib.implementation.callbacks.CurrentWeatherCallback;
import com.kwabenaberko.openweathermaplib.models.currentweather.CurrentWeather;

import net.centricdata.agricura.R;
import net.centricdata.agricura.Weather.DayForecastObject;
import net.centricdata.agricura.Weather.WeatherViewAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import im.delight.android.location.SimpleLocation;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.crashlytics.android.core.CrashlyticsCore.TAG;
import static java.time.LocalDate.now;


public class WeatherFragment<view> extends Fragment {

    static double latitude = 0;
    static double longitude = 0;

    public WeatherFragment() {
        // Required empty public constructor
    }
    private View view;

    private static final int REQUEST_LOCATION=1;

    Button getLocationBtn;
    TextView showLocationTxt, showDateToday, showCurrentTemp, errorShower;
    ImageView weatherIcon;

    SwipeRefreshLayout mySwipeWeather;
    private LocationManager locationManager;
    private SimpleLocation location;

    private ArrayList<DayForecastObject> forecastList;
    private WeatherViewAdapter adapter;

    //public static final String API_URL = "http://api.openweathermap.org/data/2.5/forecast/daily?id=890299&cnt=6&units=metric&APPID=5ce3af43784cd035386cb1fe3ee4bd60";

    // public static final String API_URL = "http://api.openweathermap.org/data/2.5/forecast/daily?lat="+ latitude +" &lon=" +longitude +"&cnt=10&units=metric&APPID=5ce3af43784cd035386cb1fe3ee4bd60";
    public static final String API_URL = "http://api.openweathermap.org/data/2.5/forecast/daily?lat="+ latitude +"&lon=" +longitude +"&cnt=6&units=metric&APPID=5ce3af43784cd035386cb1fe3ee4bd60";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //final View
        view = inflater.inflate(R.layout.fragment_weather,
                container, false);

        weatherIcon = view.findViewById(R.id.imgViewWeatherIconFr);
        weatherIcon.setImageResource(R.drawable.sunny);

        showWeather();
        showCurrentWeather();
        //adding location permissions

        ActivityCompat.requestPermissions(this.getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);

        mySwipeWeather = view.findViewById(R.id.weekly_refresh_layout);

        mySwipeWeather.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                showWeather();
            }
        });

        mySwipeWeather.setRefreshing(false);
        return view;
    }

    private void showCurrentWeather() {

        OpenWeatherMapHelper helper = new OpenWeatherMapHelper(getString(R.string.OPEN_WEATHER_MAP_API_KEY));

        helper.setUnits(Units.METRIC);
        helper.setLang(Lang.ENGLISH);

        helper.getCurrentWeatherByGeoCoordinates(latitude, longitude, new CurrentWeatherCallback() {
            @Override
            public void onSuccess(CurrentWeather currentWeather) {

                double avg_temp = currentWeather.getMain().getTemp();
                String tempAvg = String.valueOf(avg_temp);
                showCurrentTemp.setText("Current Temp is: " + tempAvg + "°C" );
                weatherIcon.setImageResource(R.drawable.sunny);

            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.v(TAG, throwable.getMessage());
            }
        });

    }

    private View showWeather() {

        forecastList = new ArrayList<>(6);

        //LayoutInflater inflater = getLayoutInflater();
        //View myView = inflater.inflate(R.layout.fragment_weather, null);

        showCurrentTemp = view.findViewById(R.id.show_current_temp);
        showDateToday = view.findViewById(R.id.txtViewDate_today);
        //weatherIcon = view.findViewById(R.id.imgViewWeatherIconFr);

        RecyclerView weekRecyclerView = (RecyclerView) view.findViewById(R.id.weekRecyclerView);
        weekRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new WeatherViewAdapter(forecastList);
        weekRecyclerView.setAdapter(adapter);
        new WeatherTask().execute();

        String myDate;

        //myDate = DateFormat.getDateInstance().format(new Date());
        myDate = DateFormat.getDateTimeInstance().format(new Date());

        showDateToday.setText("Today is: " + myDate);


        getCoordinates();

        mySwipeWeather = view.findViewById(R.id.weekly_refresh_layout);
        mySwipeWeather.setRefreshing(false);
        return view;
    }

    private void getCoordinates() {
        location = new SimpleLocation(getActivity());

        if (!location.hasLocationEnabled()){
            //asking the user for permissions for location access
            SimpleLocation.openSettings(getActivity());
        }

        latitude = location.getLatitude();
        longitude = location.getLongitude();

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        forecastList = new ArrayList<>(5);
    }

    class WeatherTask extends AsyncTask<Void, Void, String> {


        @Override
        protected String doInBackground(Void... voids) {
            return fetchWeeklyWeather(API_URL);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            if (s.equalsIgnoreCase("Exception caught")) {
                Toast.makeText(getContext(), "No Results Found", Toast.LENGTH_SHORT).show();
            } else {
                adapter.notifyDataSetChanged();
                System.out.println("SETTING UPDATED ADAPTER AND GIF LIST");
            }        }
    }

    public String fetchWeeklyWeather(String url) {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Response responses;

            try {
                DayForecastObject dayForecast;
                responses = client.newCall(request).execute();
                forecastList.clear();

                String jsonData = responses.body().string();

                JSONObject jsonObj = new JSONObject(jsonData);
                JSONArray listArray = jsonObj.getJSONArray("list");

                for (int i = 0; i < listArray.length(); i++) {
                    if (i != 0) {
                        JSONObject dayObj = listArray.getJSONObject(i);
                        JSONObject tempObj = dayObj.getJSONObject("temp");
                        JSONArray weatherArr = dayObj.getJSONArray("weather");

                        dayForecast = new DayForecastObject();
                        long time = Long.parseLong(dayObj.getString("dt"));
                        Date date = new Date(time * 1000);

                        dayForecast.setDt(new SimpleDateFormat("E, dd MMM yyyy", Locale.US).format(date));
                        dayForecast.setMax(tempObj.getInt("max"));
                        dayForecast.setMin(tempObj.getInt("min"));
                        dayForecast.setMain(weatherArr.getJSONObject(0).getString("main"));
                        dayForecast.setSpeed(dayObj.getInt("speed"));
                        dayForecast.setHumidity(dayObj.getInt("humidity"));
                        dayForecast.setDescription(weatherArr.getJSONObject(0).getString("description"));
                        forecastList.add(dayForecast);
                    }
                }

                responses.body().close();

            } catch (IOException e) {
                e.printStackTrace();
            }

            return ("OK");

        } catch (JSONException e) {
            e.printStackTrace();

            errorShower = getView().findViewById(R.id.textViewErrorShow);
            errorShower.setText("No Network or Weather not found");
            return ("Exception Caught");
        }
    }
}
