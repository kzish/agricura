package net.centricdata.agricura.Weather;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.centricdata.agricura.Fragments.DailyFragment;
import net.centricdata.agricura.R;

import java.util.ArrayList;

public class WeatherViewAdapter extends RecyclerView.Adapter<WeatherViewAdapter.WeatherViewHolder> {

    private ArrayList<DayForecastObject> forecastList;

    public WeatherViewAdapter(ArrayList<DayForecastObject> forecastList) {
        this.forecastList = forecastList;
    }

    @Override
    public WeatherViewAdapter.WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_weekly_forecast, null);
        return new WeatherViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(WeatherViewHolder holder, int position) {
        if (forecastList.size() > 0) {
            DayForecastObject currentObj = forecastList.get(position);

            holder.dateTV.setText(currentObj.getDt());
            holder.weatherDescriptionTV.setText(currentObj.getMain());
            holder.descriptionWeather.setText(currentObj.getDescription());
            holder.maxTempTV.setText("MAX: " + currentObj.getMax() + " °C");
            holder.minTempTV.setText("MIN: " + currentObj.getMin() + " °C");
        }
    }

    @Override
    public int getItemCount() {
        return forecastList.size();
    }


    class WeatherViewHolder extends RecyclerView.ViewHolder implements RecyclerView.OnClickListener {

        TextView dateTV;
        TextView weatherDescriptionTV;
        TextView maxTempTV;
        TextView minTempTV;
        TextView descriptionWeather;

        WeatherViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            dateTV = itemView.findViewById(R.id.dt);
            weatherDescriptionTV = itemView.findViewById(R.id.main);
            maxTempTV = itemView.findViewById(R.id.maxTemp);
            minTempTV = itemView.findViewById(R.id.minTemp);
            descriptionWeather = itemView.findViewById(R.id.tVDescription);
        }

        @Override
        public void onClick(View view) {
            FragmentActivity activity = (FragmentActivity) view.getContext();
            DailyFragment dailyFragment = new DailyFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("dayForecast", forecastList.get(getAdapterPosition()));
            dailyFragment.setArguments(bundle);
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.weekly_refresh_layout, dailyFragment).addToBackStack(null).commit();
        }
    }
}
