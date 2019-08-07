package net.centricdata.agricura.Models;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import net.centricdata.agricura.Adapters.ProductCategoriesAdapter;
import net.centricdata.agricura.R;

import java.util.ArrayList;
import java.util.List;

public class Products implements Parcelable {

    public String prodName;
    public String prodCategory;
    public String prodDescription;
    public String prodQuantities;
    public ImageView prodImage;
    public String prodImageName;

    public String mselectedProduct= ProductCategoriesAdapter.get();





    public Products(String productCategory,String productImage, String productName, String productDescription, String productQuantities){

        //prodImage= productImage;
        //prodImage = BitmapFactory.decodeResource(this.getResources(), R.drawable.tasnim);
        prodName= productName;
        prodDescription= productDescription;
        prodQuantities= productQuantities;
        prodCategory= productCategory;
        prodImageName=productImage;


    }

    protected Products(Parcel in) {
        prodName = in.readString();
        prodCategory = in.readString();
        prodDescription = in.readString();
        prodQuantities = in.readString();
        prodImageName = in.readString();
    }

    public static final Creator<Products> CREATOR = new Creator<Products>() {
        @Override
        public Products createFromParcel(Parcel in) {
            return new Products(in);
        }

        @Override
        public Products[] newArray(int size) {
            return new Products[size];
        }
    };

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdCategory() {
        return prodCategory;
    }

    public void setProdCategory(String prodCategory) {
        this.prodCategory = prodCategory;
    }

    public String getProdDescription() {
        return prodDescription;
    }

    public void setProdDescription(String prodDescription) {
        this.prodDescription = prodDescription;
    }

    public String getProdQuantities() {
        return prodQuantities;
    }

    public void setProdQuantities(String prodQuantities) {
        this.prodQuantities = prodQuantities;
    }

    public ImageView getProdImage() {
        return prodImage;
    }

    public void setProdImage(ImageView prodImage) {
        this.prodImage = prodImage;
    }

    public String getProdImageName() {
        return prodImageName;
    }

    public void setProdImageName(String prodImageName) {
        this.prodImageName = prodImageName;
    }


    public static ArrayList<Products> createProductsList(){


        ArrayList<Products> products= new ArrayList<>();

        products.add(new Products("Insecticide","insecticide_image","Acephate 75%","Contact and systemic for the control of various pests in various crops", "500g,1kg" ));
        products.add(new Products("Insecticide","insecticide_image","Thiamethoxam 25WG","Systemic for the control of sap sucking pests in tobacco, tomatoes and various crops", "200g,500g" ));
        products.add(new Products("Insecticide","insecticide_image","Aphid Kill","Emulsifiable concentrate, contact for the control of pests in various crops ", "100ml,200ml" ));
        products.add(new Products("Insecticide","insecticide_image","Avaunt (Indoxacarb) 15SC","Contact for fast and broad-spectrum control of many worm pests and other insects ", "200ml,500ml" ));
        products.add(new Products("Insecticide","insecticide_image","Acetamark ","Systemic for controlling sap sucking pests in cotton, tomatoes and various crops", "50g,100g, 500g" ));
        products.add(new Products("Bait","insecticide_image","GF120 N BAIT ","Bait concentrate for use in horticultural crops, deciduos fruit trees, citrus ", "500ml" ));
        products.add(new Products("Accaracide","accaricide","DICOFOL 18.5% EC","Emulsifiable concentrate contact organochlorine for controlling pests in various crops", "100ml,200ml, 5ltr" ));
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
        products.add(new Products("Insecticide","insecticide_image","Acephate 75%","Contact and systemic for the control of various pests in various crops", "500g,1kg" ));
        products.add(new Products("Insecticide","insecticide_image","Acephate 75%","Contact and systemic for the control of various pests in various crops", "500g,1kg" ));

/*
        ArrayList<Products> productsToshow= new ArrayList<>();
        for (Products  p: products)
            if (p.prodCategory=="Bait"){
                productsToshow.add(p);
            }
            */

        return  products;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(prodName);
        dest.writeString(prodCategory);
        dest.writeString(prodDescription);
        dest.writeString(prodQuantities);
        dest.writeString(prodImageName);

    }
}
