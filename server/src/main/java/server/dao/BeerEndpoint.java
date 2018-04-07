package server.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import server.domain.Beer;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BeerEndpoint extends JdbcDaoSupport {

    private static final String GET_ALL_BEERS = "select * from devdev.beers";
    private static final String INSERT_BEER = "insert into devdev.beers(brand, name, alchohol_percentage) values(?,?,?)";
    private static final String DELETE_BEER = "delete from devdev.beers where id = ?";
    private static final String SELECT_BEER = "select * from devdev.beers where id = ?";

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    private void init() {
        setDataSource(dataSource);
    }

    @Cacheable("beers")
    public List<Beer> getBeers() {
        System.out.println("Getting beers from DB");
        List<Beer> beers = new ArrayList<>();
        beers = getJdbcTemplate().query(GET_ALL_BEERS, new Object[]{}, new BeerMapper());
        return beers;
    }

    public void addBeer(Beer beer) {
        getJdbcTemplate().update(INSERT_BEER, beer.getBrand(), beer.getName(), beer.getAlcoholPercentage());
    }

    public void deleteBeer(int beerId) {
        getJdbcTemplate().update(DELETE_BEER, beerId);
    }

    public Beer getBeer(int beerId) {
        return (Beer) getJdbcTemplate().queryForObject(SELECT_BEER, new Object[]{beerId}, new BeerMapper());
    }
}

