/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ApiServices.AdminService;
import ApiServices.UserService;
import Entities.PurchaseHistory;
import Models.Person;
import Models.PurchaseHistoryDTO;
import Models.Movie;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 *
 * @author Dell
 */
@RestController
@RequestMapping("/api/movie")
@Tag(name = "Admin", description = "API para la gestión de peliculas para el admin")
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
    
    @GetMapping("/getAllMovies")
    @Operation(summary = "Obtener las pel�culas disponibles", description = "Devuelve una lista con todas las pel�culas disponibles en la base de datos local")
    @ApiResponses(value = {
    		@ApiResponse(responseCode = "200", description = "Lista de productos obtenidas con �xito"),
    		@ApiResponse(responseCode = "404", description = "Pel�culas no disponibles"),
    		@ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = adminService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
    @GetMapping("/trending_movies")
    @Operation(summary = "Obtener las pel�culas disponibles", description = "Se consulta listado de peliculas trending del día")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de productos obtenidas con �xito"),
        @ApiResponse(responseCode = "404", description = "Pel�culas no disponibles"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<List<Movie>> getTrendingMovies( @RequestParam(required = false) Integer genre) throws InterruptedException {
    	if(genre == null) {
    		genre = 0;
    	}
        List<Movie> movies = AdminService.getTrendingMovies(genre);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
    
     @PatchMapping("/update_movies")
     @Operation(summary = "Actualiza pelicula", description = "Se consulta la película por medio del id y se actualiza")
     @ApiResponses(value = {
             @ApiResponse(responseCode = "200", description = "Pelicula actualizada"),
             @ApiResponse(responseCode = "404", description = "Pel�culas no disponibles"),
             @ApiResponse(responseCode = "500", description = "Error interno del servidor")
        })
     public ResponseEntity<Movie> updateMovie(@RequestParam(required = true) int id_movie, @RequestParam(required = true) String movie) throws JsonMappingException, JsonProcessingException {
         ObjectMapper mapper = new ObjectMapper();
         Movie newMovie = mapper.readValue(movie, Movie.class);
    	 return new ResponseEntity<>(adminService.updateMovie(id_movie, newMovie), HttpStatus.OK);
     }

    @PostMapping("/create_movie")
    @Operation(summary= "Crea nueva pelicula", description = "")
    public ResponseEntity<Movie> createMovie(@RequestParam(required = true) String movie) throws JsonMappingException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Movie newMovie = mapper.readValue(movie, Movie.class);
        return new ResponseEntity<>(adminService.createMovie(newMovie), HttpStatus.OK);
    }

    @PostMapping("/publishMovies")
    @Operation(summary= "Crea peliculas a partir de una lista", description = "")
    public ResponseEntity<Boolean> publishMovies(@RequestParam(required = true) String movie) throws JsonMappingException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<Movie> newMovie = mapper.readValue(movie, new TypeReference<List<Movie>>() {});
        return new ResponseEntity<>(adminService.publishMovies(newMovie), HttpStatus.OK);
    }
    
    @GetMapping("/getPurchaseHistory")
    @Operation(summary= "Crea peliculas a partir de una lista", description = "")
    public ResponseEntity<List<PurchaseHistoryDTO>> getPurchaseHistory() {
    	List<PurchaseHistoryDTO> purchaseHistory = adminService.getPurchaseHistory();
    	return new ResponseEntity<>(purchaseHistory, HttpStatus.OK);
    }
}
