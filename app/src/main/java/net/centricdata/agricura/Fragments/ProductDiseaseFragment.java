package net.centricdata.agricura.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.centricdata.agricura.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductDiseaseFragment extends Fragment {

    //String productName;
    TextView diseaseName;

    public ProductDiseaseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_product_disease, container, false);
        //productName= view.findViewById(R.id.txtProductName).toString();
        diseaseName= view.findViewById(R.id.txtDiseaseName);

        return view;



    }

    public void passDiseaseInfo(String productName){
        productName="sdfsd";
        diseaseName.setText(productName);
    }



}
