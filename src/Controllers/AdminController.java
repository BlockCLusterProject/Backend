/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ApiServices.AdminService;
import ApiServices.UserService;
import Models.Movie;
import io.swagger.v3.oas.annotations.Operation;
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

    @GetMapping("/available_movies")
    @Operation(summary = "Obtener las pel�culas disponibles", description = "Devuelve una lista con todas las pel�culas disponibles en la base de datos local")
    @ApiResponses(value = {
    		@ApiResponse(responseCode = "200", description = "Lista de productos obtenidas con �xito"),
    		@ApiResponse(responseCode = "404", description = "Pel�culas no disponibles"),
    		@ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<List<Movie>> getAvailableMovies(
            @RequestParam(required = false) int genre) {
        List<Movie> movies = adminService.searchByFilters(genre);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
    @GetMapping("/trending_movies")
    @Operation(summary = "Obtener las pel�culas disponibles", description = "Se consulta listado de peliculas trending del día")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de productos obtenidas con �xito"),
        @ApiResponse(responseCode = "404", description = "Pel�culas no disponibles"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<List<Movie>> getTrendingMovies( @RequestParam(required = false) int genre) throws InterruptedException {
        List<Movie> movies = adminService.getTrendingMovies(genre);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
}
