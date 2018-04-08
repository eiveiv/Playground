package server

import server.domain.Beer
import server.service.BeerService
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class BeerTest extends Specification{


    def beerService = Mock(BeerService)

    @Shared
    def beers = [ new Beer(2, "Frydenlund", "Fatøl", 4.5), new Beer(5, "Ringnes", "Pils", 5.3)] as List
    @Shared
    def beers2 = [ new Beer(2, "Ringnes", "Juleøl", 8.5), new Beer(5, "Frydenlund", "Juleøl", 6.3)] as List

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

    @Unroll
    def "Should return beer with highest alcohol percentage"() {

        expect:
        BeerService.getHighestPercentage(a).getAlcohol_percentage() == b

        where:
        a || b
        beers || 5.3
        beers2 || 8.5
    }

}

