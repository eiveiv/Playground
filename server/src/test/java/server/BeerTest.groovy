package server

import server.dao.BeerEndpoint
import server.domain.Beer
import spock.lang.Specification

class BeerTest extends Specification {

    def beerEndpont = Mock(BeerEndpoint)

    def "Should get a beer based on id"() {

        given:

        beerEndpont.getBeer(5) >> new Beer(5, "Ringnes", "Pils", 4.3)

        when:
        Beer result = beerEndpont.getBeer(5)

        then:
        result.getBrand() == "Ringnes"
    }

    def "Should get a list of two beers"() {

        given:

        beerEndpont.getBeers() >> [ new Beer(2, "Frydenlund", "Fatøl", 4.5), new Beer(5, "Ringnes", "Pils", 5.3)]

        when:
        List<Beer> result = beerEndpont.getBeers()

        then:
        result.size() == 2
    }



}