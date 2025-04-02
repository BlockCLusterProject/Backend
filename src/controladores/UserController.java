/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores.Backend;

import ApiServices.BackEnd.UserService;
import modelos.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/available_movies")
    public ResponseEntity<List<Movie>> getAvailableMovies(
            @RequestParam(required = false) Integer genre) {
    	if(genre == null) {
    		genre = 0;
    	}
        List<Movie> movies = userService.searchByFilters(genre);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

}




