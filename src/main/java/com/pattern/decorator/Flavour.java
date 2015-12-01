package com.pattern.decorator;

/**
 * Created by AjmalCholassery on 6/16/15.
 */
public class Flavour {

    private String flavourDetails;

    public Flavour() {
        flavourDetails = "Basic IceCream";
    }

    public String getFlavourDetails() {
        return flavourDetails;
    }

    public Flavour(String flavourDetails) {
        this.flavourDetails = flavourDetails;
    }

    public Flavour addChocolate(){
        flavourDetails+= " + Great Chocolates";
        return new Flavour(flavourDetails);
    }

    public Flavour addNuts(){
        flavourDetails+= " + Tasty Nuts";
        return new Flavour(flavourDetails);
    }

    public Flavour addHoney(){
        flavourDetails+= " + Sweet Honey";
        return new Flavour(flavourDetails);
    }
}
