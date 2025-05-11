package ApiServices;

import Models.Person;
import Models.Movie;
import Repository.OwnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

@Service
public class UserService {
	private final OwnRepository repository;
	private final RestTemplate restTemplate = new RestTemplate();
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public UserService(
			OwnRepository repository,
			PasswordEncoder passwordEncoder) {
		this.repository = repository;
		this.passwordEncoder = passwordEncoder;
	}

    public List<Person> getClients() {
    	return repository.getClients();
    }
    
    public List<Movie> getAvailableMovies() {
    	return repository.getAvailableMovies();
    }
    	

	public List<Movie> searchByFilters(int genre) {
		return repository.searchByFilters(genre);
	}
	
	public boolean registerClient (Person user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return repository.registerClient(user);
	}
	
	public byte[] generateQr(String message) {
		final int size = 300;
		final String format = "png";
			String apiUrl;
			URL url;
			/*apiUrl = String.format(
					"https://api.qrserver.com/v1/create-qr-code/?data=%s&size=%dx%d",
					URLEncoder.encode(message, "UTF-8"), size, size);*/
			apiUrl = String.format(
					"https://api.qrserver.com/v1/create-qr-code/?data=%s&size=%dx%d",
					message, size, size);
			ResponseEntity<byte[]> response = restTemplate.getForEntity(apiUrl, byte[].class);
			System.out.println(response.getBody());
			return response.getBody();
			
	}

	public List<Movie> getPurchaseHistory() {
		return repository.getPurchaseHistory();
	}
	
	public Person getClientByUser(String user) {
		return repository.getClientByUser(user);
	}
	
	public Person validateUser(String user, String password) {
		return repository.validateUser(user,  password);
		//return repository.validateUser(user, passwordEncoder.encode(password));
	}

}
