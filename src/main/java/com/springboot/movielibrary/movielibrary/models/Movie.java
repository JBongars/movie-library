package com.springboot.movielibrary.movielibrary.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.annotation.Id;

import java.io.IOException;

//@Entity
public class Movie {

    @Id
//    @GeneratedValue(generator = "uuid2")
//    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private long id;
    private String title;
    private String director;
    private String releaseDate;
    private String type;

    public Movie(){ }

    public Movie(String jsonData) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.readValue(jsonData, this.getClass());
    }

    public Movie(String title, String director, String releaseDate, String type){
        this.title = title;
        this.director = director;
        this.releaseDate = releaseDate;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString(){
        return  "\n=========================================================" +
                "\nMovie Class" +
                "\n=========================================================" +
                "\nTitle = " + getTitle() +
                "\nDirector = " + getDirector() +
                "\nReleaseDate = " + getReleaseDate() +
                "\nType = " + getType() +
                "\n\n=========================================================\n\n";
    }
}