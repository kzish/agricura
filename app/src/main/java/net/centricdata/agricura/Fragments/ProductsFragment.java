package net.centricdata.agricura.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.centricdata.agricura.Adapters.ProductCategoriesAdapter;
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
    public String categoryToShow;

    public ProductsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_products, container, false);

        categoryToShow= getArguments().getString("cname");
        productsRecycler= view.findViewById(R.id.recycle_products);

        getActivity().setTitle("Products");




        // Initialize
        products= ProductsFragment.createProductsList(categoryToShow);

        ProductsAdapter adapter= new ProductsAdapter(products);

        productsRecycler.setAdapter(adapter);

        productsRecycler.setLayoutManager(new LinearLayoutManager(getContext()));


        return  view;
    }
    public static ArrayList<Products> createProductsList(String catToShow){


        ArrayList<Products> products= new ArrayList<>();

        products.add(new Products("Insecticide","insecticide_image","Acephate 75%","Contact and systemic for the control of various pests in various crops", "500g,1kg" ));
        products.add(new Products("Insecticide","insecticide_image","Thiamethoxam 25WG","Systemic for the control of sap sucking pests in tobacco, tomatoes and various crops", "200g,500g" ));
        products.add(new Products("Insecticide","insecticide_image","Aphid Kill","Emulsifiable concentrate, contact for the control of pests in various crops ", "100ml,200ml" ));
        products.add(new Products("Insecticide","insecticide_image","Avaunt (Indoxacarb) 15SC","Contact for fast and broad-spectrum control of many worm pests and other insects ", "200ml,500ml" ));
        products.add(new Products("Insecticide","insecticide_image","Acetamark ","Systemic for controlling sap sucking pests in cotton, tomatoes and various crops", "50g,100g, 500g" ));
        products.add(new Products("Bait","insecticide_image","GF120 N BAIT ","Bait concentrate for use in horticultural crops, deciduos fruit trees, citrus ", "500ml" ));
        products.add(new Products("Accaricide","accaricide","DICOFOL 18.5% EC","Emulsifiable concentrate contact organochlorine for controlling pests in various crops", "100ml,200ml, 5ltr" ));
        products.add(new Products("Accaricide","insecticide_image","ABAMECTIN 18EC 100ML","Contact and translaminar insecticide/miticide for controlling pests in various crops", "100ml, 500ml" ));
        products.add(new Products("Insecticide","insecticide_image","Acephate 75%","Contact and systemic for the control of various pests in various crops", "500g,1kg" ));
        products.add(new Products("Insecticide","insecticide_image","Acephate 75%","Contact and systemic for the control of various pests in various crops", "500g,1kg" ));
        products.add(new Products("Insecticide","insecticide_image","Acephate 75%","Contact and systemic for the control of various pests in various crops", "500g,1kg" ));
        products.add(new Products("Insecticide","insecticide_image","Acephate 75%","Contact and systemic for the control of various pests in various crops", "500g,1kg" ));
        products.add(new Products("Insecticide","insecticide_image","Acephate 75%","Contact and systemic for the control of various pests in various crops", "500g,1kg" ));
        products.add(new Products("Insecticide","insecticide_image","Acephate 75%","Contact and systemic for the control of various pests in various crops", "500g,1kg" ));
        products.add(new Products("Insecticide","insecticide_image","Acephate 75%","Contact and systemic for the control of various pests in various crops", "500g,1kg" ));
        products.add(new Products("Insecticide","insecticide_image","Acephate 75%","Contact and systemic for the control of various pests in various crops", "500g,1kg" ));
        products.add(new Products("Insecticide","insecticide_image","Acephate 75%","Contact and systemic for the control of various pests in various crops", "500g,1kg" ));
        products.add(new Products("Insecticide","insecticide_image","Acephate 75%","Contact and systemic for the control of various pests in various crops", "500g,1kg" ));
        //products.add(new Products("Ola","insecticide_image","Msuzo 75%","Contact and systemic for the control of various pests in various crops", "500g,1kg" ));


        ArrayList<Products> productsToshow= new ArrayList<>();
        for (Products  p: products)
            if (p.prodCategory== catToShow){
                productsToshow.add(p);
            }

        return  productsToshow;
    }

}
