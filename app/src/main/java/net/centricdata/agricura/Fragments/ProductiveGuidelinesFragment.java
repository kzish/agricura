package net.centricdata.agricura.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.centricdata.agricura.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductiveGuidelinesFragment extends Fragment {


    public ProductiveGuidelinesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Productive Guidelines");
        View view = inflater.inflate(R.layout.fragment_productive_guidelines, container, false);

        return view;
    }

}
