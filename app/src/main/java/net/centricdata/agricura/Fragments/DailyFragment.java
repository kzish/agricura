package net.centricdata.agricura.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.centricdata.agricura.R;
import net.centricdata.agricura.Weather.DayForecastObject;


public class DailyFragment extends Fragment {

    private DayForecastObject dayForecastObject;
    private ForecastFragment.OnFragmentInteractionListener mListener;

    public DailyFragment() {
        // Required empty public constructor
    }

       @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if (getArguments() != null) {
                dayForecastObject = (DayForecastObject) this.getArguments().getSerializable("dayForecast");
            }
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_daily, container, false);

            TextView dateTV = (TextView) view.findViewById(R.id.dt);
            TextView mainTV = (TextView) view.findViewById(R.id.main);
            TextView maxTV = (TextView) view.findViewById(R.id.maxTemp);
            TextView minTV = (TextView) view.findViewById(R.id.minTemp);
            TextView speedTV = (TextView) view.findViewById(R.id.speed);
            TextView humidityTV = (TextView) view.findViewById(R.id.humidity);

            if (dayForecastObject != null) {
                dateTV.setText(dayForecastObject.getDt());
                mainTV.setText(dayForecastObject.getMain());
                maxTV.setText("MAX: " + String.valueOf(dayForecastObject.getMax()) + " °F");
                minTV.setText("MIN: " + String.valueOf(dayForecastObject.getMin()) + " °F");
                speedTV.setText(String.valueOf(dayForecastObject.getSpeed()) + " mph");
                humidityTV.setText(String.valueOf(dayForecastObject.getHumidity()) + " %");
            }

            return view;
        }


    }
