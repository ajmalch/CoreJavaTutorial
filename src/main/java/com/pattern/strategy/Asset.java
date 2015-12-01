package com.pattern.strategy;

/**
 * Created by AjmalCholassery on 6/15/15.
 */
public class Asset {

    public enum AssetType{BOND,STOCK;}

    private int value;
    private AssetType type;

    public Asset(int value, AssetType type) {
        this.value = value;
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public AssetType getType() {
        return type;
    }
}
