package server.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import server.domain.Beer;
import server.service.BeerService;

import java.util.List;

@RestController
public class BeersRest {

    @Autowired
    private BeerService beerService;

    @GetMapping(path = "/beers")
    public ResponseEntity<List<Beer>> get() {
        final List<Beer> beers = beerService.getBeers();
        return new ResponseEntity<>(beers, HttpStatus.OK);
    }
}
