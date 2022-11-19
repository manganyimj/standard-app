package test.example.TestApp.service;

import test.example.TestApp.exception.PokemonException;
import test.example.TestApp.model.Result;

import java.util.List;

public interface PokemonService {

     List<Result> findAll() throws PokemonException;
     Object findDetails(String id) throws PokemonException;
     Object findByName(String name) throws PokemonException;
}
