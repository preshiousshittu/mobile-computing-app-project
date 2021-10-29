package com.example.mobile_computing_project.Domain;

import java.io.Serializable;

public class ItemDomain implements Serializable {
    private String title;
    private String Description;
    private double fee;
    private int numberInCard;

    public ItemDomain(String title, String description, double fee) {
        this.title = title;
        this.Description = description;
        this.fee = fee;
    }

    public ItemDomain(String title, String description, double fee, int numberInCard) {
        this.title = title;
        Description = description;
        this.fee = fee;
        this.numberInCard = numberInCard;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public int getNumberInCard() {
        return numberInCard;
    }

    public void setNumberInCard(int numberInCard) {
        this.numberInCard = numberInCard;
    }
}
