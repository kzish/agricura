package net.centricdata.agricura.Fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import net.centricdata.agricura.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class IncomeStatementFragment extends Fragment {


    private Spinner spinner;
    private String[] test = {"Macademia","Maize","Tea","Tobacco","Wheat"};
    private Button buttonEditReturns;
    private ImageButton buttonSummaryStatement;
    private ArrayList<String> expenseList = new ArrayList<>();
    //private TextView currentEdit;
    private String inExp1="0", inExp2="0", inExp3="0", inExp4="0", inExp5="0",inExp6="0";
    private EditText inExpT1, inExpT2, inExpT3, inExpT4, inExpT5,inExpT6;
    Button buttonSaveValues;

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
        buttonSummaryStatement= (ImageButton) view.findViewById(R.id.imageButtonFullIncome1);
        buttonSaveValues= (Button) view.findViewById(R.id.btn_saveValues1);

        inExpT1= (EditText) view.findViewById(R.id.txtEditExp1);
        inExpT2= (EditText) view.findViewById(R.id.txtEditExp2);
        inExpT3= (EditText) view.findViewById(R.id.txtEditExp3);
        inExpT5= (EditText) view.findViewById(R.id.txtEditExp4);
        inExpT6= (EditText) view.findViewById(R.id.txtEditExp5);
        inExpT4= (EditText) view.findViewById(R.id.txtEditExp6);
        inExpT1.setText("0");
        inExpT2.setText("0");
        inExpT3.setText("0");
        inExpT4.setText("0");
        inExpT5.setText("0");
        inExpT6.setText("0");

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
        buttonSummaryStatement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //PD.passData(productName);

                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                Fragment fragment=new SummaryStatementFragment();
                Bundle bundle= new Bundle();
                bundle.putStringArrayList("Expenses",expenseList);
                //bundle.putString("pname", mproducts.get(i).prodName);
                FragmentTransaction ft =  activity.getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.content_main, fragment);
                ft.addToBackStack("income_statement");
                ft.commit();
            }
        });
        buttonSaveValues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                inExp1= inExpT1.getText().toString();
                inExp2= inExpT2.getText().toString();
                inExp3= inExpT3.getText().toString();
                inExp4= inExpT4.getText().toString();
                inExp5= inExpT5.getText().toString();
                inExp6= inExpT6.getText().toString();


                //PD.passData(productName);
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                Fragment fragment=new SummaryStatementFragment();
                Bundle bundle= new Bundle();
                bundle.putStringArrayList("Expenses",expenseList);
                bundle.putString("Exp1", inExp1);
                bundle.putString("Exp2", inExp2);
                bundle.putString("Exp3", inExp3);
                bundle.putString("Exp4", inExp4);
                bundle.putString("Exp5", inExp5);
                bundle.putString("Exp6", inExp6);
                fragment.setArguments(bundle);
                FragmentTransaction ft =  activity.getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.content_main, fragment);
                ft.addToBackStack("income_statement");
                ft.commit();
            }
        });


        return view;

    }

}
