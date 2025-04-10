
package ApiServices;

import Models.Movie;
import Repository.OwnRepository;
import io.github.cdimascio.dotenv.Dotenv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.couchbase.client.core.deps.com.fasterxml.jackson.core.type.TypeReference;
import com.couchbase.client.core.deps.com.fasterxml.jackson.databind.JsonNode;
import com.couchbase.client.core.deps.com.fasterxml.jackson.databind.ObjectMapper;
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
            ObjectMapper mapper = new ObjectMapper();

            JsonNode root = mapper.readTree(jsonResponse);
            JsonNode dataNode = root.get("results");
            System.out.println(dataNode);
            List<Movie> movies = mapper.readValue(dataNode.toString(), new TypeReference<List<Movie>>() {});

            return movies;

        } catch (IOException e) {
        	System.out.print(e.getMessage());
            return null;
        }
    }
}
