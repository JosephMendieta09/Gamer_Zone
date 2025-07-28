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

public class InicioSesionActivity extends AppCompatActivity {
    TextView tvregistrar;
    EditText Nombre;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        Nombre = findViewById(R.id.edtNombre);
        String nombre = getIntent().getStringExtra("name");
        Nombre.setText(nombre);

        tvregistrar = findViewById(R.id.tvRegister);
        tvregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pass = new Intent(InicioSesionActivity.this, RegistroActivity.class);
                startActivity(pass);
            }
        });

        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lol = new Intent(InicioSesionActivity.this, InicioActivity.class);
                startActivity(lol);
            }
        });
    }
}