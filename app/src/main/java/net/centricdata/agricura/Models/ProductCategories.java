package net.centricdata.agricura.Models;

import android.widget.ImageView;

import java.util.ArrayList;

public class ProductCategories {
    private String catName;
    private String catDescription;
    private String imageName;
    private ImageView imageView;


    public ProductCategories(String name, String description, String image)
    {
        catName= name;
        catDescription= description;
        imageName= image;
    }

    public String getCatName() {
        return catName;
    }

    public String getCatDescription() {
        return catDescription;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public void setCatDescription(String catDescription) {
        this.catDescription = catDescription;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    private  static  int lastProductCategories=0;
    public  static ArrayList<ProductCategories> createProductCategoriesList(){
        ArrayList<ProductCategories> productCategories= new ArrayList<ProductCategories>();


        productCategories.add(new ProductCategories("Insecticide","For killing insects", "insecticide"));
        productCategories.add(new ProductCategories("Herbicide","Used to destroy unwanted vegetation.s", "herbicide"));
        productCategories.add(new ProductCategories("Fumigant","Produces fumes used to disinfect or purify an area.", "fumigant"));
        productCategories.add(new ProductCategories("Bait","Placed on a hook or in a net, trap, or fishing area to entice fish or other animals as prey.", "bait"));
        productCategories.add(new ProductCategories("Accaricide","For killing herbs", "accaricide"));
        productCategories.add(new ProductCategories("Mineral Oil","Distillation product of petroleum, especially one used as a lubricant, moisturizer, or laxative", "mineral_oil"));
        productCategories.add(new ProductCategories("Rodenticide","Poison used to kill rodents.","rodenticide"));
        productCategories.add(new ProductCategories("Grain Protecterant","Liquid stored grain insect protectant that is applied directly to grain. ","grainprotectant"));
        productCategories.add(new ProductCategories("Fungicide","For killing herbs", "fungicide"));
        productCategories.add(new ProductCategories("Nematicide","Substance used to kill nematode worms.","nematicide"));
        productCategories.add(new ProductCategories("Suckercide","For killing pests","suckercide"));
        productCategories.add(new ProductCategories("Wetter","For killing insects", "wetter"));
        productCategories.add(new ProductCategories("Growth Regulant","For killing herbs", "growthregulant"));
        productCategories.add(new ProductCategories("Dip","For killing herbs", "dip"));
        productCategories.add(new ProductCategories("Dose","For killing pests","dose"));
        productCategories.add(new ProductCategories("Fertilizer","Substance added to soil to increase its fertility", "fertilizer"));

        /*for (int i=1;i<=numCategories;i++){

            //productCategories.add(new ProductCategories("CateName"+ ++lastProductCategories,"Description Yacho"));
        }*/
        return productCategories;
    }



}
