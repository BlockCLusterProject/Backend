package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

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
        Query query = (Query) entityManager.createNativeQuery("SELECT * FROM movies", Movie.class);
        return ((jakarta.persistence.Query) query).getResultList();
    }

    @Transactional
    public Movie createMovie(Movie movie) {
        entityManager.persist(movie);
        return movie;
    }

    @Transactional
    public Movie updateMovie(int id_movie, Movie movie){
        Query query = (Query) entityManager.createNativeQuery("""
            UPDATE movies SET title= :title, runtime= :runtime, vote_average= :rate, price= :price, overview= :overview, backdrop_path= :backdrop_path, is_active= :is_active, quantity= :quantity WHERE id IS NULL;

            SELECT * FROM movies WHERE id = :id
        """, Movie.class);
        ((jakarta.persistence.Query) query).setParameter("title", movie.getTitle());
        ((jakarta.persistence.Query) query).setParameter("backdrop_path", movie.getBackdrop_path());
        ((jakarta.persistence.Query) query).setParameter("overview", movie.getOverview());
        ((jakarta.persistence.Query) query).setParameter("quantity", movie.getCantidad());
        ((jakarta.persistence.Query) query).setParameter("price", movie.getPrice());
        ((jakarta.persistence.Query) query).setParameter("rate", movie.getRate());
        ((jakarta.persistence.Query) query).setParameter("runtime", movie.getRuntime());
        ((jakarta.persistence.Query) query).setParameter("is_active", movie.isActive() ? 1 : 0);
        ((jakarta.persistence.Query) query).setParameter("id", id_movie);
        Movie producto = (Movie) ((jakarta.persistence.Query) query).getSingleResult();
        
        return producto;
    }
}