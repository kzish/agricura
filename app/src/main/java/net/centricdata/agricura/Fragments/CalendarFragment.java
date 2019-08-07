package net.centricdata.agricura.Fragments;


import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.riontech.calendar.CustomCalendar;
import com.riontech.calendar.dao.EventData;
import com.riontech.calendar.dao.dataAboutDate;

import net.centricdata.agricura.R;
import net.centricdata.agricura.Utils.CalendarUtils;

import java.util.ArrayList;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class CalendarFragment extends Fragment{

    private CustomCalendar customCalendar;
    Button btn_cancel, btn_saveEvent;
    EditText editTextEventTitle, editTextEventDate, editTextEventDescription;


    public CalendarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Calendar");
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);

        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Add New Event", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                showAddEventDialog();
            }
        });

        customCalendar = view.findViewById(R.id.customCalendar);

        String[] arr = {"2019-08-10", "2019-08-11", "2019-08-15", "2019-08-16", "2019-08-26", "2019-08-25"};
        for (int i = 0; i < arr.length; i++) {
            int eventCount = 3;
            customCalendar.addAnEvent(arr[i], eventCount, getEventDataList(eventCount));
            //customCalendar.setBottom(3);

        }

        return view;
    }

    private void showAddEventDialog() {
        AlertDialog.Builder alert;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            alert = new AlertDialog.Builder(getContext(), android.R.style.Theme_Material_Dialog_Alert);
            }
        else {
            alert = new AlertDialog.Builder(getContext());
        }

        LayoutInflater inflater = getLayoutInflater();
        View myView = inflater.inflate(R.layout.fragment_add_event, null);

        editTextEventTitle  = myView.findViewById(R.id.EditTextEventName);
        editTextEventDate  = myView.findViewById(R.id.EditTextDate);
        editTextEventDescription  = myView.findViewById(R.id.EditTextDescription);

        btn_saveEvent = myView.findViewById(R.id.btn_save_new_event);
        btn_cancel = myView.findViewById(R.id.btn_cancel);

        alert.setView(myView);
        alert.setCancelable(false);

        btn_saveEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eventTitle = editTextEventTitle.getText().toString();
                String eventDate = editTextEventDate.getText().toString();
                String eventDescription = editTextEventDescription.getText().toString();
                String allDataTemp = "Added Event" + "\n" +eventTitle + "\n" + eventDate + "\n" + eventDescription;
                Toast.makeText(getActivity().getApplicationContext(), allDataTemp, Toast.LENGTH_SHORT).show();
            }
        });

        final AlertDialog dialog = alert.create();
        //dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.setTitle("Add New Custom Event");

        dialog.show();

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }

    public ArrayList<EventData> getEventDataList(int count) {
        ArrayList<EventData> eventDataList = new ArrayList();

        for (int i = 0; i < count; i++) {
            EventData dateData = new EventData();
            ArrayList<dataAboutDate> dataAboutDates = new ArrayList();

            dateData.setSection(CalendarUtils.getNAMES()[new Random().nextInt(CalendarUtils.getNAMES().length)]);
            dataAboutDate dataAboutDate = new dataAboutDate();

            int index = new Random().nextInt(CalendarUtils.getEVENTS().length);

            dataAboutDate.setTitle(CalendarUtils.getEVENTS()[index]);
            dataAboutDate.setSubject(CalendarUtils.getEventsDescription()[index]);
            dataAboutDates.add(dataAboutDate);

            dateData.setData(dataAboutDates);
            eventDataList.add(dateData);
        }

        return eventDataList;
    }

}
