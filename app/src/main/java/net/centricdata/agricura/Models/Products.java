package net.centricdata.agricura.Models;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import net.centricdata.agricura.R;

import java.util.ArrayList;
import java.util.List;

public class Products {

    public String prodName;
    public String prodCategory;
    public String prodDescription;
    public String prodQuantities;
    public ImageView prodImage;
    //public Bitmap prodImage;

    public Products(String productCategory,String productImage, String productName, String productDescription, String productQuantities){

        //prodImage= productImage;
        //prodImage = BitmapFactory.decodeResource(this.getResources(), R.drawable.tasnim);
        prodName= productName;
        prodDescription= productDescription;
        prodQuantities= productQuantities;
        prodCategory= productCategory;


    }

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

    public static ArrayList<Products> createProductsList(){

        ArrayList<Products> products= new ArrayList<>();

        products.add(new Products("Insecticide","insecticide_image","Acephate 75%","Contact and systemic for the control of various pests in various crops", "500g,1kg" ));
        products.add(new Products("Insecticide","insecticide_image","Thiamethoxam 25WG","Contact and systemic for the control of various pests in various crops", "200g,500g" ));
        products.add(new Products("Insecticide","insecticide_image","Aphid Kill","Contact and systemic for the control of various pests in various crops", "100ml,200ml" ));
        products.add(new Products("Insecticide","insecticide_image","Avaunt (Indoxacarb) 15SC","Contact and systemic for the control of various pests in various crops", "200ml,500ml" ));
        products.add(new Products("Insecticide","insecticide_image","Acetamark ","Contact and systemic for the control of various pests in various crops", "50g,100g, 500g" ));
        products.add(new Products("Bait","insecticide_image","GF120 N BAIT ","Contact and systemic for the control of various pests in various crops", "500ml" ));
        products.add(new Products("Accaracide","accaricide","DICOFOL 18.5% EC","Contact and systemic for the control of various pests in various crops", "100ml,200ml, 5ltr" ));
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

        return  products;
    }
}
