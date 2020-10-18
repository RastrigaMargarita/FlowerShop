package com.margretcraft.flowershop;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {
    RecyclerView listView;
    List<ItemFlower> list;
    int[] costadd;
    int[] costcov;
    CheckBox cb1;
    CheckBox cb2;
    CheckBox cb3;
    RadioButton rb1;
    RadioButton rb2;
    RadioButton rb3;
    RadioButton rb4;
    TextView cost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        listView = findViewById(R.id.listViewMainFlowers);
        getListOfFlowers();
        listView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ItemAdapter adapter = new ItemAdapter(this, list);

        listView.setAdapter(adapter);
        cost = findViewById(R.id.textViewCost);

        costadd = getResources().getIntArray(R.array.addCost);
        costcov = getResources().getIntArray(R.array.coverCost);

        cb1 = findViewById(R.id.checkBox1);
        cb2 = findViewById(R.id.checkBox2);
        cb3 = findViewById(R.id.checkBox3);
        rb1 = findViewById(R.id.radioButtonNonCover);
        rb2 = findViewById(R.id.radioButtonPlenka);
        rb3 = findViewById(R.id.radioButtonColorPlenka);
        rb4 = findViewById(R.id.radioButtonPapir);
    }

    private List getListOfFlowers() {
        String[] arstr = getResources().getStringArray(R.array.flowersList);
        int[] coststr = getResources().getIntArray(R.array.flowersCost);
        list = new ArrayList<>();

        for (int i = 0; i < arstr.length; i++) {

            list.add(new ItemFlower(arstr[i], getDrawable(getResources().getIdentifier("f" + i, "drawable", getPackageName())), coststr[i]));
        }
        return list;
    }

    public void countCost() {
        int intcost = 0;
        for (int i = 0; i < list.size(); i++) {
            intcost += list.get(i).getQuantity() * list.get(i).getCost();
        }
        if (cb1.isChecked()) {
            intcost += costadd[0];
        }
        if (cb2.isChecked()) {
            intcost += costadd[1];
        }
        if (cb3.isChecked()) {
            intcost += costadd[2];
        }
        if (rb1.isChecked()) {
            intcost += costcov[0];
        }
        if (rb2.isChecked()) {
            intcost += costcov[1];
        }
        if (rb3.isChecked()) {
            intcost += costcov[2];
        }
        if (rb4.isChecked()) {
            intcost += costcov[3];
        }
        cost.setText("" + intcost);

    }

    public void countCost(View view) {

        countCost();
    }
}