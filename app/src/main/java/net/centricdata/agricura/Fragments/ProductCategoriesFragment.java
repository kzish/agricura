package net.centricdata.agricura.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.centricdata.agricura.Adapters.ProductCategoriesAdapter;
import net.centricdata.agricura.Models.Branches;
import net.centricdata.agricura.Models.ProductCategories;
import net.centricdata.agricura.R;

import org.greenrobot.greendao.query.Query;

import java.util.ArrayList;



/**
 * A simple {@link Fragment} subclass.
 */
public class ProductCategoriesFragment extends Fragment {

    ArrayList<ProductCategories> productCategories;
    RecyclerView productCategoriesRecycler;
    ProductCategoriesAdapter productCategoriesAdapter;
    private Query<ProductCategories> productCategoriesQuery;



    public ProductCategoriesFragment() {



    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_categories, container, false);
        // Required empty public constructor
        productCategoriesRecycler= view.findViewById(R.id.recycle_product_categories);


        // Initialize
        productCategories= ProductCategories.createProductCategoriesList();

        ProductCategoriesAdapter adapter= new ProductCategoriesAdapter(productCategories);

        productCategoriesRecycler.setAdapter(adapter);

        productCategoriesRecycler.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;

    }

    public interface catSe {
        public void onArticleSelected(int position);
    }

}
