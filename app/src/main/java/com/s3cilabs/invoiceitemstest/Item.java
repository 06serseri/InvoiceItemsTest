package com.s3cilabs.invoiceitemstest;

public class Item {
    private int itemId;
    String itemName;
    double itemQuantity;
    double itemRate;
    boolean itemHasTax;
//    double itemDollarAmount;


    public Item(int itemId, String itemName, double itemQuantity, double itemRate, boolean itemHasTax) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.itemRate = itemRate;
        this.itemHasTax = itemHasTax;
    }

    public Item() {
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemQuantity=" + itemQuantity +
                ", itemRate=" + itemRate +
                ", itemHasTax=" + itemHasTax +
                '}';
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(double itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public double getItemRate() {
        return itemRate;
    }

    public void setItemRate(double itemRate) {
        this.itemRate = itemRate;
    }

    public boolean isItemHasTax() {
        return itemHasTax;
    }

    public void setItemHasTax(boolean itemHasTax) {
        this.itemHasTax = itemHasTax;
    }
}
