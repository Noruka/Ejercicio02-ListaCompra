package com.example.ejercicio02_listacompra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MercadonaAddActivity extends AppCompatActivity {

    EditText txtProducto, txtCantidad;
    Button btnCancelar, btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mercadona_add);

        txtProducto = findViewById(R.id.txtProductoAdd);
        txtCantidad = findViewById(R.id.txtCantidadAdd);

        btnOk = findViewById(R.id.btnOkAdd);
        btnCancelar = findViewById(R.id.btnCancelarAdd);

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (txtProducto.getText().toString().isEmpty() || txtCantidad.getText().toString().isEmpty()){

                    Toast.makeText(MercadonaAddActivity.this, "Faltan datos", Toast.LENGTH_SHORT).show();

                } else if (Float.parseFloat(txtCantidad.getText().toString()) <= 0) {

                    Toast.makeText(MercadonaAddActivity.this, "Cantidad no puede ser menos de 1", Toast.LENGTH_SHORT).show();

                }else{

                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putString("PRODUCTO", txtProducto.getText().toString());
                    bundle.putString("CANTIDAD", txtCantidad.getText().toString());

                    intent.putExtras(bundle);
                    setResult(RESULT_OK, intent);
                    finish();
                }

            }
        });

    }
}
