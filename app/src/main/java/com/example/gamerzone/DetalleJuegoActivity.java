package com.example.gamerzone;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetalleJuegoActivity extends AppCompatActivity {
    ImageView imgJuego;
    TextView txtNombre, txtGenero, txtPlataforma, txtAnho, txtDescripcion, txtResena;
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_juego);

        Toolbar toolbar = findViewById(R.id.toolbarDetalle);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Mostrar botón de retroceso

        // 2. Enlazar vistas
        imgJuego = findViewById(R.id.imgJuegoDetalle);
        txtNombre = findViewById(R.id.txtNombreDetalle);
        txtGenero = findViewById(R.id.txtGeneroDetalle);
        txtPlataforma = findViewById(R.id.txtPlataforma);
        txtAnho = findViewById(R.id.txtAnho);
        txtDescripcion = findViewById(R.id.txtDescripcion);
        txtResena = findViewById(R.id.txtResena);
        ratingBar = findViewById(R.id.ratingDetalle);

        // 3. Recibir datos
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            imgJuego.setImageResource(bundle.getInt("imagenId"));
            txtNombre.setText(bundle.getString("nombre"));
            txtGenero.setText("Género: " + bundle.getString("genero"));
            txtPlataforma.setText("Plataforma: " + bundle.getString("plataforma"));
            txtAnho.setText("Año: " + bundle.getString("anho"));
            txtDescripcion.setText("Descripción: " + bundle.getString("descripcion"));
            ratingBar.setRating(bundle.getFloat("calificacion"));
            txtResena.setText("Reseña: " + bundle.getString("resena"));

            // Cambiar el título de la barra con el nombre del juego
            getSupportActionBar().setTitle(bundle.getString("nombre"));
        }
    }

    // 4. Acción al presionar el botón de retroceso
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}