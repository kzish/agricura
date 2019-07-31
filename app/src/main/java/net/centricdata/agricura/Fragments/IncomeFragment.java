package net.centricdata.agricura.Fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import net.centricdata.agricura.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class IncomeFragment extends Fragment {


    Button editExp;
    Button finalStatement;
    private ImageButton buttonSummaryStatement;
    private ArrayList<String> returnsList = new ArrayList<>();
    public IncomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_income, container, false);
        editExp= (Button) view.findViewById(R.id.btn_EditExp);
        buttonSummaryStatement= (ImageButton) view.findViewById(R.id.imageButtonFullIncome2);

        editExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //PD.passData(productName);
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                Fragment fragment=new IncomeStatementFragment();

                FragmentTransaction ft =  activity.getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.content_main, fragment);
                ft.addToBackStack("income_statement");
                ft.commit();
            }
        });
        buttonSummaryStatement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //PD.passData(productName);
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                Fragment fragment=new SummaryStatementFragment();
                Bundle bundle= new Bundle();
                bundle.putStringArrayList("Expenses",returnsList);
                //bundle.putString("pname", mproducts.get(i).prodName);
                FragmentTransaction ft =  activity.getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.content_main, fragment);
                ft.addToBackStack("income_statement");
                ft.commit();
            }
        });


        return view;
    }

}
