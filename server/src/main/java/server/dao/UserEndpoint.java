package server.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import server.domain.User;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserEndpoint extends JdbcDaoSupport {

    private static final String GET_ALL_USERS = "select * from devdev.users";

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    private void init() {
        setDataSource(dataSource);
    }

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        users =  getJdbcTemplate().query(GET_ALL_USERS, new Object[]{}, new UserMapper());
        return users;
    }
}
