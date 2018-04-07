package server

import server.domain.Beer
import server.service.BeerService
import spock.lang.Specification

class BeerTest2 extends Specification{


    def beerService = Mock(BeerService)

    def "Should get a beer based on id"() {

        given:

        beerService.getBeer(5) >> new Beer(5, "Aas", "Pils", 4.3)

        when:
        Beer result = beerService.getBeer(5)

        then:
        result.getBrand() == "Aas"
    }

    def "Should get a list of two beers"() {

        given:

        beerService.getBeers() >> [ new Beer(2, "Frydenlund", "Fatøl", 4.5), new Beer(5, "Ringnes", "Pils", 5.3)]

        when:
        List<Beer> result = beerService.getBeers()

        then:
        result.size() == 2
    }

}
