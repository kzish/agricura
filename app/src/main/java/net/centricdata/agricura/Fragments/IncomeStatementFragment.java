package net.centricdata.agricura.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import net.centricdata.agricura.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class IncomeStatementFragment extends Fragment {


    private Spinner spinner;
    private String[] test = {"Macademia","Maize","Tea","Tobacco","Wheat"};
    //private TextView currentEdit;
    public IncomeStatementFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_income_statement2, container, false);
        //currentEdit= (TextView) view.findViewById((R.id.txtIncomeDropDown));
        spinner = (Spinner) view.findViewById(R.id.incomeExpDropDown);
        ArrayAdapter<CharSequence> mSortAdapter = new ArrayAdapter<CharSequence>(getActivity(), android.R.layout.simple_spinner_item, test);
        mSortAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(mSortAdapter);
        return view;

    }

}
