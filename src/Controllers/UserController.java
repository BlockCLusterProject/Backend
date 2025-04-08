/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import ApiServices.UserService;
import Models.Admin;
import Models.Client;
import Models.Movie;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * @author JuanCGallo
 */
@RestController
@RequestMapping("api/users")
@Tag(name = "User", description = "API para la gesti�n de usuarios")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
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
        List<Movie> movies = userService.searchByFilters(genre);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
    
    @GetMapping("/validateAdmin")
    @Operation(summary = "Obtener admin", description = "Devuelve un admin")
    @ApiResponses(value = {
    		@ApiResponse(responseCode = "200", description = "Admin obtenido con exito"),
    		@ApiResponse(responseCode = "404", description = "Admin no encontrado"),
    		@ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    
    public ResponseEntity<Admin> searchAdmin(
            @RequestParam(required = false) String user,
            @RequestParam(required = false) String password) {
    	System.out.println(user+" : "+password);
    	if (user == null || password == null) {
    		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); 
    	}
        Admin admin = userService.searchAdmin(user, password);
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }
    
    // Crear un nuevo usuario
    @PostMapping
    public ResponseEntity<Client> registerClient(@RequestBody Client user) {
    boolean newUser = userService.registerClient(user);
    return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    
    @GetMapping("/validateClient")
    @Operation(summary = "Obtener Client", description = "Devuelve un Client")
    @ApiResponses(value = {
    		@ApiResponse(responseCode = "200", description = "Client obtenido con exito"),
    		@ApiResponse(responseCode = "404", description = "Client no encontrado"),
    		@ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    
    public ResponseEntity<Client> searchClient(
            @RequestParam(required = false) String user,
            @RequestParam(required = false) String password) {
    	if (user == null || password == null) {
    		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); 
    	}
    	Client client = userService.searchClient(user, password);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }
    
    

}




