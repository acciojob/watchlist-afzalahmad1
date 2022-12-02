package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class MovieRepository {
    private HashMap<String,Movie> movieMap;
    private HashMap<String,Director> directorMap;
    private HashMap<String, List<String>> directorMoviePair;
    public MovieRepository(){
        this.movieMap=new HashMap<>();
        this.directorMap=new HashMap<>();
        this.directorMoviePair=new HashMap<>();
    }
    public void addMovieList(Movie movie){
        movieMap.put(movie.getName(),movie);
    }
    public void addDirectorList(Director director){
        directorMap.put(director.getName(),director);
    }
    public void addDirectorMoviePairList(String movie,String director){
        List<String> currMovies = new ArrayList<>();
        if(directorMoviePair.containsKey(director)){
            currMovies = directorMoviePair.get(director);
        }
        currMovies.add(movie);
        directorMoviePair.put(director,currMovies);
    }
    public Movie findMovie(String movie){
        return movieMap.get(movie);
    }
    public Director findDirector(String director){
        return directorMap.get(director);
    }
    public List<String> findDirectorMovies(String director){
        List<String> movies=new ArrayList<>();
        if(directorMoviePair.containsKey(director)){
            movies =  directorMoviePair.get(director);
        }
        return movies;
    }
    public List<String> MoviesList(){
        List<String> list=new ArrayList<>();
        for(String movie : movieMap.keySet()){
            list.add(movie);
        }
        return list;
    }
    public void deleteDirector(String director){
        List<String> movies=new ArrayList<>();
        if(directorMoviePair.containsKey(director)){
            movies = directorMoviePair.get(director);
            for(String movie : movies){
                if(movieMap.containsKey(movie)) {
                    movieMap.remove(movie);
                }
            }
            directorMoviePair.remove(director);
        }
        if(directorMap.containsKey(director)) {
            directorMap.remove(director);
        }
    }
    public void deleteAllDirector(){
        HashSet<String> movies=new HashSet<>();
        for(String director : directorMoviePair.keySet()){
            for(String movie : directorMoviePair.get(director)){
                movies.add(movie);
            }
        }
        for(String movie : movies){
            if(movieMap.containsKey(movie)){
                movieMap.remove(movie);
            }
        }
    }

}
