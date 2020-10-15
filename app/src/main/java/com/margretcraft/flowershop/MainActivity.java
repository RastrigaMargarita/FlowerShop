package com.margretcraft.flowershop;

import android.content.Intent;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private EditText textViewLogin;
    private EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewLogin = findViewById(R.id.textViewLogin);
        editTextPassword = findViewById(R.id.editTextPassword);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (!textViewLogin.getText().toString().trim().isEmpty()){

        outState.putString("username", textViewLogin.getText().toString());}
    }

    public void makeOrder(View view) {
        if ((!textViewLogin.getText().toString().trim().isEmpty()) && (!editTextPassword.getText().toString().trim().isEmpty())) {
            Intent it = new Intent(this, OrderActivity.class);
            it.putExtra("username", textViewLogin.getText().toString());
            startActivity(it);
        } else {
            Toast.makeText(this, "Заполните поля имя и пароль", Toast.LENGTH_SHORT).show();

        }

    }
}