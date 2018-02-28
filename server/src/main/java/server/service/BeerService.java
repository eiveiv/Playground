package server.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@Service
public class BeerService {

    @CacheEvict(value = "beers", allEntries = true)
    public void clearBeerCache() {
        System.out.println("Clearing cache");
    }
}
