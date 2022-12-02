package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("movie")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody(required = true) Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>("New movie added successfully", HttpStatus.CREATED);
    }
    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody(required = true) Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("New director added successfully", HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movie ,@RequestParam String director){
        movieService.addDirectorMoviesPair(movie,director);
        return new ResponseEntity<>("New movie-director-pair added successfully",HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{movie}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String movie){
        return new ResponseEntity<>(movieService.findMovie(movie),HttpStatus.CREATED);
    }
    @GetMapping("/get-director-by-name/{director}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String director){
        return new ResponseEntity<>(movieService.findDirector(director),HttpStatus.CREATED);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> movies = new ArrayList<>();
        movies = movieService.allMovies();
        return new ResponseEntity<>(movies,HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String director){
        movieService.deleteDirector(director);
        return new ResponseEntity<>(director + "remove Successfully",HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        movieService.deleteAll();
        return new ResponseEntity<>("All directors deleted Successfully",HttpStatus.CREATED);
    }
}
