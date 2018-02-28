package server;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.RequestPostProcessor;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import server.dao.BeerEndpoint;
import server.domain.AuthUser;
import server.domain.Beer;
import server.domain.User;
import server.rest.BeerRest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WithMockUser(username = "eivev")
@RunWith(SpringRunner.class)
@WebMvcTest(BeerRest.class)
public class BeerRestTest {

    @Autowired
    private WebApplicationContext context;

    @MockBean
    private BeerEndpoint beerEndpoint;

    @Autowired
    private MockMvc mockMvc;

//    @Before
//    public void setup() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
//    }


    @Test
    public void getBeers() throws Exception {
//        User user = new User();
//        user.setName("eiveiv");
//        user.setPassword("qwer1234");

        given(this.beerEndpoint.getBeers()).willReturn(getTestBeer());
        this.mockMvc.perform(get("/beers")
                .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk()).andExpect(content().string("somethingg"));
    }

    private List<Beer> getTestBeer() {
        List<Beer> beers = new ArrayList<>();
        Beer beer = new Beer();
        beer.setName("Pilsner");
        beer.setAlcoholPercentage(4.5);
        beer.setBrand("Ringnes");
        beers.add(beer);

        return beers;
    }


}
