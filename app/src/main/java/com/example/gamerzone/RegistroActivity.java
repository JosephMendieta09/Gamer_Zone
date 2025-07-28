package com.example.gamerzone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegistroActivity extends AppCompatActivity {

    Button btnnext;
    EditText edtname;
    TextView tvhave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        edtname = findViewById(R.id.edtName);
        btnnext = findViewById(R.id.btnNext);
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = edtname.getText().toString();
                Intent intent = new Intent(RegistroActivity.this, InicioSesionActivity.class);
                intent.putExtra("name", nombre);
                startActivity(intent);
            }
        });

        tvhave = findViewById(R.id.tvHave);
        tvhave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inicio = new Intent(RegistroActivity.this, InicioSesionActivity.class);
                startActivity(inicio);
            }
        });
    }
}