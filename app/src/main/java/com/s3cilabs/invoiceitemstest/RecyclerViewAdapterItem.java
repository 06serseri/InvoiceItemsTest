package com.s3cilabs.invoiceitemstest;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapterItem extends RecyclerView.Adapter<RecyclerViewAdapterItem.ItemViewHolder> {

    List<Item> itemList;
    Context context;

    public RecyclerViewAdapterItem(List<Item> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_line, parent, false);
        ItemViewHolder holder = new ItemViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        double taxRate = 1.0;
        holder.textViewItemId.setText(String.valueOf(itemList.get(position).getItemId()));
        holder.textViewItemName.setText(itemList.get(position).getItemName());
        holder.textViewItemRate.setText(String.valueOf(itemList.get(position).getItemRate()));
        holder.textViewItemQuantity.setText(String.valueOf(itemList.get(position).getItemQuantity()));
        //Convert isHasTax() to taxRate
        if (itemList.get(position).isItemHasTax()) {
            taxRate = 1.13;
        } else {
            taxRate = 1.00;
        }
        holder.textViewItemTax.setText(String.valueOf(taxRate));
        //Calculate the total item amount factoring rate, quantity and tax
        holder.textViewItemDollarAmount.setText("$" + itemList.get(position).getItemRate() *
                itemList.get(position).getItemQuantity() * taxRate);

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Send the control to the AddEditItemActivity
                Intent intent = new Intent(context, AddEditItemActivity.class);
                intent.putExtra("itemId", itemList.get(position).getItemId());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView textViewItemId, textViewItemName, textViewItemRate, textViewItemQuantity,
                textViewItemTax, textViewItemDollarAmount;
        RelativeLayout relativeLayout;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewItemId = itemView.findViewById(R.id.textViewItemId);
            textViewItemName = itemView.findViewById(R.id.textViewItemName);
            textViewItemRate = itemView.findViewById(R.id.textViewItemRate);
            textViewItemQuantity = itemView.findViewById(R.id.textViewItemQuantity);
            textViewItemTax = itemView.findViewById(R.id.textViewItemTax);
            textViewItemDollarAmount = itemView.findViewById(R.id.textViewItemDollarAmount);
            relativeLayout = itemView.findViewById(R.id.relativeLayoutItemLine);
        }
    }
}
