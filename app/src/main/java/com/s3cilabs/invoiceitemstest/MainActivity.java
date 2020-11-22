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

    MyApplication myApplication = (MyApplication) this.getApplication();
    List<Item> itemList;

    //TODO EditItem https://www.youtube.com/watch?v=ASLLh-6MGVA&list=PLhPyEFL5u-i1jAc79cJ2j8pDZFEyvpoH_&index=6

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        itemList = myApplication.getItemList();

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

    private void initViews() {
        buttonAddEditItem = findViewById(R.id.buttonAddEditItem);
        recyclerViewItemList = findViewById(R.id.recyclerViewItemList);
    }
}