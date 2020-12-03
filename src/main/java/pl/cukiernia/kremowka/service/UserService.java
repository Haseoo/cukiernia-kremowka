package pl.cukiernia.kremowka.service;

import javax.ejb.Stateless;
import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

@Named
@Stateless
public class UserService implements IUserService {
    private Map<String, String> users;

    public UserService() {
        users = new HashMap<>();
        users.put("admin", "admin");
        users.put("user", "user");
    }

    @Override
    public boolean checkUser(String login) {
        return users.containsKey(login);
    }

    @Override
    public boolean verifyUser(String login, String secret) {
        var user = users.get(login);
        return user != null && user.equals(secret);
    }
}
