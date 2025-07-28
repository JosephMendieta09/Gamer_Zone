package com.example.gamerzone;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class JuegoAdapter extends RecyclerView.Adapter<JuegoAdapter.JuegoViewHolder> {
    private List<Juego> listaJuegos;
    Context context;

    public JuegoAdapter(List<Juego> listaJuegos, Context context) {
        this.listaJuegos = listaJuegos;
        this.context = context;
    }

    @NonNull
    @Override
    public JuegoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_juego, parent,false);
        return new JuegoViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull JuegoViewHolder holder, int position) {
        Juego juego = listaJuegos.get(position);
        holder.bind(juego);
    }

    @Override
    public int getItemCount() {
        return listaJuegos.size();
    }

    public class JuegoViewHolder extends RecyclerView.ViewHolder {
        TextView txtnombre, txtgenero;
        ImageView imageJuego;
        RatingBar ratinBar;
        public JuegoViewHolder(@NonNull View itemView) {
            super(itemView);
            txtnombre = itemView.findViewById(R.id.tvNombre);
            txtgenero = itemView.findViewById(R.id.tvGenero);
            imageJuego = itemView.findViewById(R.id.imageJuego);
            ratinBar = itemView.findViewById(R.id.ratingBar);
        }

        public void bind(Juego juego) {
            txtnombre.setText(juego.getNombre());
            txtgenero.setText(juego.getGenero());
            imageJuego.setImageResource(juego.getImagenId());
            ratinBar.setRating(juego.getCalificacion());

            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(context, DetalleJuegoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("imagenId", juego.getImagenId());
                bundle.putString("nombre", juego.getNombre());
                bundle.putString("genero", juego.getGenero());
                bundle.putString("anho", juego.getAnho());
                bundle.putString("plataforma", juego.getPlataforma());
                bundle.putString("descripcion", juego.getDescripcion());
                bundle.putFloat("calificacion", juego.getCalificacion());
                bundle.putString("resena", juego.getResena());

                intent.putExtras(bundle);
                context.startActivity(intent);
            });
        }
    }
}
