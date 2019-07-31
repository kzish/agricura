package net.centricdata.agricura.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

import net.centricdata.agricura.Fragments.SingleProductFragment;
import net.centricdata.agricura.Models.Products;
import net.centricdata.agricura.R;

import java.util.ArrayList;
import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {
    private List<Products> mproducts;
    private LayoutInflater mInflater;
    private ImageView prodImage;
    private Context mcontext;

    public ProductsAdapter(ArrayList<Products> products){

        mproducts= products;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        Context context= viewGroup.getContext();
        mcontext=context;
        mInflater= LayoutInflater.from(context);
        final View view = mInflater.inflate(R.layout.row_products, viewGroup, false);
        prodImage= (ImageView) view.findViewById(R.id.imgProd);


        final ViewHolder holder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //int position = holder.getAdapterPosition();
                //Products selectedProduct= mproducts.get(position);
                //Intent intent= new Intent(v.getContext(), SingleProductFragment.class);
                //intent.putExtra("Products", selectedProduct);
                //view.getContext().startActivity(intent);
                int position = holder.getAdapterPosition();
                Products selectedProduct= mproducts.get(position);
                Intent intent= new Intent(v.getContext(), SingleProductFragment.class);
                intent.putExtra("Products", selectedProduct);
                view.getContext().startActivity(intent);

            }
        });
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {

        final Products products= mproducts.get(i);
        TextView textView1= viewHolder.prodNameTextView;
        textView1.setText(products.getProdName());
        viewHolder.prodNameTextView.setText((mproducts.get(i).getProdName()));
        viewHolder.prodDescriptionTextView.setText((mproducts.get(i).getProdDescription()));

        String uri= "android.resource://net.centricdata.agricura/drawable/"+mproducts.get(i).getProdCategory().toLowerCase().replaceAll("\\s+","");
        Picasso.with(mcontext).load(uri).into(prodImage);


        viewHolder.prodCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Fragment fragment=new SingleProductFragment();

                Bundle bundle= new Bundle();
                bundle.putString("pname", mproducts.get(i).prodName);
                bundle.putString("pQuantities", mproducts.get(i).prodQuantities);
                bundle.putString("pDescription", mproducts.get(i).prodDescription);
                bundle.putString("pCategory", mproducts.get(i).prodCategory);

                Log.e("proName", mproducts.get(i).prodName);
                fragment.setArguments(bundle);
                FragmentTransaction ft =  activity.getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.content_main, fragment);
                ft.addToBackStack("products");
                ft.commit();
            }

        });


    }



    @Override
    public int getItemCount() {
        return mproducts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView prodNameTextView;
        public TextView prodDescriptionTextView;
        public Button infoButton;
        public TextView prodCount;
        public TextView productsCount;
        public CardView prodCardView;

        public ViewHolder(View itemView) {

            super(itemView);

            prodNameTextView = (TextView) itemView.findViewById(R.id.txtProdName);
            prodDescriptionTextView = (TextView) itemView.findViewById(R.id.txtProdDescription);
            //infoButton = (Button) itemView.findViewById(R.id.buttonInfo);
            //productsCount= (TextView) itemView.findViewById(R.id.txtProductCatCount);
            prodCardView = (CardView) itemView.findViewById(R.id.card_products);


        }
    }
}
