package com.springboot.movielibrary.movielibrary.services;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.springboot.movielibrary.movielibrary.models.MovieCollection;
import com.springboot.movielibrary.movielibrary.models.Movie;
//import com.springboot.movielibrary.movielibrary.constants.*;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


public class MovieMapperService extends MovieCollection {

    public MovieMapperService(){ }

//    ===================================================
//    READ FROM JSON FILE = DOES NOT WORK
//    ===================================================
//    public void main(String[] arg) throws IOException {
//
//        //read json file data to String
//        byte[] jsonData = Files.readAllBytes(Paths.get("movies.json"));
//
//        //create ObjectMapper instance
//        ObjectMapper mapper = new ObjectMapper();
//
//        //convert json string to object
//        List<Movie> movies = mapper.readValue(jsonData, new TypeReference<List<Movie>>() {});
//
//        System.out.println("Movie Object\n" + movies);
//
//        this.collection = movies;
//    }
//    ===================================================
}