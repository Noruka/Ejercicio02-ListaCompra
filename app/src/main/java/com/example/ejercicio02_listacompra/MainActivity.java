package com.example.ejercicio02_listacompra;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnMercadonAdd, btnConsumAdd, btnDiaAdd;

    private LinearLayout llMercadona, llConsum, llDia;

    private final int MERCADONA = 1, CONSUM = 2, DIA = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMercadonAdd = findViewById(R.id.btnMercadonaAddMain);
        btnConsumAdd = findViewById(R.id.btnConsumAddMain);
        btnDiaAdd = findViewById(R.id.btnDiaAdd);

        llMercadona = findViewById(R.id.lltxtContenedorMercadonaMain);
        llConsum = findViewById(R.id.lltxtContenedorConsumMain);
        llDia = findViewById(R.id.lltxtContenedorDiaMain);

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        final TextView textView = new TextView(MainActivity.this);

        if (resultCode == RESULT_OK) {
            if (data != null) {
                switch (requestCode) {

                    case MERCADONA:
                        textView.setText(data.getExtras().getString("PRODUCTO") + " " + data.getExtras().getString("CANTIDAD"));
                        textView.setTextSize(18);
                        textView.setTextColor(Color.BLACK);

                        textView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                llMercadona.removeView(view);
                                Toast.makeText(MainActivity.this, "Se ha eliminado el item", Toast.LENGTH_SHORT).show();
                            }
                        });

                        llMercadona.addView(textView);
                        break;
                    case CONSUM:
                        textView.setText(data.getExtras().getString("PRODUCTO") + " " + data.getExtras().getString("CANTIDAD"));
                        textView.setTextSize(18);
                        textView.setTextColor(Color.BLACK);

                        textView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                llConsum.removeView(view);
                                Toast.makeText(MainActivity.this, "Se ha eliminado el item", Toast.LENGTH_SHORT).show();
                            }
                        });

                        llConsum.addView(textView);
                        break;
                    case DIA:
                        textView.setText(data.getExtras().getString("PRODUCTO") + " " + data.getExtras().getString("CANTIDAD"));
                        textView.setTextSize(18);
                        textView.setTextColor(Color.BLACK);

                        textView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                llDia.removeView(view);
                                Toast.makeText(MainActivity.this, "Se ha eliminado el item", Toast.LENGTH_SHORT).show();
                            }
                        });

                        llDia.addView(textView);
                        break;
                }
            }
        }
    }

}
