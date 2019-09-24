package com.example.ejercicio02_listacompra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.lang.invoke.ConstantCallSite;

public class MainActivity extends AppCompatActivity {

    private Button btnMercadonAdd, btnConsumAdd, btnDiaAdd;

    private final int MERCADONA = 1, CONSUM = 2, DIA = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMercadonAdd = findViewById(R.id.btnMercadonaAddMain);
        btnConsumAdd = findViewById(R.id.btnConsumAddMain);
        btnDiaAdd = findViewById(R.id.btnDiaAdd);

        btnMercadonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MercadonaAddActivity.class);
                startActivityForResult(intent, MERCADONA);

            }
        });

        btnConsumAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ConsumAddActivity.class);
                startActivityForResult(intent, CONSUM);

            }
        });

        btnDiaAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DiaAddActivity.class);
                startActivityForResult(intent, DIA);
            }
        });

    }
}
