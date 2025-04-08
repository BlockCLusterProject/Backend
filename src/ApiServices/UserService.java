package ApiServices;

import Models.Admin;
import Models.Client;
import Models.Movie;
import Repository.OwnRepository;
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

	public Admin searchAdmin (String user, String password){
		return repository.searchAdmin(user, password);
	}
	
	public Client searchClient (String user, String password){
		return repository.searchClient(user, password);
	}
	
	public boolean registerClient (Client user) {
		return repository.registerClient(user);
	}

}
