package ApiServices;

import Models.Person;
import Models.Movie;
import Repository.OwnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

	@Autowired
	public UserService(OwnRepository repository) throws InterruptedException {
		this.repository = repository;
		repository.initSampleData();
	}

    public List<Person> getClients() {
    	return repository.getClients();
    }
    	

	public List<Movie> searchByFilters(int genre) {
		return repository.searchByFilters(genre);
	}

	public Person searchAdmin (String user, String password){
		return repository.searchAdmin(user, password);
	}
	
	public Person searchClient (String user, String password){
		return repository.searchClient(user, password);
	}
	
	public boolean registerClient (Person user) {
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

}
