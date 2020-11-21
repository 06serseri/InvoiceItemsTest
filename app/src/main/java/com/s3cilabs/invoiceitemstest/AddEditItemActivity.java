package com.s3cilabs.invoiceitemstest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class AddEditItemActivity extends AppCompatActivity {
    private static final String TAG = "AddEditItemActivity";
    EditText editTextItemName, editTextItemRate;
    TextView textViewItemQuantity, textViewHasTax;
    Button buttonIncrease, buttonDecrease, buttonAddItem;
    CheckBox checkBoxHasTax;
    List<Item> itemList;
    MyApplication myApplication = (MyApplication) this.getApplication();

    int nextItemId = myApplication.getNextItemId();
    int itemQuantity = 1;
    boolean hasTax = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_item);
        initViews();

        itemList = myApplication.getItemList();

        //Increase item quantity
        buttonIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increase();
            }
        });

        //Decrease item quantity
        buttonDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrease();
            }
        });

        buttonAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Check if the tax checkbox is checked
                if (checkBoxHasTax.isChecked()){
                    hasTax = true;
                } else {
                    hasTax = false;
                }

                //Create item object
                //TODO look into quantity and tax
                Item newItem = new Item(nextItemId, editTextItemName.getText().toString(),
                        itemQuantity,
                        Double.parseDouble(editTextItemRate.getText().toString()),
                        hasTax);

                //Add the object to the global list of items
                itemList.add(newItem);
                myApplication.setNextItemId(nextItemId++);

                //Return to the main activity
                Intent intent = new Intent(AddEditItemActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


    private void increase() {
        itemQuantity++;
        textViewItemQuantity.setText(String.valueOf(itemQuantity));
    }

    private void decrease() {
        if(itemQuantity > 0){
            itemQuantity--;
            textViewItemQuantity.setText(String.valueOf(itemQuantity));
        }
    }

    private void initViews() {
        Log.d(TAG, "initViews");
        editTextItemName = findViewById(R.id.editTextItemName);
        editTextItemRate = findViewById(R.id.editTextItemRate);
        textViewItemQuantity = findViewById(R.id.textViewItemQuantity);
        textViewHasTax = findViewById(R.id.textViewHasTax);
        buttonIncrease = findViewById(R.id.buttonIncrease);
        buttonDecrease = findViewById(R.id.buttonDecrease);
        buttonAddItem = findViewById(R.id.buttonAddItem);
        checkBoxHasTax = findViewById(R.id.checkBoxHasTax);
    }
}