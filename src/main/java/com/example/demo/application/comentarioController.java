package com.example.demo.application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.services.comicService;

@RestController
@CrossOrigin
@RequestMapping("/comentario")
public class comentarioController {
    @Autowired
    private comicService comicService;

    @Secured({"ADMIN", "USER"})
    @PostMapping("/like_comentario/{comentarioId}")
    public ResponseEntity<String> DarLikeComentario(@PathVariable Long comentarioId){
        comicService.ActualizarLikesComentario(comentarioId);
        return new ResponseEntity<>( "like!", HttpStatus.OK);
    }

    @Secured({"ADMIN", "USER"})
    @PostMapping("/dislike_comentario/{comentarioId}")
    public ResponseEntity<String> DarDisLikeComentario(@PathVariable Long comentarioId){
        comicService.ActualizarDisLikesComentario(comentarioId);
        return new ResponseEntity<>( "dislike", HttpStatus.OK);
    }

    @Secured({"ADMIN", "USER"})
    @PostMapping("/like_comic")
    public ResponseEntity<String> DarLikeComic(@PathVariable Long comicId){
        comicService.ActializarLikesComic(comicId);
        return new ResponseEntity<>( "like!", HttpStatus.OK);
    }

    @Secured({"ADMIN", "USER"})
    @PostMapping("/dislike_comic")
    public ResponseEntity<String> DarDisLikeComic(@PathVariable Long comicId){
        comicService.ActializarDisLikesComic(comicId);
        return new ResponseEntity<>( "like!", HttpStatus.OK);
    }

    @Secured({"ADMIN", "USER"})
    @GetMapping("/get")
    public ResponseEntity<String> da(){
        return new ResponseEntity<>( "like!", HttpStatus.OK);
    }
}
