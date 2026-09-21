package com.example.springBoot2.controllers;

import com.example.springBoot2.models.Album;
import com.example.springBoot2.repositories.AlbumRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {
    private final AlbumRepository albumRepository;

    public AlbumController(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    // Method 1: Find all
    @GetMapping
    public List <Album> getAllItems (){
        return albumRepository.findAll();
    }

    // Method 2: Get by id
    @GetMapping ("/{id}")
    public Album getItem(@PathVariable int id) {
        return albumRepository.findById(id).orElse(null);
    }

    //Method 3: Add item

    @PostMapping
    public Album addItem(@RequestBody Album album) {
        return albumRepository.save(album);
    }

    // Method 4: updating item

    @PutMapping ("/{id}")
    public Album updateItem(@PathVariable int id, @RequestBody Album album) {
        album.setId(id);
        return albumRepository.save(album);
    }

    // Method 5: deleting item
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable int id) {
        albumRepository.deleteById(id);
    }
}