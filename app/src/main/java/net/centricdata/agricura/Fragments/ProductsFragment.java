package net.centricdata.agricura.Fragments;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.centricdata.agricura.Adapters.ProductsAdapter;
import net.centricdata.agricura.Models.Products;
import net.centricdata.agricura.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductsFragment extends Fragment {

    ArrayList<Products> products;
    RecyclerView productsRecycler;
    ProductsAdapter productsAdapter;

    public ProductsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_products, container, false);

        productsRecycler= view.findViewById(R.id.recycle_products);

        getActivity().setTitle("Products");




        // Initialize
        products= Products.createProductsList();

        ProductsAdapter adapter= new ProductsAdapter(products);

        productsRecycler.setAdapter(adapter);

        productsRecycler.setLayoutManager(new LinearLayoutManager(getContext()));


        return  view;
    }

}
