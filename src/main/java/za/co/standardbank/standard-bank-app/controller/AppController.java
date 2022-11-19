package test.example.TestApp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import test.example.TestApp.exception.PokemonException;
import test.example.TestApp.service.PokemonService;

@RestController
@RequestMapping("/api/pokemon/v1")
@Slf4j
public class AppController {

    @Autowired
    private PokemonService pokemonService;

    @GetMapping("/get-pokeman-list")
    public ResponseEntity getPokemanList() {
        log.info("invoking getPokemanList");

        try {

            return  new ResponseEntity(pokemonService.findAll(), HttpStatus.OK) ;

        } catch (PokemonException e) {
            log.error("exception on get list of pockman");
            return  new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/get-pokemon/{id}")
    public ResponseEntity getPokemanDetails(@RequestParam String id) {
        log.info("invoking getPokemanDetails");

        try {

            return  new ResponseEntity(pokemonService.findDetails(id), HttpStatus.OK) ;

        } catch (PokemonException e) {
            log.error("Exception on findDetails");
            return  new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-pokeman-by-name/{name}")
    public ResponseEntity getPokemanByName(@RequestParam String name) {
        log.info("invoking getPokemanByName");
        try {

            return  new ResponseEntity(pokemonService.findByName(name), HttpStatus.OK) ;

        } catch (PokemonException e) {
            log.error("exception on find by name");
            return  new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
