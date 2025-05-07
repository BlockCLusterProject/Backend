package Repository;
import Models.Person;
import ApiServices.AdminService;
import Models.Genre;
import Models.Movie;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class OwnRepository {
	@PersistenceContext
	private EntityManager entityManager;

    private List<Movie> dataBase = new ArrayList<>();
    private List<Person> dataBaseAdmin = new ArrayList<>();
    private List<Person> dataBaseClient = new ArrayList<>();
    
    public OwnRepository() throws InterruptedException {
    	// initSampleData();
    	//dataBaseAdmin = initAdmin();
    	//dataBaseClient = initClient();
    }
    
    @PostConstruct
    public void init() throws InterruptedException {
    	initSampleData();
    	dataBaseAdmin = initAdmin();
    	dataBaseClient = initClient();
    }
    
    @Transactional
	public Person searchClient(String user, String password) {
	    try {
	        String sql = "SELECT * FROM users WHERE user =:user AND password =:password";
	        return (Person) entityManager.createNativeQuery(sql, Person.class)
	            .setParameter("user", user)
	            .setParameter("password", password)
	            .getSingleResult();
	    } catch (NoResultException e) {
	        return null;
	    }
	}
	
	@Transactional
	public boolean registerClient(Person user) {
	    try {
	       
	        boolean exists = entityManager.createQuery(
	            "SELECT * FROM users WHERE user = :user OR email = :email", Boolean.class)
	            .setParameter("user", user.getUser())
	            .setParameter("email", user.getCorreo())
	            .getSingleResult();
	        
	        if (exists) {
	            return false; 
	        }
	        
	        entityManager.persist(user);
	        return true;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
    
    @Transactional
    public List<Person> getClients() {
    	// Query query = entityManager.createNativeQuery("SELECT id, id_rol, nombre, cedula, age, email, phone, usuario, contrasena FROM users", Client.class);
    	// Query query = entityManager.createQuery("FROM Person", Person.class);
    	Query query = entityManager.createNativeQuery("SELECT * FROM users", Person.class);
    	System.out.println(entityManager.getMetamodel().getEntities());
    	List<Person> rows = query.getResultList();
    	return rows;
    }

    public List<Movie> searchByFilters(int genre) {
        List<Movie> result = new ArrayList<>();
        // TODO: revisar la implementaci�n de esta funci�n, null en generos
        /*
        for(Movie movie : dataBase) {
            boolean existingMovie = (genre == 0 ||
                    movie.getGenres().contains(Generos.getGenreById(genre)));
            if(existingMovie) {
                result.add(movie);
            }
        }

        return result;
        */
        System.out.println(dataBase);
        return dataBase;
    }
    
	public Person searchAdmin (String user, String password){
		System.out.println(user +" : "+password);
	    for(Person admin : dataBaseAdmin) {
	        if(admin.getUser().equals(user) && admin.getPassword().equals(password)){
	            return admin;
	        }
	    }
	    return null;
	}
    
    public List<Person> initAdmin(){
    	List<Person> dba = new ArrayList<>();
    	
        // Admin admin1 = new Admin("juan","123",25,"notiene@notiene","32323232","blockcluster1","123");
        
        // Admin admin2 = new Admin("andrea","234",25,"notiene@notiene","32323232","blockcluster2","234");
        
        // dba.add(admin1); 
        // dba.add(admin2);
        return dba;
    }
    
    public List<Person> initClient(){
    	List<Person> dbc = new ArrayList<>();
    	List<String> preference = null;
    	 	
        // Client client1 = new Client("andrea","111",20,"notiene@notiene","3207080333","cliente1","cliente1", Arrays.asList(Genre.ACCION, Genre.AVENTURA));
        // Client client2 = new Client("ramon","222","20","notiene@notiene","3012502835","cliente2","cliente2");
        // Client client3 = new Client("pablo","333","20","notiene@notiene","3182506735","cliente3","cliente3");
    
        // dbc.add(client1); 
        // dbc.add(client2);
        // dbc.add(client3);
        return dbc;
    }
    
    public void initSampleData() throws InterruptedException {
        this.dataBase = AdminService.getTrendingMovies(0);
    }
    
    public Movie updateMovie(int idMovie, Movie movie) {
    	for(Movie movies : dataBase) {
    		if(movies.getId() == idMovie) {
    			movies = movie;
    			return movies;
    		}
    	}
    	
    	return null;
    }

    public Movie createMovie(Movie movie) {
        dataBase.add(movie);
        return movie;
    }
}
