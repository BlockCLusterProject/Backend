
package ApiServices;

import Models.Movie;
import Repository.OwnRepository;
import io.github.cdimascio.dotenv.Dotenv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.lang.reflect.Type;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


@Service
public class AdminService {
    private final OwnRepository repository;

    @Autowired
    public AdminService(OwnRepository repository) {
        this.repository = repository;
        repository.initSampleData();
    }

    public List<Movie> searchByFilters(int genre) {
        return repository.searchByFilters(genre);
    }

    public List<Movie> getTrendingMovies(int genre) throws InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        Dotenv dotenv = Dotenv.load();
        String UrlMovieDb = dotenv.get("baseURL");
        String apiKey = dotenv.get("APIKEY");

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(UrlMovieDb + "trending/movie/day?api_key=" + apiKey + "&language=es-ES")) // Usar
                                                                                                              // URI.create
                                                                                                              // para la
                                                                                                              // URL
                    .header("Content-Type", "application/json") // Cabecera para JSON
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String jsonResponse = response.body();

            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(jsonResponse, JsonObject.class);
        	System.out.print(jsonResponse);
            // Acceder al campo "results" que es un arreglo de películas
            JsonArray resultsArray = jsonObject.getAsJsonArray("results");

            // Convertir el JsonArray a una lista de objetos Movie
            Type movieListType = new TypeToken<List<Movie>>() {
            }.getType();
            List<Movie> movies = gson.fromJson(resultsArray, movieListType);
            
            for(int i = 0; i < movies.size(); i++) {
        		System.out.print(movies.get(i).getTitulo());
        	}

            return movies;

        } catch (IOException e) {
            return null;
        }
    }
}
