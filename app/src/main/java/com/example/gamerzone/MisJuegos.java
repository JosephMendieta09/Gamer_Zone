package com.example.gamerzone;

import java.util.ArrayList;
import java.util.List;

public class MisJuegos {
    private static List<Juego> listaJuegos;
    public static List<Juego> lista(){
        if (listaJuegos == null){
            listaJuegos = new ArrayList<>();

            listaJuegos.add(new Juego(R.drawable.warcraft, "Warcraft", "Estrategia", "2002", "PC",
                    "Conquista reinos en un mundo de fantasía épica, donde cada decisión puede cambiar el destino de la guerra.",
                    4.3f, "Un clásico del género que marcó la evolución de los juegos de estrategia en tiempo real, con una narrativa envolvente y mecánicas sólidas."));

            listaJuegos.add(new Juego(R.drawable.clash_royale, "Clash Royale", "Estrategia", "2016", "Android/iOS",
                    "Cartas, torres y batallas en tiempo real en duelos llenos de adrenalina con personajes del universo Clash.",
                    4.8f, "Un título adictivo que mezcla lo mejor de los juegos de cartas y tower defense con partidas rápidas y estrategia pura."));

            listaJuegos.add(new Juego(R.drawable.minecraft, "Minecraft", "Aventura", "2011", "Multiplataforma",
                    "Explora mundos infinitos, construye sin límites y sobrevive en un entorno completamente moldeable.",
                    4.0f, "Una experiencia de juego infinita, ideal para mentes creativas y exploradoras, que sigue creciendo con su comunidad."));

            listaJuegos.add(new Juego(R.drawable.god_of_war, "God of War", "Acción", "2018", "PlayStation",
                    "Kratos y su hijo se enfrentan a dioses y criaturas mitológicas en una épica aventura nórdica.",
                    4.5f, "Una obra maestra visual y narrativa, con combates intensos, desarrollo de personajes profundo y escenarios impresionantes."));

            listaJuegos.add(new Juego(R.drawable.mobile_legends, "Mobile Legends", "MOBA", "2016", "Android/iOS",
                    "Combates 5v5 rápidos y estratégicos en línea con héroes únicos y acción constante.",
                    4.1f, "Perfecto para partidas rápidas y competitivas, con una comunidad activa y gran variedad de campeones."));

            listaJuegos.add(new Juego(R.drawable.fifa_mobile, "FIFA Mobile", "Deportes", "2023", "Android/iOS",
                    "Juega partidos rápidos, colecciona estrellas y compite por convertirte en el mejor entrenador.",
                    5.0f, "Ideal para los amantes del fútbol, ofrece buena jugabilidad, eventos semanales y mucha personalización."));

            listaJuegos.add(new Juego(R.drawable.call_of_duty, "Call of Duty", "Acción", "2020", "Multiplataforma",
                    "Combates intensos con gráficos realistas y una variedad de modos multijugador.",
                    5.0f, "Acción trepidante, escenarios cinematográficos y excelente jugabilidad tanto en modo historia como online."));

            listaJuegos.add(new Juego(R.drawable.plantas_vs_zombies, "Plantas vs Zombies", "Estrategia", "2009", "Multiplataforma",
                    "Defiende tu jardín de zombis usando una gran variedad de plantas con habilidades especiales.",
                    4.5f, "Divertido, original y con una curva de dificultad bien balanceada. Un juego icónico que no pasa de moda."));

            listaJuegos.add(new Juego(R.drawable.need_for_speed, "Need for Speed", "Carreras", "2015", "Multiplataforma",
                    "Compite en carreras callejeras con autos personalizables en un entorno urbano de alto riesgo.",
                    4.2f, "Adrenalina pura, excelente selección de vehículos y gráficos de alta calidad. Una saga de velocidad y estilo."));

            listaJuegos.add(new Juego(R.drawable.mario_bros, "Super Mario Bros", "Plataformas", "1985", "Nintendo",
                    "Ayuda a Mario a rescatar a la princesa Peach saltando y esquivando enemigos clásicos.",
                    4.6f, "Un clásico atemporal con mecánicas simples pero desafiantes, ideal para todas las generaciones."));
        }
        return listaJuegos;
    }

    public static void insertarJuego(Juego juego) {
        listaJuegos.add(0, juego);
    }
}
