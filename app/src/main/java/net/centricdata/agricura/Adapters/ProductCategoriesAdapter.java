package net.centricdata.agricura.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import net.centricdata.agricura.Fragments.ProductsFragment;
import net.centricdata.agricura.Models.ProductCategories;
import net.centricdata.agricura.Models.Products;
import net.centricdata.agricura.R;

import java.util.ArrayList;
import java.util.List;

public class ProductCategoriesAdapter extends RecyclerView.Adapter<ProductCategoriesAdapter.ViewHolder> {

    private List<ProductCategories> mproductCategories;
    private LayoutInflater mInflater;
    private View.OnClickListener onClickListener;
    private String catName;
    private Context mcontext;
    private ImageView catImage;

    static String st;
    public static String get() {

        st="Ola";

        return st;
    }

    public ProductCategoriesAdapter( ArrayList<ProductCategories> productCategories) {

        mproductCategories= productCategories;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context= viewGroup.getContext();
        mcontext= context;
        mInflater= LayoutInflater.from(context);
        View view = mInflater.inflate(R.layout.row_product_category, viewGroup, false);
        catImage= (ImageView) view.findViewById(R.id.imgCategory);
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder,final int i) {


        ProductCategories productCategories= mproductCategories.get(i);
        TextView textView1= viewHolder.catNameTextView;
        textView1.setText(productCategories.getCatName());
        viewHolder.catNameTextView.setText((mproductCategories.get(i).getCatName()));
        viewHolder.catDescriptionTextView.setText((mproductCategories.get(i).getCatDescription()));
        String uri= "android.resource://net.centricdata.agricura/drawable/"+mproductCategories.get(i).getImageName().toLowerCase();
        Picasso.with(mcontext).load(uri).into(catImage);


        viewHolder.cardViewProductCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Fragment fragment=new ProductsFragment();
                Products products= new Products(mproductCategories.get(i).getCatName(),"","","", "" );


                Bundle bundle= new Bundle();
                bundle.putString("cname", mproductCategories.get(i).getCatName());
                fragment.setArguments(bundle);
                FragmentTransaction ft =  activity.getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.content_main, fragment);
                ft.addToBackStack("productCategories");
                ft.commit();
            }

        });







    }

    @Override
    public int getItemCount() {

        return mproductCategories.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView catNameTextView;
        public TextView catDescriptionTextView;
        public Button infoButton;
        public TextView proCount;
        public TextView productsCount;
        public CardView cardViewProductCategories;

        public ViewHolder(View itemView) {



            super(itemView);
            itemView.setTag(this);
            //itemView.setOnClickListener();

            catNameTextView = (TextView) itemView.findViewById(R.id.txtProductCatName);
            catDescriptionTextView= (TextView) itemView.findViewById(R.id.txtProductCatDescription);
            //infoButton = (Button) itemView.findViewById(R.id.buttonInfo);
            //productsCount= (TextView) itemView.findViewById(R.id.txtProductCatCount);
            cardViewProductCategories= (CardView) itemView.findViewById(R.id.card_product_categories);


        }


    }




}
