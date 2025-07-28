package com.example.gamerzone;

public class Juego {
    private int imagenId;
    private String nombre;
    private String genero;
    private String anho;
    private String plataforma;
    private String descripcion;
    private float calificacion;
    private String resena;

    public Juego(int imagenId, String nombre, String genero, String anho, String plataforma, String descripcion, float calificacion, String resena) {
        this.imagenId = imagenId;
        this.nombre = nombre;
        this.genero = genero;
        this.anho = anho;
        this.plataforma = plataforma;
        this.descripcion = descripcion;
        this.calificacion = calificacion;
        this.resena = resena;
    }

    public int getImagenId() {
        return imagenId;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGenero() {
        return genero;
    }

    public String getAnho() {
        return anho;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public String getResena() {
        return resena;
    }
}
