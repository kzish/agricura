package net.centricdata.agricura.Fragments.Crops;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.centricdata.agricura.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Potatoes extends Fragment {


    public Potatoes() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_potatoes, container, false);

        return view;
    }

}
