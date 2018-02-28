package server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import server.dao.UserEndpoint;
import server.domain.AuthUser;
import server.domain.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserEndpoint userEndpoint;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> users = userEndpoint.getUsers();
        Optional<User> user = users.stream().findFirst().filter(u -> u.getName().equals(username));
        if (user.isPresent()) {
            return new AuthUser(user.get());
        } else {
            throw new UsernameNotFoundException(username);
        }
    }
}
