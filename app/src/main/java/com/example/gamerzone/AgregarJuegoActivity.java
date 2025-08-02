package com.example.gamerzone;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class AgregarJuegoActivity extends AppCompatActivity {

    DrawerLayout drawerLayou;
    NavigationView navigationVie;
    Toolbar toolba;

    private EditText etNombre, etAnho, etDescripcion, etCalificacion, etResena;
    private AutoCompleteTextView autoGenero, autoPlataforma;
    private ImageButton imageButton;
    private int imagenSeleccionadaResId = R.drawable.camara; // imagen por defecto
    private String[] generos = {"Estrategia", "Acción", "Aventura", "MOBA", "Carreras", "Casino", "Deportes", "Terror", "Plataformas"};
    private String[] plataformas = {"PC", "PlayStation", "Xbox", "Nintendo", "Android/iOS", "Multiplataforma"};
    private @DrawableRes int[] imagenesDisponibles = {R.drawable.crash, R.drawable.vice_city, R.drawable.pac_man,};

    private void mostrarCerrarSesion() {
        new AlertDialog.Builder(this)
                .setTitle("Cerrar sesión")
                .setMessage("¿Estás seguro de que deseas cerrar sesión?")
                .setPositiveButton("Aceptar", (dialog, which) -> {
                    Intent intent = new Intent(AgregarJuegoActivity.this, InicioSesionActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                })
                .setNegativeButton("Cancelar", null).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_juego);

        drawerLayou = findViewById(R.id.drawer_layout);
        navigationVie = findViewById(R.id.navigation_view);
        toolba = findViewById(R.id.toolbar);

        setSupportActionBar(toolba);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayou, toolba, R.string.open, R.string.close);

        drawerLayou.addDrawerListener(toggle);
        toggle.syncState();

        navigationVie.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayou.closeDrawers();
                int id = item.getItemId();
                if (id == R.id.nav_inicio){
                    Intent jugar = new Intent(AgregarJuegoActivity.this, InicioActivity.class);
                    startActivity(jugar);
                    Toast.makeText(AgregarJuegoActivity.this, "Estoy en Inicio", Toast.LENGTH_LONG).show();
                } else if (id == R.id.nav_juegos){
                    Intent jugar = new Intent(AgregarJuegoActivity.this, JuegosActivity.class);
                    startActivity(jugar);
                    Toast.makeText(AgregarJuegoActivity.this, "Estoy en Juegos", Toast.LENGTH_LONG).show();
                } else if (id == R.id.nav_categoria){
                    Intent jugar = new Intent(AgregarJuegoActivity.this, GenerosActivity.class);
                    startActivity(jugar);
                    Toast.makeText(AgregarJuegoActivity.this, "Estoy en Categorias", Toast.LENGTH_LONG).show();
                } else if (id == R.id.nav_nuevojuego){
                    Toast.makeText(AgregarJuegoActivity.this, "Estoy en Agregar Juego", Toast.LENGTH_LONG).show();
                } else if (id == R.id.nav_close){
                    mostrarCerrarSesion();
                    return true;
                }
                return false;
            }
        });

        // Vincular vistas
        etNombre = findViewById(R.id.et_nombre);
        etAnho = findViewById(R.id.et_anho);
        etDescripcion = findViewById(R.id.et_descripcion);
        etCalificacion = findViewById(R.id.et_calificacion);
        etResena = findViewById(R.id.et_resena);
        autoGenero = findViewById(R.id.autoGenero);
        autoPlataforma = findViewById(R.id.autoPlataforma);
        imageButton = findViewById(R.id.imageButton);
        Button btnGuardar = findViewById(R.id.btnGuardar);

        // Configurar AutoCompleteTextView
        ArrayAdapter<String> generoAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, generos);
        autoGenero.setAdapter(generoAdapter);
        autoGenero.setInputType(InputType.TYPE_NULL);
        autoGenero.setKeyListener(null);
        autoGenero.setOnClickListener(v -> autoGenero.showDropDown());

        ArrayAdapter<String> plataformaAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, plataformas);
        autoPlataforma.setAdapter(plataformaAdapter);
        autoPlataforma.setInputType(InputType.TYPE_NULL);
        autoPlataforma.setKeyListener(null);
        autoPlataforma.setOnClickListener(v -> autoPlataforma.showDropDown());

        // Evento del botón de imagen
        imageButton.setOnClickListener(view -> mostrarDialogoSeleccionImagen());

        // Evento del botón guardar
        btnGuardar.setOnClickListener(view -> guardarJuego());
    }

    private void mostrarDialogoSeleccionImagen() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Selecciona una imagen");

        String[] nombresImagenes = {"Crash", "Vice City", "Pac Man"};

        builder.setItems(nombresImagenes, (dialogInterface, i) -> {
            imagenSeleccionadaResId = imagenesDisponibles[i];
            imageButton.setImageResource(imagenSeleccionadaResId);
        });

        builder.setNegativeButton("Cancelar", null);
        builder.show();
    }

    private void guardarJuego() {
        String nombre = etNombre.getText().toString().trim();
        String genero = autoGenero.getText().toString().trim();
        String anho = etAnho.getText().toString().trim();
        String plataforma = autoPlataforma.getText().toString().trim();
        String descripcion = etDescripcion.getText().toString().trim();
        String calificacionStr = etCalificacion.getText().toString().trim();
        String resena = etResena.getText().toString().trim();

        // Validaciones
        if (nombre.isEmpty()) {
            etNombre.setError("El nombre es obligatorio");
            return;
        }
        if (genero.isEmpty()) {
            autoGenero.setError("La categoria es obligatorio");
            return;
        }
        if (calificacionStr.isEmpty()) {
            etCalificacion.setError("La calificación es obligatoria");
            return;
        }

        float calificacion;
        try {
            calificacion = Float.parseFloat(calificacionStr);
        } catch (NumberFormatException e) {
            etCalificacion.setError("Calificación inválida");
            return;
        }

        // Crear intent y enviar datos mediante Bundle
        Bundle bundle = new Bundle();
        bundle.putInt("imagenId", imagenSeleccionadaResId);
        bundle.putString("nombre", nombre);
        bundle.putString("genero", genero);
        bundle.putString("anho", anho);
        bundle.putString("plataforma", plataforma);
        bundle.putString("descripcion", descripcion);
        bundle.putFloat("calificacion", calificacion);
        bundle.putString("resena", resena);

        Intent intent = new Intent(AgregarJuegoActivity.this, JuegosActivity.class);
        intent.putExtra("nuevo_juego", bundle);
        startActivity(intent);

        Toast.makeText(this, "Juego registrado correctamente", Toast.LENGTH_SHORT).show();
    }
}