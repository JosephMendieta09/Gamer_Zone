package com.example.gamerzone;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JuegosActivity extends AppCompatActivity {
    RecyclerView recyclerJuego;
    JuegoAdapter juegoAdapter;
    List<Juego> listaCompleta;
    TextView txtTituloGenero;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    private void mostrarCerrarSesion() {
        new AlertDialog.Builder(this)
                .setTitle("Cerrar sesión")
                .setMessage("¿Estás seguro de que deseas cerrar sesión?")
                .setPositiveButton("Aceptar", (dialog, which) -> {
                    Intent intent = new Intent(JuegosActivity.this, InicioSesionActivity.class);
                    startActivity(intent);
                    finish();
                })
                .setNegativeButton("Cancelar", null).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juegos);

        drawerLayout = findViewById(R.id.drawer_la);
        navigationView = findViewById(R.id.navigation);
        toolbar = findViewById(R.id.toolbar1);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawers();
                int id = item.getItemId();
                if (id == R.id.nav_inicio) {
                    Intent intent = new Intent(JuegosActivity.this, InicioActivity.class);
                    startActivity(intent);
                    Toast.makeText(JuegosActivity.this, "Estoy en Inicio", Toast.LENGTH_LONG).show();
                } else if (id == R.id.nav_juegos) {
                    Toast.makeText(JuegosActivity.this, "Estoy en juegos", Toast.LENGTH_LONG).show();
                } else if (id == R.id.nav_categoria) {
                    Intent intent = new Intent(JuegosActivity.this, GenerosActivity.class);
                    startActivity(intent);
                    Toast.makeText(JuegosActivity.this, "Estoy en Categorias", Toast.LENGTH_LONG).show();
                } else if (id == R.id.nav_nuevojuego) {
                    Toast.makeText(JuegosActivity.this, "Estoy en Nuevo Juego", Toast.LENGTH_LONG).show();
                } else if (id == R.id.nav_close) {
                    mostrarCerrarSesion();
                    return true;
                }
                return false;
            }
        });

        txtTituloGenero = findViewById(R.id.txtGeneroSeleccionado);
        listaCompleta = MisJuegos.lista();

        recyclerJuego = findViewById(R.id.RecyclerJuego);
        recyclerJuego.setLayoutManager(new LinearLayoutManager(this));
        Intent intent = getIntent();
        String generoSeleccionado = intent.getStringExtra("genero");
        List<Juego> juegosFiltrados = null;
        if (generoSeleccionado != null && !generoSeleccionado.isEmpty()) {
            juegosFiltrados = new ArrayList<>();
            for (Juego j : listaCompleta) {
                if (j.getGenero().equalsIgnoreCase(generoSeleccionado)) {
                    juegosFiltrados.add(j);
                }
            }
            if (txtTituloGenero != null) {
                txtTituloGenero.setText("Género: " + generoSeleccionado);
            }
            juegoAdapter = new JuegoAdapter(juegosFiltrados, this);
        } else {
            if (txtTituloGenero != null) {
                txtTituloGenero.setText("Todos los Juegos");
            }
            juegoAdapter = new JuegoAdapter(listaCompleta, this);
        }
        recyclerJuego.setAdapter(juegoAdapter);
    }
}