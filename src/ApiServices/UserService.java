package ApiServices.BackEnd;

import modelos.Movie;
import ApiServices.OwnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final OwnRepository repository;

    @Autowired
    public UserService(OwnRepository repository) {
        this.repository = repository;
        repository.initSampleData();
    }

    public List<Movie> searchByFilters(int genre) {
        return repository.searchByFilters(genre);
    }

}
