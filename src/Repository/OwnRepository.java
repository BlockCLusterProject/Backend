package Repository;
import Models.Client;
import Models.Admin;
import ApiServices.AdminService;
import Models.Generos;
import Models.Movie;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class OwnRepository {
    private List<Movie> dataBase = new ArrayList<>();
    private List<Admin> dataBaseAdmin = new ArrayList<>();
    private List<Client> dataBaseClient = new ArrayList<>();
    
    public OwnRepository() throws InterruptedException {
    	dataBase = initSampleData();
    	dataBaseAdmin = initAdmin();
    	dataBaseClient = initClient();
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
    
	public Admin searchAdmin (String user, String password){
		
	    for(Admin admin : dataBaseAdmin) {
	        if(admin.getUsuario().equals(user) && admin.getContrasena().equals(password)){
	            return admin;
	        }
	    }
	    return null;
	}
	
	public Client searchClient (String user, String password){
			
		for(Client client : dataBaseClient) {
		    if(client.getUsuario().equals(user) && client.getContrasena().equals(password)){
		         return client;
		    }
	      }
		  return null;
	}
    
    public List<Admin> initAdmin(){
    	List<Admin> dba = new ArrayList<>();
    	
        Admin admin1 = new Admin("juan","123","25","notiene@notiene","32323232","blockcluster1","123");
        
        Admin admin2 = new Admin("andrea","234","25","notiene@notiene","32323232","blockcluster2","234");
        
        dba.add(admin1); 
        dba.add(admin2);
        return dba;
    }
    
    public List<Client> initClient(){
    	List<Client> dbc = new ArrayList<>();
    	
        Client client1 = new Client("andrea","111","20","notiene@notiene","3207080333","cliente1","cliente1");
        Client client2 = new Client("ramon","222","20","notiene@notiene","3012502835","cliente2","cliente2");
        Client client3 = new Client("pablo","333","20","notiene@notiene","3182506735","cliente3","cliente3");
    
        dbc.add(client1); 
        dbc.add(client2);
        dbc.add(client3);
        return dbc;
    }
    
    public List<Movie> initSampleData() throws InterruptedException {
        dataBase = ApiServices.AdminService.getTrendingMovies(0);

        return dataBase;
    }
    
    public boolean updateMovie(int idMovie, Movie movie) {
    	for(Movie movies : dataBase) {
    		if(movies.getId() == idMovie) {
    			movies = movie;
    			return true;
    		}
    	}
    	
    	return false;
    }
}
