package net.centricdata.agricura.Models;

import java.util.ArrayList;

public class ProductCategories {
    private String catName;
    private String catDescription;
    private String imageName;


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

        productCategories.add(new ProductCategories("Pesticide","For killing pests", "pesticide"));
        productCategories.add(new ProductCategories("Insecticide","For killing insects", "insecticide"));
        productCategories.add(new ProductCategories("Herbicide","For killing herbs", "herbicide"));
        productCategories.add(new ProductCategories("Fumigant","For killing pests", "fumigant"));
        productCategories.add(new ProductCategories("Bait","For killing insects", "bait"));
        productCategories.add(new ProductCategories("Accaricide","For killing herbs", "accaracide"));
        productCategories.add(new ProductCategories("Mineral Oil","For killing herbs", "mineraloil"));
        productCategories.add(new ProductCategories("Rodenticide","For killing pests","rodeticide"));
        productCategories.add(new ProductCategories("Graim Protecterant","For killing insects","grainprotectant"));
        productCategories.add(new ProductCategories("Fungicide","For killing herbs", "fungicide"));
        productCategories.add(new ProductCategories("Nematicide","For killing herbs","nematicide"));
        productCategories.add(new ProductCategories("Suckercide","For killing pests","suckercide"));
        productCategories.add(new ProductCategories("Wetter","For killing insects", "wetter"));
        productCategories.add(new ProductCategories("Growth Regulant","For killing herbs", "growthregulant"));
        productCategories.add(new ProductCategories("Dip","For killing herbs", "dip"));
        productCategories.add(new ProductCategories("Dose","For killing pests","dose"));
        productCategories.add(new ProductCategories("Fertilizer","For killing insects", "fertilizer"));

        /*for (int i=1;i<=numCategories;i++){

            //productCategories.add(new ProductCategories("CateName"+ ++lastProductCategories,"Description Yacho"));
        }*/
        return productCategories;
    }



}
