package test.example.TestApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import test.example.TestApp.exception.PokemonException;
import test.example.TestApp.model.PokemanResponse;
import test.example.TestApp.model.Result;

import java.util.List;

@Service
public class PokemanServiceImp implements PokemonService {

    @Autowired
    private RestTemplate restTemplate;


    @Value("${pokeman.url}")
    String pokemanEndPoint;

    @Override
    public List<Result> findAll() throws PokemonException {
       try{
           PokemanResponse pokemanResponse = restTemplate.getForObject(pokemanEndPoint.concat("pokemon/"), PokemanResponse.class);
           return pokemanResponse.getResults();
       }catch (Exception e){
           throw new PokemonException(e.getMessage());
       }


    }

    @Override
    public Object findDetails(String id) throws PokemonException{
        try{
         return restTemplate.getForObject(pokemanEndPoint.concat("pokemon/").concat(id), Object.class);
       }catch (Exception e){
        throw new PokemonException(e.getMessage());
    }
    }

    @Override
    public Object findByName(String name) throws PokemonException {
       try{
           return restTemplate.getForObject(pokemanEndPoint.concat("pokemon/").concat(name), Object.class);
       }catch (Exception e){
           throw new PokemonException(e.getMessage());
       }
    }


}
