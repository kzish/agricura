package net.centricdata.agricura.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

import net.centricdata.agricura.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class SingleProductFragment extends Fragment {


    String productName;
    Button buttonPests;
    PassData PD;
    String diseaseName;
    String pTitle;
    TextView productNameTextView;

    public SingleProductFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_single_product, container, false);
        pTitle = getArguments().getString("pname");



        getActivity().setTitle(pTitle);

        //productName= view.findViewById(R.id.txtProductName).toString();
        productNameTextView= view.findViewById(R.id.txtProductCatName);
        //productNameTextView.setText("Prozozo");

        buttonPests= view.findViewById(R.id.btn1ProductPests);


        buttonPests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //PD.passData(productName);
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                Fragment fragment=new ProductDiseaseFragment();

                FragmentTransaction ft =  activity.getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.content_main, fragment);
                ft.addToBackStack("products");
                ft.commit();
            }
        });
        //getActivity().setTitle("Product Details");
        return view;
    }

    private  void ShowPests(){

        //buttonPests.onKeyDown()
    }

    public interface PassData {

        void passData(String productName);
    }

    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            PD = (PassData) getActivity();
        }
        catch (ClassCastException e) {
            throw new ClassCastException("Error getting Name");
        }
    }
    public void passDiseaseInfo(String productName) {
        diseaseName= productName;
    }

}
