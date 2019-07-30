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
import android.os.Handler;
import android.provider.Settings;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import net.centricdata.agricura.R;
import net.centricdata.agricura.Weather.DayForecastObject;
import net.centricdata.agricura.Weather.WeatherViewAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static java.time.LocalDate.now;


public class WeatherFragment extends Fragment {

    static String latitude;
    //= "-17.8581";
    static String longitude;
    //= "31.0553";

    public WeatherFragment() {
        // Required empty public constructor
    }


    private static final int REQUEST_LOCATION=1;

    Button getLocationBtn;
    TextView showLocationTxt, showDateToday, showCurrentTemp, errorShower;
    ImageView weatherIcon;

    SwipeRefreshLayout mySwipeWeather;
    LocationManager locationManager;

    private ArrayList<DayForecastObject> forecastList;
    private WeatherViewAdapter adapter;
   public static final String API_URL = "http://api.openweathermap.org/data/2.5/forecast/daily?id=4670592&cnt=6&units=metric&APPID=5ce3af43784cd035386cb1fe3ee4bd60";

   // public static final String API_URL = "http://api.openweathermap.org/data/2.5/forecast/daily?lat="+ latitude +" &lon=" +longitude +"&cnt=10&units=metric&APPID=5ce3af43784cd035386cb1fe3ee4bd60";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_weather,
                container, false);

        //adding location permissions


        ActivityCompat.requestPermissions(this.getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);

        showCurrentTemp = view.findViewById(R.id.show_current_temp);
        showDateToday = view.findViewById(R.id.txtViewDate_today);
        mySwipeWeather = view.findViewById(R.id.weekly_refresh_layout);
        weatherIcon = view.findViewById(R.id.imgViewWeatherIconFr);

        mySwipeWeather.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                forecastList = new ArrayList<>(5);

             //   showWeather();

                RecyclerView weekRecyclerView = (RecyclerView) view.findViewById(R.id.weekRecyclerView);
                weekRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                adapter = new WeatherViewAdapter(forecastList);
                weekRecyclerView.setAdapter(adapter);
                new WeatherTask().execute();

                String myDate;

                //myDate = DateFormat.getDateInstance().format(new Date());
                myDate = DateFormat.getDateTimeInstance().format(new Date());

                showDateToday.setText("Today is: " + myDate);
                showCurrentTemp.setText("Current Temp is: " + "20\'");
                weatherIcon.setImageResource(R.drawable.sun_icon);


                locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

                //Check GPS is enabled or not

                if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER))
                {
                    //Method to enable GPS
                    OnGPS();
                }
                else
                {
                    //GPS is already on

                    getLocation();
                }
            }

        });
Handler mHandler = new Handler();
mHandler.postDelayed(new Runnable() {
    @Override
    public void run() {
        mySwipeWeather.setRefreshing(false);
    }
},2000);


        return view;
    }



    private void getLocation() {
        //Check permissions again
        if(ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) !=
        PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this.getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
        }
        else
        {
            Location LocationGps = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            Location LocationNetwork = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            Location LocationPassive = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);

            if (LocationGps != null)
            {
                double lat = LocationGps.getLatitude();
                double longi = LocationGps.getLongitude();

                latitude = String.valueOf(lat);
                longitude = String.valueOf(longi);

                showLocationTxt.setText("Your current Location" + "\n" + "Latitude= " +latitude + "\n" + "Longitude= " +longitude);
            }

            else if (LocationNetwork != null)
            {
                double lat = LocationNetwork.getLatitude();
                double longi = LocationNetwork.getLongitude();

                latitude = String.valueOf(lat);
                longitude = String.valueOf(longi);

                showLocationTxt.setText("Your current Location" + "\n" + "Latitude= " +latitude + "\n" + "Longitude= " +longitude);
            }

            else if (LocationPassive != null)
            {
                double lat = LocationPassive.getLatitude();
                double longi = LocationPassive.getLongitude();

                latitude = String.valueOf(lat);
                longitude = String.valueOf(longi);

                showLocationTxt.setText("Your current Location" + "\n" + "Latitude= " +latitude + "\n" + "Longitude= " +longitude);
            }

            else
            {
                Toast.makeText(getActivity(),"Can't get your location", Toast.LENGTH_SHORT).show();
            }

            //That's all

        }
    }

    private void OnGPS() {
    final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    builder.setMessage("Enable GPS").setCancelable(false).setPositiveButton("YES", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
        }
    });
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

                        dayForecast.setDt(new SimpleDateFormat("EEE, M/dd/yyyy", Locale.US).format(date));
                        dayForecast.setMax(tempObj.getInt("max"));
                        dayForecast.setMin(tempObj.getInt("min"));
                        dayForecast.setMain(weatherArr.getJSONObject(0).getString("main"));
                        dayForecast.setSpeed(dayObj.getInt("speed"));
                        dayForecast.setHumidity(dayObj.getInt("humidity"));
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
