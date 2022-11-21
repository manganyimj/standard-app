package za.co.standardbankapp.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import za.co.standardbankapp.exception.PokemonException;
import za.co.standardbankapp.model.Result;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PokemanServiceImpTest {

    @Autowired
    private PokemonService pokemonService;

    @Test
    void givenThatFindAllIsCalled_shouldReturnAllPokeman() throws PokemonException {

       List<Result> results = pokemonService.findAll();
        assertNotEquals(0,results.size());
    }

    @Test
    void givenValidPokemanId_shouldReturnPokemanDetails() throws PokemonException {
        var result = pokemonService.findDetails("1");
        assertNotEquals(null,result);
    }

    @Test
    void givenValidPokemanName_shouldReturnPokemanDetails() throws PokemonException {
        var result = pokemonService.findByName("bulbasaur");
        assertNotEquals(null,result);
    }
}
