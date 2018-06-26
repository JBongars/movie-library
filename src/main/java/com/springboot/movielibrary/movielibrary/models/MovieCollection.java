package com.springboot.movielibrary.movielibrary.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.util.*;

public class MovieCollection {

//    ==================================================
//    Manually add entries as cannot import from JSON
//    ==================================================
//    protected static List<Movie> collection;
//
//    public MovieCollection(List<Movie> collection){
//        this.collection = collection;
//    }
//    ==================================================

    public MovieCollection(){ }

    protected static List<Movie> collection = new ArrayList<>(Arrays.asList(
        new Movie("Ocean's 8", "Gary Ross", "13/06/2018", "action"),
        new Movie("Solo: A Star Wars Story", "Ron Howard", "23/05/2018", "Sci-Fi"),
        new Movie("Deadpool 2", "David Leitch", "16/05/2018", "Comedy"),
        new Movie("Avengers: Infinite War", "Anthony Russo, Joe Russo", "25/04/2018", "action"),
        new Movie("The First Purge", "Gerard McMurray", "04/07/2018", "Horror"),
        new Movie("Mission Impossible - Fallout", "Christopher McQuarrie", "01/08/2018", "Thriller"),
        new Movie("The Mummy", "Christopher McQuarrie", "14/06/2017", "Fantasy"),
        new Movie("Hunger Games", "Gary Ross", "21/03/2012", "Thriller"),
        new Movie("John Wick", "David Leitch", "29/10/2014", "Thriller")
    ));

    public List<Movie> getCollection() {
        return this.collection;
    }

    public List<Movie> add(Movie newMovie){
        this.collection.add(newMovie);
        return this.collection;
    }

    public Boolean updateById(Movie newMovie){
        long req_id = newMovie.getId();
        boolean itemFound = false;
        for (ListIterator<Movie> iter = this.collection.listIterator(); iter.hasNext(); ){
            long item_id = iter.next().getId();
            if(!itemFound && item_id == req_id){
                itemFound = true;
                iter.set(newMovie);
            }
        }
        return itemFound;
    }

    public void updateAll(String data) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Movie> newMovies = mapper.readValue(data, new TypeReference<Collection<Movie>>(){ });
        System.out.println(newMovies);
        this.collection = newMovies;
    }

    public Boolean deleteById(long req_id){
        boolean itemFound = false;
        for (ListIterator<Movie> iter = this.collection.listIterator(); iter.hasNext(); ){
            long item_id = iter.next().getId();
            if(!itemFound && item_id == req_id){
                itemFound = true;
                iter.remove();
            }
        }
        return itemFound;
    }

    public String test(){
        return "testing...";
    }

    @Override
    public String toString() {
        return collection.size() + " movies loaded...";
    }
}
