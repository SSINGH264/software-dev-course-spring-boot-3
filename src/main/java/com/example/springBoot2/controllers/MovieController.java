package com.example.springBoot2.controllers;

import com.example.springBoot2.models.Movie;
import com.example.springBoot2.repositories.MovieRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    // Method 1: Find all
    @GetMapping
    public List <Movie> getAllItems (){
        return movieRepository.findAll();
    }

    // Method 2: Get by id
    @GetMapping ("/{id}")
    public Movie getItem(@PathVariable int id) {
        return movieRepository.findById(id).orElse(null);
    }

    //Method 3: Add item

    @PostMapping
    public Movie addItem(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    // Method 4: updating item

    @PutMapping ("/{id}")
    public Movie updateItem(@PathVariable int id, @RequestBody Movie movie) {
        movie.setId(id);
        return movieRepository.save(movie);
    }

    // Method 5: deleting item
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable int id) {
        movieRepository.deleteById(id);
    }



}