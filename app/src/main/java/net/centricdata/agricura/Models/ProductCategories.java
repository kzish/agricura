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

        productCategories.add(new ProductCategories("Pesticides","For killing pests", "pesticide"));
        productCategories.add(new ProductCategories("Insecticides","For killing insects", "insecticide"));
        productCategories.add(new ProductCategories("Herbicides","For killing herbs", "herbicide"));
        productCategories.add(new ProductCategories("Fumigants","For killing pests", "fumigant"));
        productCategories.add(new ProductCategories("Bait","For killing insects", "bait"));
        productCategories.add(new ProductCategories("Accaricides","For killing herbs", "accaracide"));
        productCategories.add(new ProductCategories("Mineral Oils","For killing herbs", "mineraloil"));
        productCategories.add(new ProductCategories("Rodenticide","For killing pests","rodeticide"));
        productCategories.add(new ProductCategories("Graim Protecterant","For killing insects","grainprotectant"));
        productCategories.add(new ProductCategories("Fungicide","For killing herbs", "fungicide"));
        productCategories.add(new ProductCategories("Nematicides","For killing herbs","nematicide"));
        productCategories.add(new ProductCategories("Suckercides","For killing pests","suckercide"));
        productCategories.add(new ProductCategories("Wetters","For killing insects", "wetter"));
        productCategories.add(new ProductCategories("Growth Regulants","For killing herbs", "growthregulant"));
        productCategories.add(new ProductCategories("Dips","For killing herbs", "dip"));
        productCategories.add(new ProductCategories("Doses","For killing pests","dose"));
        productCategories.add(new ProductCategories("Fertilizers","For killing insects", "fertilizer"));

        /*for (int i=1;i<=numCategories;i++){

            //productCategories.add(new ProductCategories("CateName"+ ++lastProductCategories,"Description Yacho"));
        }*/
        return productCategories;
    }



}
