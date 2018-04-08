package server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import server.dao.IBeerDao;
import server.domain.Beer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class BeerService {

    @Autowired
    private IBeerDao beerDao;

    @CacheEvict(value = "beers", allEntries = true)
    public void clearBeerCache() {
        System.out.println("Clearing cache");
    }


    public List<Beer> getBeers() {
        List<Beer> beers = new ArrayList<>();
        Iterable<Beer> all = beerDao.findAll();
        all.forEach(beers::add);
        return beers;
    }

    public Beer getBeer(String brand, String name) {
        return beerDao.findByBrandAndName(brand, name);
    }

    public Beer getBeer(Integer id) {
        return beerDao.findById(id);
    }

    public void addBeer(Beer beer) {
        beerDao.save(beer);
    }

    public static Beer getHighestPercentage (List<Beer> beers) {
        return beers.stream()
                .max(Comparator.comparing(Beer::getAlcohol_percentage))
                .get();
    }

}
