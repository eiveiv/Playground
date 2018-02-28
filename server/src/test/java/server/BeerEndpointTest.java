package server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import server.dao.BeerEndpoint;
import server.domain.Beer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BeerEndpointTest {

    @Autowired
    private BeerEndpoint beerEndpoint;

    @Test
    public void deleteBeer() {
        beerEndpoint.deleteBeer(5);
    }

    @Test
    public void addBeer() {
        Beer beer = new Beer();
        beer.setBrand("Hansa");
        beer.setAlcoholPercentage(4.5);
        beer.setName("Pilsner");
        beerEndpoint.addBeer(beer);
    }
}
