/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import ApiServices.UserService;
import Models.Person;
import Models.Movie;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Base64;
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
    
    @Operation(summary = "Obtener un usuario a partir de su usuario",
    		description = "Devuelve una persona si es encontrado, sino, devuelve un null")
    @ApiResponses(value = {
    		@ApiResponse(responseCode = "200", description = "Lista de productos obtenidas con �xito"),
    		@ApiResponse(responseCode = "404", description = "Películas no disponibles"),
    		@ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/{user}")
    public ResponseEntity<Person> getClientByUser(@RequestParam(required = true) String user) {
    	Person client = userService.getClientByUser(user);
    	if(client != null) {
    		return new ResponseEntity<>(client, HttpStatus.OK);
    	} else {
    		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    	}
    }
    
    @Operation(summary = "Obtener las películas compradas por un usuario",
    		description = "Devuelve una lista de películas compradas por un usuario")
    @ApiResponses(value = {
    		@ApiResponse(responseCode = "200", description = "Lista de productos obtenidas con �xito"),
    		@ApiResponse(responseCode = "404", description = "Películas no disponibles"),
    		@ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/purchase_history")
    public ResponseEntity<List<Movie>> getPurchaseHistory() {
    	List<Movie> movies = userService.getPurchaseHistory();
    	if(movies != null) {
			return new ResponseEntity<>(movies, HttpStatus.OK);
    	} else {
    		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    	}
    }

    @Operation(summary = "Obtener las películas disponibles", description = "Devuelve una lista con todas las películas disponibles en la base de datos local")
    @ApiResponses(value = {
    		@ApiResponse(responseCode = "200", description = "Lista de productos obtenidas con �xito"),
    		@ApiResponse(responseCode = "404", description = "Películas no disponibles"),
    		@ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/available_movies")
    public ResponseEntity<List<Movie>> getAvailableMovies(
            @RequestParam(required = false) Integer genre) {
    	if(genre == null) {
    		genre = 0;
    	}
        List<Movie> movies = userService.searchByFilters(genre);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/prueba_get")
    public ResponseEntity<List<Person>> getClients() {
    	List<Person> clients = userService.getClients();
    	return new ResponseEntity<>(clients, HttpStatus.OK);
    }
    
    @PostMapping("/addUser")
    @Operation(summary = "Agrega un nuevo usuario a la base de datos", description = "Devuelve un boolean")
    @ApiResponses(value = {
    		@ApiResponse(responseCode = "200", description = "Agregado con exito"),
    		@ApiResponse(responseCode = "204", description = "Admin no encontrado"),
    		@ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<Person> registerClient(@RequestBody Person user) {
    boolean newUser = userService.registerClient(user);
    return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    
    

    @GetMapping("/validateUser")
    @Operation(
		summary = "Validar existencia de usuario", 
		description = "Devuelve una clase Person si existe el usuario en la base de datos")
    @ApiResponses(value = {
    		@ApiResponse(responseCode = "200", description = "Client obtenido con exito"),
    		@ApiResponse(responseCode = "404", description = "Client no encontrado"),
    		@ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    
    public ResponseEntity<Person> validateUser(
            @RequestParam(required = false) String user,
            @RequestParam(required = false) String password) {
    	if (user == null || password == null) {
    		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); 
    	}
    	Person client = userService.validateUser(user, password);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }
    
    @GetMapping(value="/generate-qr")
    @Operation(summary="Obtener el c�digo QR de la factura", description = "Devuele el c�digo QR de la factura")
    @ApiResponses(value = {
    		@ApiResponse(responseCode = "200", description = "C�digo generado correctamente"),
    		@ApiResponse(responseCode = "400", description = "Error al hacer la petici�n"),
    		@ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<String> generateQr(
    		@RequestParam String message) {
    	if (message == null) {
    		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    	}
    	byte[] image = userService.generateQr(message);
    	String base64 = Base64.getEncoder().encodeToString(image);
    	return new ResponseEntity<>(base64, HttpStatus.OK);
    }
    

}




