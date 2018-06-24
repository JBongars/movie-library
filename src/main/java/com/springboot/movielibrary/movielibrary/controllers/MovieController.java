package com.springboot.movielibrary.movielibrary.controllers;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import com.springboot.movielibrary.movielibrary.models.Movie;
import com.springboot.movielibrary.movielibrary.models.MovieCollection;
import com.springboot.movielibrary.movielibrary.services.MovieMapperService;

import java.util.List;

@ComponentScan
@RestController
@RequestMapping("api/movies")
public class MovieController extends RootController{

//    Autowired
//    private MovieMapperService movies;
    private MovieMapperService movies = new MovieMapperService();

//    public static void main(String[] args){
//        try {
//            this.movies = new MovieMapperService("movies.json");
//        } catch(IOException e){
//            e.printStackTrace();
//        }
//    }

    @GetMapping(value = "/test")
    public String test(){
        return "Hello World";
    }

    @GetMapping(value = "/list")
    public @ResponseBody List<Movie> listMovies(){
        List<Movie> response = movies.getCollection();
        System.out.println(response.toString());
        return response;
    }

    @PostMapping(name="/")
    public @ResponseBody List<Movie> createMovie(@RequestBody Movie req_item){
        movies.add(req_item);
        return movies.getCollection();
    }

    @PutMapping(value = "/")
    public String updateMovies(@RequestBody List<Movie> req_items){
        movies.updateAll(req_items);
        return "true";
    }

    @PostMapping(value = "/update")
    public String updateMoviesFallback(@RequestBody List<Movie> req_items){
        movies.updateAll(req_items);
        return "true";
    }

    @DeleteMapping(value = "/{id}")
    public String deleteMovie(@PathVariable("id") long req_id){
        boolean status = movies.deleteById(req_id);
        if(status) return "true";
        else return "false";
    }

//    @RequestMapping(value = "/", method = RequestMethod.POST)
//    public void createMovies(@ResponseBody String payload) throws IOException {
//        Movie post = new Movie(payload);
//        movies.add(post);
//    }

}




