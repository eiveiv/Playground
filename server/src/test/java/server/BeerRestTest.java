package server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import server.domain.Beer;
import server.rest.BeersRest;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BeerRestTest {


    @Autowired
    private BeersRest beerRest;

    @Test
    public void getBeers() throws Exception {
        ResponseEntity<List<Beer>> listResponseEntity = beerRest.get();
        System.out.println(listResponseEntity);
    }

}
