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
import android.widget.Toast;

import java.util.List;

public class AddEditItemActivity extends AppCompatActivity {
    private static final String TAG = "AddEditItemActivity";
    EditText editTextItemName, editTextItemRate;
    TextView textViewItemQuantity, textViewHasTax;
    Button buttonIncrease, buttonDecrease, buttonAddItem, buttonDeleteItem;
    CheckBox checkBoxHasTax;
    List<Item> itemList;
    MyApplication myApplication = (MyApplication) this.getApplication();
    int itemId;

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

        Intent intent = getIntent();
        itemId = intent.getIntExtra("itemId", -1);
        Item item = null;

        if (itemId >= 0) {
            //Edit the item
            for (Item i : itemList) {
                if (i.getItemId() == itemId) {
                    item = i;
                }
            }
            buttonAddItem.setText("Update Item");
            editTextItemName.setText(item.getItemName());
            textViewItemQuantity.setText(String.valueOf(item.getItemQuantity()));
            editTextItemRate.setText(String.valueOf(item.getItemRate()));
            checkBoxHasTax.setChecked(Boolean.valueOf(item.itemHasTax));
            itemQuantity = (int) item.getItemQuantity();

        } else {
            //Add new item
        }

        buttonAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (itemId >= 0) {
                    //Update item
                    Item updatedItem = new Item(itemId, editTextItemName.getText().toString(),
                            itemQuantity,
                            Double.parseDouble(editTextItemRate.getText().toString()),
                            hasTax);
                    itemList.set(itemId, updatedItem);
//                    itemList.remove(1);

                } else {
                    //Add new item
                    //Check if the tax checkbox is checked
                    if (checkBoxHasTax.isChecked()) {
                        hasTax = true;
                    } else {
                        hasTax = false;
                    }

                    //Create item object
                    try {
                        Item newItem = new Item(nextItemId, editTextItemName.getText().toString(),
                                itemQuantity,
                                Double.parseDouble(editTextItemRate.getText().toString()),
                                hasTax);

                        //Add the object to the global list of items
                        itemList.add(newItem);
                        myApplication.setNextItemId(nextItemId++);
                        Toast.makeText(AddEditItemActivity.this, "Added successfully", Toast.LENGTH_SHORT).show();
                    } catch (Exception e){
                        Toast.makeText(AddEditItemActivity.this, "ERROR adding item", Toast.LENGTH_SHORT).show();
                        Item failedItem = new Item(-1, "Error", -1, -1, false);
                    }


                }
                System.out.println("MyApplication nextItemID: " + myApplication.getNextItemId());
                System.out.println("AddEditActivity nextItemID: " + nextItemId);
                System.out.println("ItemID: " + itemId);

                //Return to the main activity
                Intent intent = new Intent(AddEditItemActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        buttonDeleteItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Delete item
                if (!itemList.isEmpty()){
                    itemList.remove(itemId);
//                    myApplication.setNextItemId(nextItemId--);
                }
                System.out.println("MyApplication nextItemID: " + myApplication.getNextItemId());
                System.out.println("AddEditActivity nextItemID: " + nextItemId);
                System.out.println("ItemID: " + itemId);

                //Return to the main activity
                Intent intent = new Intent(AddEditItemActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void checkNullException() {
        if (editTextItemName.getText().toString().isEmpty()){
            System.out.println("Na");
        }
    }

    private void increase() {
        itemQuantity++;
        textViewItemQuantity.setText(String.valueOf(itemQuantity));
    }

    private void decrease() {
        if (itemQuantity > 0) {
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
        buttonDeleteItem = findViewById(R.id.buttonDeleteItem);
        checkBoxHasTax = findViewById(R.id.checkBoxHasTax);
    }
}