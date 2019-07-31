package net.centricdata.agricura.Fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import net.centricdata.agricura.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SummaryStatementFragment extends Fragment {


    private String inExp1="0", inExp2="0", inExp3="0", inExp4="0", inExp5="0",inExp6="0";
    TextView expenseList;
    public SummaryStatementFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_summary_statement, container, false);
        expenseList= (TextView) view.findViewById(R.id.textExpenseValuesValues);


        inExp1= getArguments().getString("Exp1");
        inExp2= getArguments().getString("Exp2");
        inExp3= getArguments().getString("Exp3");
        inExp4= getArguments().getString("Exp4");
        inExp5= getArguments().getString("Exp2");
        inExp6= getArguments().getString("Exp1");

        expenseList.setText("Your Expenses for Macademia were \n"+ "$"+inExp1+"\n" + "$"+ inExp2+"\n"+ "$"+inExp3+"\n" + "$"+ inExp4+"\n"+ "$"+inExp5+"\n" + "$"+ inExp6+"\n");


        return view;
    }

}
