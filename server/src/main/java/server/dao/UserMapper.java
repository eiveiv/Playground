package server.dao;

import org.springframework.jdbc.core.RowMapper;
import server.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper {
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));

        return user;
    }
}