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
import org.springframework.web.bind.annotation.RequestParam;

import ApiServices.AdminService;
import ApiServices.UserService;
import Models.Movie;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 *
 * @author Dell
 */
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
            @RequestParam(required = false) Integer genre) {
    	if(genre == null) {
    		genre = 0;
    	}
        List<Movie> movies = adminService.searchByFilters(genre);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
}
