package net.centricdata.agricura.Adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import net.centricdata.agricura.Fragments.ProductsFragment;
import net.centricdata.agricura.Models.ProductCategories;
import net.centricdata.agricura.R;

import java.util.ArrayList;
import java.util.List;

public class ProductCategoriesAdapter extends RecyclerView.Adapter<ProductCategoriesAdapter.ViewHolder> {

    private List<ProductCategories> mproductCategories;
    private LayoutInflater mInflater;
    private View.OnClickListener onClickListener;





    public ProductCategoriesAdapter(ArrayList<ProductCategories> productCategories) {

        mproductCategories= productCategories;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context= viewGroup.getContext();
        mInflater= LayoutInflater.from(context);
        View view = mInflater.inflate(R.layout.row_product_category, viewGroup, false);
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        ProductCategories productCategories= mproductCategories.get(i);
        TextView textView1= viewHolder.catNameTextView;
        textView1.setText(productCategories.getCatName());
        viewHolder.catNameTextView.setText((mproductCategories.get(i).getCatName()));
        viewHolder.catDescriptionTextView.setText((mproductCategories.get(i).getCatDescription()));

        //zxc



        viewHolder.cardViewProductCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Fragment fragment=new ProductsFragment();

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
