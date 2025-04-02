package Repository;

import Models.Generos;
import Models.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class OwnRepository {
    private List<Movie> dataBase = new ArrayList<>();
    
    public OwnRepository() {
    	dataBase = initSampleData();
    }

    public List<Movie> searchByFilters(int genre) {
        List<Movie> result = new ArrayList<>();
        for(Movie movie : dataBase) {
            boolean existingMovie = (genre == 0 ||
                    movie.getGeneros().contains(Generos.getGenreById(genre)));
            if(existingMovie) {
                result.add(movie);
            }
        }

        return result;
    }

    public List<Movie> initSampleData() {
        List<Movie> result = new ArrayList<>();

        Movie p1 = new Movie("gogogo", 120,6.6,
                new ArrayList<>(Arrays.asList(Generos.ACCION, Generos.COMEDIA)),
                1000,
                "dfkj",
                "/img/terminator_2.jpg", 0);
        Movie p2 = new Movie("Terminator 2", 137, 6.6,
        new ArrayList<>(Arrays.asList(Generos.AVENTURA, Generos.FANTASIA)), 11000,
        "Algunos años antes, un viajero del tiempo le reveló " +
                "a la madre de John que su hijo sería el salvador de " +
                "la humanidad. Cuando un nuevo androide mejorado llega " +
                "del futuro para asesinar a John, un viejo modelo será " +
                "enviado para protegerle.", "/img/terminator_2.jpg", 0);
        Movie p3 = new Movie("p3", 3, 3.3,
        new ArrayList<>(Arrays.asList(Generos.COMEDIA, Generos.CIENCIA_FICCION)),30000, "3", "/img/terminator_2.jpg", 0);
        Movie p4 = new Movie("p4", 4, 4.4,
        new ArrayList<>(Arrays.asList(Generos.DRAMA, Generos.TERROR)),40000, "4", "/img/terminator_2.jpg", 0);
        Movie p5 = new Movie("p5", 5, 5.5,
        new ArrayList<>(Arrays.asList(Generos.DRAMA, Generos.TERROR))	, 50000, "5", "/img/terminator_2.jpg", 0);
        Movie p6 = new Movie("p6", 6, 6.6,
        new ArrayList<>(Arrays.asList(Generos.DRAMA, Generos.TERROR))	, 60000, "6", "/img/terminator_2.jpg", 0);
        Movie p7 = new Movie("p7", 7, 7.7,
        new ArrayList<>(Arrays.asList(Generos.DRAMA, Generos.TERROR))	, 60000, "7", "/img/terminator_2.jpg", 0);
        Movie p8 = new Movie("p8", 8, 8.8,
        new ArrayList<>(Arrays.asList(Generos.DRAMA, Generos.TERROR))	, 60000, "8", "/img/terminator_2.jpg", 0);
        Movie p9 = new Movie("p9", 9, 9.9,
        new ArrayList<>(Arrays.asList(Generos.DRAMA, Generos.TERROR))	, 60000, "9", "/img/terminator_2.jpg", 0);
        Movie p10 = new Movie("p10", 10, 10.0,
        new ArrayList<>(Arrays.asList(Generos.DRAMA, Generos.TERROR))	, 100000, "10", "/img/terminator_2.jpg", 0);
        Movie p11 = new Movie("p11", 11, 11.1,
        new ArrayList<>(Arrays.asList(Generos.DRAMA, Generos.TERROR))	, 110000, "11", "/img/terminator_2.jpg", 0);
        Movie p12 = new Movie("p12", 12, 12.2,
        new ArrayList<>(Arrays.asList(Generos.DRAMA, Generos.TERROR))	, 120000, "12", "/img/terminator_2.jpg", 0);
        Movie p13 = new Movie("p13", 13, 13.3,
                new ArrayList<>(Arrays.asList(Generos.DRAMA, Generos.TERROR))	, 130000, "13", "/img/terminator_2.jpg", 0);

        result.add(p1);
        result.add(p2);
        result.add(p3);
        result.add(p4);
        result.add(p5);
        result.add(p6);
        result.add(p7);
        result.add(p8);
        result.add(p9);
        result.add(p10);
        result.add(p11);
        result.add(p12);
        result.add(p13);

        return result;
    }
}
