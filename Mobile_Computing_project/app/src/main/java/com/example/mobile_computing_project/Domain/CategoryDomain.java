package com.example.mobile_computing_project.Domain;

import java.io.Serializable;

public class CategoryDomain implements Serializable {
    private String title;
    private String pic;
    private String Description;
    private double fee;
    private int numberInCard;


    public CategoryDomain(String title, String description, double fee) {
        this.title = title;
        this.Description = description;
        this.pic = pic;
        this.fee = fee;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public int getNumberInCart() {
        return numberInCard;
    }

    public void setNumberInCart(int numberInCard) {
        this.numberInCard = numberInCard;
    }
}
