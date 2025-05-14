package Repository;
import Models.Person;
import ApiServices.AdminService;
import Entities.PurchaseHistory;
import Entities.Rol;
import Models.ClientSesion;
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

    public OwnRepository() throws InterruptedException {
    }
    
    @Transactional 
    public Person validateUser(String user, String password) {
    	try {
			String sql = "SELECT * FROM users WHERE usuario = :user";
			Person response = (Person) entityManager.createNativeQuery(sql, Person.class)
					.setParameter("user", user)
					.getSingleResult();
			if(response.getPassword().equals(password)) {
				System.out.println("return");
				return response;
			}
			return null;
    	} catch(NoResultException e) {
    		return null;
    	}
    }
    
    @Transactional
    public Integer getIdRol(String nameRol) {
    	Rol idRol = (Rol) entityManager.createNativeQuery("SELECT * FROM rol WHERE rol = :rol", Rol.class)
    			.setParameter("rol", nameRol)
    			.getSingleResult();
    	return idRol.getId();
    }
    
    @Transactional
	public Person searchClient(String user, String password) {
	    try {
	        String sql = "SELECT * FROM users WHERE usuario =:user AND contrasena =:password";
	        return (Person) entityManager.createNativeQuery(sql, Person.class)
	            .setParameter("user", user)
	            .setParameter("password", password)
	            .getSingleResult();
	    } catch (NoResultException e) {
	        return null;
	    }
	}
	
	@Transactional
	public Person registerClient(Person user) {
	    try {
          //  Person exists = entityManager.createQuery(
	      //          "SELECT * FROM users WHERE usuario = :user OR email = :email", Person.class)
	      //          .setParameter("user", user.getUser())
	      //          .setParameter("email", user.getCorreo())
	       //         .getSingleResult();
	            // Si llega aquí, encontró un resultado
	            //return exists;
	        entityManager.persist(user);
	        return user; 
	    } catch (Exception e) {
            // No se encontró ningún resultado
//	        entityManager.persist(user);
	        return user; 
	    }
	}
    
    @Transactional
    public List<Person> getClients() {
    	Query query = entityManager.createNativeQuery("SELECT * FROM users", Person.class);
    	System.out.println(entityManager.getMetamodel().getEntities());
    	List<Person> rows = query.getResultList();
    	return rows;
    }
    
    @Transactional
    public List<Movie> getAvailableMovies() {
    	String sql = "SELECT * FROM movies WHERE is_active = TRUE";
    	Query query = entityManager.createNativeQuery(sql, Movie.class);
    	System.out.println(query.getResultList());
    	return query.getResultList();
    }

    public List<Movie> searchByFilters(int genre) {
        List<Movie> result = new ArrayList<>();
        return result;
    }
    
	public Person searchAdmin (String user, String password){
	    return null;
	}
	
	@Transactional
	public Movie getMovieById(Integer movieId) {
		String sql = "SELECT * WHERE movie_id = :movieId";
		Query query = entityManager.createNativeQuery(sql, Movie.class)
				.setParameter("movieId", movieId);
		return (Movie) query.getSingleResult();
	}
    
	@Transactional
	public List<Movie> getPurchaseHistory() {
		Person sesion = ClientSesion.getInstance().getClient();
		String sql = "SELECT movie_id, price WHERE client_id = :client_id";
		Query query = entityManager.createNativeQuery(sql, PurchaseHistory.class)
				.setParameter("client_id", sesion.getId());
		List<PurchaseHistory> history = query.getResultList();
		List<Movie> result = new ArrayList<>();
		for(PurchaseHistory purchase : history) {
			result.add(getMovieById(purchase.getMovie_id()));
		}
		
		return result;
	}
	
	@Transactional
	public Person getClientByUser(String user) {
		String sql = "SELECT * WHERE id_rol = 1 AND usuario = :user";
		Query query = entityManager.createNativeQuery(sql, Person.class)
				.setParameter("user", user);
		return (Person) query.getSingleResult();
	}
}
