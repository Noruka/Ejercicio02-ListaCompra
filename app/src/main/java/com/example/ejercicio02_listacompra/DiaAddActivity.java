package com.example.ejercicio02_listacompra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DiaAddActivity extends AppCompatActivity {

    EditText txtProducto, txtCantidad;
    Button btnCancelar, btnOk;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dia_add);

        txtProducto = findViewById(R.id.edtProductoDiaAdd);
        txtCantidad = findViewById(R.id.edtCantidadDiaAdd);

        btnOk = findViewById(R.id.btnOkDiaAdd);
        btnCancelar = findViewById(R.id.btnCancelarDiaAdd);

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

                    Toast.makeText(DiaAddActivity.this, "Faltan datos", Toast.LENGTH_SHORT).show();

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
