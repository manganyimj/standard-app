package za.co.standardbankapp.service;

import za.co.standardbankapp.exception.PokemonException;
import za.co.standardbankapp.model.Result;

import java.util.List;

public interface PokemonService {

     List<Result> findAll() throws PokemonException;
     Object findDetails(String id) throws PokemonException;
     Object findByName(String name) throws PokemonException;
}
