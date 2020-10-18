package com.margretcraft.flowershop;

import android.content.Context;
import android.graphics.Color;
import android.view.*;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private List<ItemFlower> listOfFlowers;
    private LayoutInflater inflater;
    OrderActivity orderActivity;

    public ItemAdapter(@NonNull Context context, List<ItemFlower> listOfFlowers) {

        this.inflater = LayoutInflater.from(context);
        this.listOfFlowers = listOfFlowers;
        orderActivity = (OrderActivity) context;

    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_flower, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull ItemAdapter.ViewHolder holder, int position) {
        ItemFlower itf = listOfFlowers.get(position);
        holder.textView.setText(itf.getFlowerName());
        holder.editText.setText("" + itf.getQuantity());
        holder.imageView.setImageDrawable(itf.getImage());
        holder.editText.setTag(itf);
        holder.spinner.setSelection(itf.getColor());
    }

    @Override
    public int getItemCount() {
        return listOfFlowers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView textView;
        final EditText editText;
        final ImageView imageView;
        final Spinner spinner;

        ViewHolder(View view) {
            super(view);

            textView = (TextView) view.findViewById(R.id.textViewItemName);
            imageView = (ImageView) view.findViewById(R.id.imageViewItem);
            editText = (EditText) view.findViewById(R.id.editTextNumberItem);
            editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                    if (editText.getText().toString().equals("")) {
                        editText.setText("0");
                    }
                    ItemFlower item = (ItemFlower) editText.getTag();
                    item.setQuantity(Integer.parseInt(editText.getText().toString()));
                    editText.setBackgroundColor(Color.parseColor("#F5F1F1"));
                    orderActivity.countCost();
                    return false;

                }

            });
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (!hasFocus) {
                        // code to execute when EditText loses focus
                        if (editText.getText().toString().equals("")) {
                            editText.setText("0");


                        }
                        ItemFlower item = (ItemFlower) editText.getTag();
                        item.setQuantity(Integer.parseInt(editText.getText().toString()));

                        editText.setBackgroundColor(Color.parseColor("#F5F1F1"));
                        orderActivity.countCost();
                    }
                }
            });

            editText.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (editText.getText().toString().equals("0")) {
                        editText.setText("");
                        editText.setBackgroundColor(Color.parseColor("#D69FB4"));
                    }
                    return false;
                }
            });
            spinner = (Spinner) view.findViewById(R.id.spinnerItem);
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    ItemFlower item = (ItemFlower) editText.getTag();
                    item.setColor(position);
                    ((TextView) spinner.getChildAt(0)).setTextSize(14);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        }
    }
}
