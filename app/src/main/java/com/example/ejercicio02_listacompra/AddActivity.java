package com.example.ejercicio02_listacompra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {

    private TextView txtTitulo;
    private EditText txtProducto, txtCantidad;
    private Button btnCancelar, btnOk;

    private final int MERCADONA = 1, CONSUM = 2, DIA = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Intent intent = new Intent(this.getIntent());

        int supermercado = intent.getExtras().getInt("SUPERMERCADO");

        txtTitulo = findViewById(R.id.txtTituloAdd);
        txtProducto = findViewById(R.id.txtProductoAdd);
        txtCantidad = findViewById(R.id.txtCantidadAdd);

        btnOk = findViewById(R.id.btnOkAdd);
        btnCancelar = findViewById(R.id.btnCancelarAdd);

        switch (supermercado) {

            case MERCADONA:
                txtTitulo.setText("MERCADONA");
                break;

            case CONSUM:
                txtTitulo.setText("CONSUM");
                break;

            case DIA:
                txtTitulo.setText("DIA");
                break;

        }


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

                if (txtProducto.getText().toString().isEmpty() || txtCantidad.getText().toString().isEmpty()) {

                    Toast.makeText(AddActivity.this, "Faltan datos", Toast.LENGTH_SHORT).show();

                } else if (Float.parseFloat(txtCantidad.getText().toString()) <= 0) {

                    Toast.makeText(AddActivity.this, "Cantidad no puede ser menos de 1", Toast.LENGTH_SHORT).show();

                } else {

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
