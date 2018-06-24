package com.springboot.movielibrary.movielibrary.models;

import org.springframework.data.annotation.Id;

//@Entity
public class Movie {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long id;
    private String title;
    private String director;
    private String releaseDate;
    private String type;

    public Movie(String title, String director, String releaseDate, String type){
        this.title = title;
        this.director = director;
        this.releaseDate = releaseDate;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString(){
        return getTitle() + ", " + getDirector() + ", " + getReleaseDate() + ", " + getType();
    }
}