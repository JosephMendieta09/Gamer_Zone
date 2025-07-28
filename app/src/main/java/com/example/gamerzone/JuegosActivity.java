package com.example.gamerzone;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
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
    List<Juego> listaJuegos;
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
                if (id == R.id.nav_inicio){
                    Intent intent = new Intent(JuegosActivity.this, InicioActivity.class);
                    startActivity(intent);
                    Toast.makeText(JuegosActivity.this, "Estoy en Inicio", Toast.LENGTH_LONG).show();
                } else if (id == R.id.nav_juegos){
                    Toast.makeText(JuegosActivity.this, "Estoy en juegos", Toast.LENGTH_LONG).show();
                } else if (id == R.id.nav_categoria){
                    Toast.makeText(JuegosActivity.this, "Estoy en Categorias", Toast.LENGTH_LONG).show();
                } else if (id == R.id.nav_nuevojuego){
                    Toast.makeText(JuegosActivity.this, "Estoy en Nuevo Juego", Toast.LENGTH_LONG).show();
                } else if (id == R.id.nav_close){
                    mostrarCerrarSesion();
                    return true;
                }
                return false;
            }
        });

        listaJuegos = new ArrayList<>();
        listaJuegos.add(new Juego(R.drawable.warcraft, "Warcraft", "Estrategia", "2002", "PC",
                "Conquista reinos en un mundo de fantasía épica.", 4.3f,
                "Clásico de estrategia con mucha historia."));
        listaJuegos.add(new Juego(R.drawable.clash_royale, "Clash Royale", "Estrategia", "2016", "Android/iOS",
                "Cartas, torres y batallas en tiempo real.", 4.8f,
                "Muy competitivo y adictivo."));
        listaJuegos.add(new Juego(R.drawable.minecraft, "Minecraft", "Aventura", "2011", "Multiplataforma",
                "Explora, construye y sobrevive en mundos infinitos.", 4.0f,
                "Perfecto para la creatividad."));
        listaJuegos.add(new Juego(R.drawable.god_of_war, "God of War", "Acción", "2018", "PlayStation",
                "Kratos y su hijo enfrentan dioses nórdicos.", 4.5f,
                "Narrativa épica y combate brutal."));
        listaJuegos.add(new Juego(R.drawable.mobile_legends, "Mobile Legends", "MOBA", "2016", "Android/iOS",
                "Combates 5v5 rápidos y estratégicos en línea.", 4.1f,
                "Frenético y competitivo, ideal con amigos."));
        listaJuegos.add(new Juego(R.drawable.fifa_mobile, "FIFA Mobile", "Deportes", "2023", "Android/iOS",
                "Juega partidos rápidos y colecciona estrellas.", 5.0f,
                "Ideal para jugar en cortos momentos."));
        listaJuegos.add(new Juego(R.drawable.call_of_duty, "Call of Duty", "Disparos", "2020", "Multiplataforma",
                "Combates intensos con gráficos realistas.", 5.0f,
                "Acción constante y buen multijugador."));
        listaJuegos.add(new Juego(R.drawable.plantas_vs_zombies, "Plantas vs Zombies", "Estrategia", "2009", "Multiplataforma",
                "Defiende tu jardín de hordas de zombis.", 4.5f,
                "Divertido, original y desafiante."));
        listaJuegos.add(new Juego(R.drawable.need_for_speed, "Need for Speed", "Carreras", "2015", "Multiplataforma",
                "Compite en carreras callejeras con autos personalizados.", 4.2f,
                "Velocidad, adrenalina y mucha acción."));
        listaJuegos.add(new Juego(R.drawable.mario_bros, "Super Mario Bros", "Plataformas", "1985", "Nintendo",
                "Ayuda a Mario a rescatar a la princesa Peach.", 4.6f,
                "Un clásico que nunca pasa de moda."));

        recyclerJuego = findViewById(R.id.RecyclerJuego);
        recyclerJuego.setLayoutManager(new LinearLayoutManager(this));
        juegoAdapter = new JuegoAdapter(listaJuegos, this);
        recyclerJuego.setAdapter(juegoAdapter);
    }
}