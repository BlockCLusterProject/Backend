package Models;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public enum Genre implements Serializable {
    ACCION(28),
    ANIMACION(16),
    DOCUMENTAL(99),
    DRAMA(18),
    FAMILIAR(10751),
    FANTASIA(14),
    HISTORIA(36),
    COMEDIA(35),
    GUERRA(10752),
    CRIMEN(80),
    MUSICA(10402),
    MISTERIO(9648),
    ROMANCE(10749),
    CIENCIA_FICCION(878),
    TERROR(27),
    MOVIE_TV(10770),
    THRILLER(53),
    WESTERN(37),
    AVENTURA(12);

    private final int idTmdb;

    Genre(int idTmdb) {
        this.idTmdb = idTmdb;
    }

    public int getIdTmdb() {
        return idTmdb;
    }

    private static final Map<Integer, Genre> ID_TO_GENRE = new HashMap<>();

    static {
        for(Genre genre : Genre.values()) {
            ID_TO_GENRE.put(genre.getIdTmdb(), genre);
        }
    }

    public static Genre getGenreById(int idApi) {
        return ID_TO_GENRE.get(idApi);
    }

    private static final Map<String, Genre> NAME_TO_GENRE = new HashMap<>();

    static {
        NAME_TO_GENRE.put("Accion", ACCION);
        NAME_TO_GENRE.put("Animacion", ANIMACION);
        NAME_TO_GENRE.put("Aventura", AVENTURA);
        NAME_TO_GENRE.put("Documental", DOCUMENTAL);
        NAME_TO_GENRE.put("Drama", DRAMA);
        NAME_TO_GENRE.put("Familiar", FAMILIAR);
        NAME_TO_GENRE.put("Fantasia", FANTASIA);
        NAME_TO_GENRE.put("Historia", HISTORIA);
        NAME_TO_GENRE.put("Comedia", COMEDIA);
        NAME_TO_GENRE.put("Guerra", GUERRA);
        NAME_TO_GENRE.put("Crimen", CRIMEN);
        NAME_TO_GENRE.put("Musica", MUSICA);
        NAME_TO_GENRE.put("Misterio", MISTERIO);
        NAME_TO_GENRE.put("Romance", ROMANCE);
        NAME_TO_GENRE.put("Ciencia ficcion", CIENCIA_FICCION);
        NAME_TO_GENRE.put("Terror", TERROR);
        NAME_TO_GENRE.put("Pelicula de tv", MOVIE_TV);
        NAME_TO_GENRE.put("Thriller", THRILLER);
        NAME_TO_GENRE.put("Western", WESTERN);
    }

    public static Genre getGenreByName(String movieName) {
        return NAME_TO_GENRE.get(movieName);
    }

}
