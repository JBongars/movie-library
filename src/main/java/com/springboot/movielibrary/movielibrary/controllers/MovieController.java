package com.springboot.movielibrary.movielibrary.controllers;

import com.springboot.movielibrary.movielibrary.models.Movie;
import com.springboot.movielibrary.movielibrary.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
        return "Hello World";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listMovies(){
        return "list of movies";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Movie show(@PathVariable int id) {
        return new Movie("alice", "hp", "12","handsome");
    }



//    @RequestMapping(value = "movies", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Object> listMovies() {
//        return
//    }
}




