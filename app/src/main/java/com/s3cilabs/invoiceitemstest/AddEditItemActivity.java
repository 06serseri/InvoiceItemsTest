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

public class AddEditItemActivity extends AppCompatActivity {
    private static final String TAG = "AddEditItemActivity";
    EditText editTextItemName, editTextItemRate;
    TextView textViewItemQuantity, textViewHasTax;
    Button buttonIncrease, buttonDecrease, buttonAddItem;
    CheckBox checkBoxHasTax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_item);
        initViews();

        buttonAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddEditItemActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
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