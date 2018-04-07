package server.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import server.domain.Beer;
import server.service.BeerService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BeerRest {

    @Autowired
    private BeerEndpoint beerEndpoint;

    @GetMapping(path = "/beers")
    public ResponseEntity<List<Beer>> get() {
        final List<Beer> beers = beerEndpoint.getBeers();
        return new ResponseEntity<>(beers, HttpStatus.OK);
    }

    @PostMapping(path = "/beer", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void post(@Valid @RequestBody Beer beer) {
        System.out.println(beer.toString());
        beerEndpoint.addBeer(beer);
    }

    @GetMapping(path = "/beer/{id}")
    public ResponseEntity<Beer> get(@PathVariable Integer id) {
        final Beer beer = beerService.getBeer(id);
        return new ResponseEntity<>(beer, HttpStatus.OK);
    }


}
