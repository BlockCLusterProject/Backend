package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import Entities.PurchaseHistory;
import Models.Movie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@Repository
public class AdminRepository {
    @PersistenceContext
    private EntityManager entityManager;
    public AdminRepository() {}

    @Transactional
    public List<Movie> getAvailableMovies() {
        Query query = entityManager.createNativeQuery("SELECT * FROM movies ORDER BY id", Movie.class);
        return  query.getResultList();
    }

    @Transactional
    public Movie createMovie(Movie movie) {
        entityManager.persist(movie);
        return movie;
    }

    @Transactional
    public Movie updateMovie(int id_movie, Movie movie){
        Query query = entityManager.createNativeQuery("""
            UPDATE movies SET title= :title, runtime= :runtime, vote_average= :rate, price= :price, overview= :overview, backdrop_path= :backdrop_path, is_active= :is_active, quantity= :quantity WHERE id = :id;
        """, Movie.class);
        query.setParameter("title", movie.getTitle());
        query.setParameter("backdrop_path", movie.getBackdrop_path());
        query.setParameter("overview", movie.getOverview());
        query.setParameter("quantity", movie.getQuantity());
        query.setParameter("price", movie.getPrice());
        query.setParameter("rate", movie.getVote_average());
        query.setParameter("runtime", movie.getRuntime());
        query.setParameter("is_active", movie.isActive() ? 1 : 0);
        query.setParameter("id", id_movie);
        
        query.executeUpdate();
        
        return movie;
    }

    @Transactional
    public Boolean publishMovies(List<Movie> movies) {
        try{
            for(int i = 0; i < movies.size(); i++){
        		String overView =  movies.get(i).getOverview();
            	movies.get(i).setOverview( movies.get(i).getOverview().length() > 150 ? overView.substring(0, 147) + "..." 
            		    : overView);
                entityManager.persist(movies.get(i));
            }
            return true;
        } catch(Exception ex) {
        	System.out.print(ex.getMessage());
            return false;
        }
    }
    
    @Transactional 
    public List<PurchaseHistory> getPurchaseHistory(){
        Query query = entityManager.createNativeQuery("SELECT * FROM purchases_history ORDER BY id", PurchaseHistory.class);
        return query.getResultList();
    }
}