package server.dao;

import org.springframework.jdbc.core.RowMapper;
import server.domain.Beer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BeerMapper implements RowMapper {
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Beer beer = new Beer();
        beer.setName(resultSet.getString("name"));
        beer.setAlcoholPercentage(resultSet.getDouble("alchohol_percentage"));
        beer.setId(resultSet.getInt("id"));
        beer.setBrand(resultSet.getString("brand"));

        return beer;
    }
}