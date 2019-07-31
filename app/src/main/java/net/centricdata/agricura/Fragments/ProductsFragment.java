package net.centricdata.agricura.Fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
        products.add(new Products("Accaricide","insecticide_image","DYNAMEC (ABAMECTIN) 18 EC ","Contact and translaminar insecticide/miticide for controlling pests in various crops", "500ml, 1ltr" ));
        products.add(new Products("Mineral Oil","insecticide_image","ORCHEX ","Mineral oil targeting various pests in various fruit trees ", "200ml, 500ml, 5ltr" ));
        products.add(new Products("Mineral Oil","insecticide_image","Mitac","An amitraz based accaricide for controlling pests in various crops", "100ml, 200ml, 500ml" ));
        products.add(new Products("Rodenticide","insecticide_image","SUPER RAT KILL ","An anticoagulant rodenticide used in and around human and animal dwellings ", "300g" ));
        products.add(new Products("Grain Protecterant","insecticide_image","ACTELLIC GOLD DUST ","Grain protectarant for use against storage pests", "200g" ));
        products.add(new Products("Grain Protecterant","insecticide_image","SHUMBA PLUS ","Grain protectarant for use against storage pests", "200g" ));
        products.add(new Products("Fungicide","insecticide_image","Bion 50WP","A selective, systemic compound used for the control of fungal and bacterial diseases", "60g" ));
        products.add(new Products("Fungicide","insecticide_image","Bravo","Contact, for the prevention of various diseases in various crops ", "200ml, 500ml, 1ltr, 5ltr" ));
        products.add(new Products("Fungicide","insecticide_image","COPPER OXY 85WP","Contact and systemic for the control of various pests in various crops", "200g, 500g" ));
        products.add(new Products("Nematicide","insecticide_image","SOLVIGO 108SC","Contact and systemic for the control of various pests in various crops", "1ltr" ));
        products.add(new Products("Herbicide","insecticide_image","ACCENT (NICOSULFURON) 75WG ","Systemic, post emergent for the control of certain weeds in maize", "45g" ));
        products.add(new Products("Herbicide","insecticide_image","KALIF 48EC ","Pre-emergent for the controll of weeds in tobacco, soyabeans and sugar beans", "10ml, 1ltr" ));
        products.add(new Products("Suckercide","insecticide_image","AGRITOP ","Systemic for the effective controll of suckers in tobacco ", "1ltr, 5ltr, 201tr" ));
        products.add(new Products("Wetter","insecticide_image","AGRIWETT ","General purpose non-ionic wetter and sticker for agricultural sprays ", "200ml, 500ml, 5ltr" ));
        products.add(new Products("Suckercide","insecticide_image","Deka (Decanol) 79EC ","Contact, for the effective control of suckers in tobacco", "1ltr, 5ltr, 10ltr, 20ltr" ));
        products.add(new Products("Dip","insecticide_image","Cypermethrin Dog Rinse (Bot)","Dog dip for controlling ticks ", "200ml" ));
        products.add(new Products("Dip","insecticide_image","SENTINEL TICK DRESSING  ","General purpose non-ionic wetter and sticker for agricultural sprays ", "500g" ));
        products.add(new Products("Fertilizer","insecticide_image","COMPOUND D  ","A basal dressing fertilizer for use in most cereal crops and other crops such as maize, sugar beans", "50kg" ));
        products.add(new Products("Dip","insecticide_image","CYPERMETHRIN DOG RINSE ","Dog dip for controlling ticks ", "200ml" ));
        products.add(new Products("Fertilizer","insecticide_image","COMPOUND C (TOBACCO FERT.)  ","A basal dressing fertilizer for use in most horticultural crops such as tomatoes, cabbages","50kg"));
        products.add(new Products("Fertilizer","insecticide_image","AMMONIUM NITRE 34.5N ","A top dressing fertilizer for use in various crops such as maize, tomatoes, tobacco, cabbages","50kg"));
        products.add(new Products("Fumigant","insecticide_image","ALUMINIUM PHOSPHATE TABS  ","A multipurpose highly toxic inorganic compound used for fumigation ", "90g, 1kg" ));
        products.add(new Products("Fungicide","insecticide_image","LIME SULPHUR ","For controlling pests and diseases ", "200ml, 500ml" ));
        products.add(new Products("Dip","insecticide_image","CYPERMETHRIN DOG RINSE ","Dog dip for controlling ticks ", "200ml" ));
        products.add(new Products("Fertilizer","insecticide_image","COMPOUND C (TOBACCO FERT.)  ","A basal dressing fertilizer for use in most horticultural crops such as tomatoes, cabbages","50kg"));
        products.add(new Products("Fertilizer","insecticide_image","AMMONIUM NITRE 34.5N ","A top dressing fertilizer for use in various crops such as maize, tomatoes, tobacco, cabbages","50kg"));
        products.add(new Products("Dose","insecticide_image","RAFAZOLE 1  ","A broad spectrum multipurpose anthelmintic ","500ml, 1ltr, 5ltr"));
        products.add(new Products("Dose","insecticide_image","ZEROFEN ","A broad spectrum multipurpose anthelmintic ","200ml, 1ltr"));

        //products.add(new Products("Ola","insecticide_image","Msuzo 75%","Contact and systemic for the control of various pests in various crops", "500g,1kg" )); 45gm


        ArrayList<Products> productsToshow= new ArrayList<>();
        for (Products  p: products)
            if (p.prodCategory== catToShow){
                productsToshow.add(p);
            }

        return  productsToshow;
    }

}
