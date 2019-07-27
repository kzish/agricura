package net.centricdata.agricura.Fragments;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import net.centricdata.agricura.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class IncomeStatementFragment extends Fragment {


    private Spinner spinner;
    private String[] test = {"Macademia","Maize","Tea","Tobacco","Wheat"};
    private Button buttonEditReturns;
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

        buttonEditReturns = (Button) view.findViewById(R.id.btn_EnterExpenses);

        buttonEditReturns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //PD.passData(productName);
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                Fragment fragment=new IncomeFragment();

                FragmentTransaction ft =  activity.getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.content_main, fragment);
                ft.addToBackStack("income_statement");
                ft.commit();
            }
        });

        return view;

    }

}
