package modelos;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public enum Generos implements Serializable {
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

    Generos(int idTmdb) {
        this.idTmdb = idTmdb;
    }

    public int getIdTmdb() {
        return idTmdb;
    }

    private static final Map<Integer, Generos> ID_TO_GENRE = new HashMap<>();

    static {
        for(Generos genre : Generos.values()) {
            ID_TO_GENRE.put(genre.getIdTmdb(), genre);
        }
    }

    public static Generos getGenreById(int idApi) {
        return ID_TO_GENRE.get(idApi);
    }

    private static final Map<String, Generos> NAME_TO_GENRE = new HashMap<>();

    static {
        NAME_TO_GENRE.put("accion", ACCION);
        NAME_TO_GENRE.put("animacion", ANIMACION);
        NAME_TO_GENRE.put("aventura", AVENTURA);
        NAME_TO_GENRE.put("documental", DOCUMENTAL);
        NAME_TO_GENRE.put("drama", DRAMA);
        NAME_TO_GENRE.put("familiar", FAMILIAR);
        NAME_TO_GENRE.put("fantasia", FANTASIA);
        NAME_TO_GENRE.put("historia", HISTORIA);
        NAME_TO_GENRE.put("comedia", COMEDIA);
        NAME_TO_GENRE.put("guerra", GUERRA);
        NAME_TO_GENRE.put("crimen", CRIMEN);
        NAME_TO_GENRE.put("musica", MUSICA);
        NAME_TO_GENRE.put("misterio", MISTERIO);
        NAME_TO_GENRE.put("romance", ROMANCE);
        NAME_TO_GENRE.put("ciencia ficcion", CIENCIA_FICCION);
        NAME_TO_GENRE.put("terror", TERROR);
        NAME_TO_GENRE.put("pelicula de tv", MOVIE_TV);
        NAME_TO_GENRE.put("thriller", THRILLER);
        NAME_TO_GENRE.put("western", WESTERN);
    }

    public static Generos getGenreByName(String movieName) {
        return NAME_TO_GENRE.get(movieName);
    }

}
