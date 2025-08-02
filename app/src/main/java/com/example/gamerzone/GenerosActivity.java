package com.example.gamerzone;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class GenerosActivity extends AppCompatActivity {

    DrawerLayout drawerLay;
    NavigationView navigationVi;
    Toolbar toolbarbb;
    private void mostrarCerrarSesion() {
        new AlertDialog.Builder(this)
                .setTitle("Cerrar sesión")
                .setMessage("¿Estás seguro de que deseas cerrar sesión?")
                .setPositiveButton("Aceptar", (dialog, which) -> {
                    Intent intent = new Intent(GenerosActivity.this, InicioSesionActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                })
                .setNegativeButton("Cancelar", null).show();
    }

    ListView listViewGeneros;
    String[] generos = {
            "Todos los juegos",
            "Estrategia",
            "Acción",
            "Aventura",
            "MOBA",
            "Carreras",
            "Casino",
            "Deportes",
            "Terror",
            "Plataformas"
    };

    int[] iconos = {
            R.drawable.ic_todos,
            R.drawable.ic_estrategia,
            R.drawable.ic_accion,
            R.drawable.ic_aventura,
            R.drawable.ic_moba,
            R.drawable.ic_carreras,
            R.drawable.ic_casino,
            R.drawable.ic_deportes,
            R.drawable.ic_terror,
            R.drawable.ic_plataforma
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generos);

        drawerLay = findViewById(R.id.drawer_la);
        navigationVi = findViewById(R.id.navigation);
        toolbarbb = findViewById(R.id.toolbar1);

        setSupportActionBar(toolbarbb);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLay, toolbarbb, R.string.open, R.string.close);

        drawerLay.addDrawerListener(toggle);
        toggle.syncState();

        navigationVi.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLay.closeDrawers();
                int id = item.getItemId();
                if (id == R.id.nav_inicio){
                    Intent intent = new Intent(GenerosActivity.this, InicioActivity.class);
                    startActivity(intent);
                    Toast.makeText(GenerosActivity.this, "Estoy en Inicio", Toast.LENGTH_LONG).show();
                } else if (id == R.id.nav_juegos){
                    Intent intent = new Intent(GenerosActivity.this, JuegosActivity.class);
                    startActivity(intent);
                    Toast.makeText(GenerosActivity.this, "Estoy en juegos", Toast.LENGTH_LONG).show();
                } else if (id == R.id.nav_categoria){
                    Toast.makeText(GenerosActivity.this, "Estoy en Categorias", Toast.LENGTH_LONG).show();
                } else if (id == R.id.nav_nuevojuego){
                    Intent intent = new Intent(GenerosActivity.this, AgregarJuegoActivity.class);
                    startActivity(intent);
                    Toast.makeText(GenerosActivity.this, "Estoy en Agregar Juego", Toast.LENGTH_LONG).show();
                } else if (id == R.id.nav_close){
                    mostrarCerrarSesion();
                    return true;
                }
                return false;
            }
        });

        listViewGeneros = findViewById(R.id.ListGeneros);

        // Usamos un ArrayAdapter personalizado directamente en el layout
        listViewGeneros.setAdapter(new ArrayAdapter(this, R.layout.item_genero, R.id.txtGenero, generos) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                ImageView icono = view.findViewById(R.id.imgGenero);
                icono.setImageResource(iconos[position]);
                return view;
            }
        });

        listViewGeneros.setOnItemClickListener((parent, view, position, id) -> {
            String generoSeleccionado = generos[position];
            if (generoSeleccionado.equalsIgnoreCase("Todos los juegos")) {
                // Mostrar todos los juegos
                Intent intent = new Intent(GenerosActivity.this, JuegosActivity.class);
                startActivity(intent);
            } else {
                // Verificar si existen juegos de ese género
                List<Juego> juegos = MisJuegos.lista(); // Usa tu clase con los juegos registrados
                boolean encontrado = false;

                for (Juego juego : juegos) {
                    if (juego.getGenero().equalsIgnoreCase(generoSeleccionado)) {
                        encontrado = true;
                        break;
                    }
                }

                if (encontrado) {
                    Intent intent = new Intent(GenerosActivity.this, JuegosActivity.class);
                    intent.putExtra("genero", generoSeleccionado);
                    startActivity(intent);
                } else {
                    Toast.makeText(this,
                            "No hay juegos disponibles para este género", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}