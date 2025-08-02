package com.example.gamerzone;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class InicioActivity extends AppCompatActivity {

    CardView cardjuego, cardgenero, cardagregar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    private void mostrarCerrarSesion() {
        new AlertDialog.Builder(this)
                .setTitle("Cerrar sesión")
                .setMessage("¿Estás seguro de que deseas cerrar sesión?")
                .setPositiveButton("Aceptar", (dialog, which) -> {
                    Intent intent = new Intent(InicioActivity.this, InicioSesionActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                })
                .setNegativeButton("Cancelar", null).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawers();
                int id = item.getItemId();
                if (id == R.id.nav_inicio){
                    Toast.makeText(InicioActivity.this, "Estoy en Inicio", Toast.LENGTH_LONG).show();
                } else if (id == R.id.nav_juegos){
                    Intent jugar = new Intent(InicioActivity.this, JuegosActivity.class);
                    startActivity(jugar);
                    Toast.makeText(InicioActivity.this, "Estoy en juegos", Toast.LENGTH_LONG).show();
                } else if (id == R.id.nav_categoria){
                    Intent jugar = new Intent(InicioActivity.this, GenerosActivity.class);
                    startActivity(jugar);
                    Toast.makeText(InicioActivity.this, "Estoy en Categorias", Toast.LENGTH_LONG).show();
                } else if (id == R.id.nav_nuevojuego){
                    Intent jugar = new Intent(InicioActivity.this, AgregarJuegoActivity.class);
                    startActivity(jugar);
                    Toast.makeText(InicioActivity.this, "Estoy en Agregar Juego", Toast.LENGTH_LONG).show();
                } else if (id == R.id.nav_close){
                    mostrarCerrarSesion();
                    return true;
                }
                return false;
            }
        });

        cardjuego = findViewById(R.id.cardjuegos);
        cardjuego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jugando = new Intent(InicioActivity.this, JuegosActivity.class);
                startActivity(jugando);
            }
        });

        cardgenero = findViewById(R.id.cardgenero);
        cardgenero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gener = new Intent(InicioActivity.this, GenerosActivity.class);
                startActivity(gener);
            }
        });

        cardagregar = findViewById(R.id.cardagregar);
        cardagregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent agregar = new Intent(InicioActivity.this, AgregarJuegoActivity.class);
                startActivity(agregar);
            }
        });
    }
}