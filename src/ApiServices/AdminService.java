
package ApiServices;

import Models.Movie;
import Repository.OwnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Movie> getTrendingMovies(int genre) {
        return null;
    }
}
