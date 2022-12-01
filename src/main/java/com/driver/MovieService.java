package com.driver;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public void addMovie(Movie movie){
        movieRepository.addMovieList(movie);
    }
    public void addDirector(Director director){
        movieRepository.addDirectorList(director);
    }
    public void addDirectorMoviesPair(String movie,String director){
        movieRepository.addDirectorMoviePairList(movie,director);
    }
    public Movie findMovie(String movie){
        return movieRepository.findMovie(movie);
    }
    public Director findDirector(String director){
        return movieRepository.findDirector(director);
    }
    public List<String> getMoviesByDirector(String director){
        return movieRepository.findDirectorMovies(director);
    }
    public List<String> allMovies(){
       return movieRepository.MoviesList();
    }
    public void deleteDirector(String director){
        movieRepository.deleteDirector(director);
    }
    public void deleteAll(){
        movieRepository.deleteAllDirector();
    }
}
