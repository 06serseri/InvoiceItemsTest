package com.s3cilabs.invoiceitemstest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    Button buttonAddEditItem;
    RecyclerView recyclerViewItemList;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    List<Item> itemList = new ArrayList<Item>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        fillItemList();
        Toast.makeText(this, "Count: " + itemList.toString(), Toast.LENGTH_SHORT).show();

        recyclerViewItemList.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerViewItemList.setLayoutManager(mLayoutManager);

        mAdapter = new RecyclerViewAdapterItem(itemList, MainActivity.this);
        recyclerViewItemList.setAdapter(mAdapter);

        buttonAddEditItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddEditItemActivity.class);
                startActivity(intent);
            }
        });
    }

    private void fillItemList() {
        Item item1 = new Item(0, "Banana", 1, .50, false);
        Item item2 = new Item(1, "Coke", 2, 1, true);
        Item item3 = new Item(2, "Wings", 10, 1.25, true);
        Item item4 = new Item(3, "Apple", 3, .50, false);
        Item item5 = new Item(4, "Bread", 1, .88, false);

        itemList.addAll(Arrays.asList(new Item[]{item1, item2, item3, item4, item5}));

    }

    private void initViews() {
        buttonAddEditItem = findViewById(R.id.buttonAddEditItem);
        recyclerViewItemList = findViewById(R.id.recyclerViewItemList);
    }
}