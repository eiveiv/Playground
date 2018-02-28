package server.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import server.service.BeerService;

@RestController
public class ClearCacheRest {

    @Autowired
    private BeerService beerService;

    @GetMapping(path = "/clearcache")
    public void clearCache() {
        beerService.clearBeerCache();
    }
}
