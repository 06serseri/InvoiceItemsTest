package com.s3cilabs.invoiceitemstest;

import android.app.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyApplication extends Application {

    private static List<Item> itemList = new ArrayList<Item>();
    private static int nextItemId = 0;

    public MyApplication() {
//        fillItemList();
    }


    private void fillItemList() {
//        Item item1 = new Item(0, "Banana", 1, .50, false);
//        Item item2 = new Item(1, "Coke", 2, 1, true);
//        Item item3 = new Item(2, "Wings", 10, 1.25, true);
//        Item item4 = new Item(3, "Apple", 3, .50, false);
//        Item item5 = new Item(4, "Bread", 1, .88, false);
//
//        itemList.addAll(Arrays.asList(new Item[]{item1, item2, item3, item4, item5}));
    }

    public static List<Item> getItemList() {
        return itemList;
    }

    public static void setItemList(List<Item> itemList) {
        MyApplication.itemList = itemList;
    }

    public static int getNextItemId() {
        return nextItemId;
    }

    public static void setNextItemId(int nextItemId) {
        MyApplication.nextItemId = nextItemId;
    }
}
