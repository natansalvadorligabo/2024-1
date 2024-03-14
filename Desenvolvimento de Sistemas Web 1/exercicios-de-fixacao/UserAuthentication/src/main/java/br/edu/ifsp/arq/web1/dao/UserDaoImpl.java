package br.edu.ifsp.arq.web1.dao;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.arq.web1.model.User;

public class UserDaoImpl implements UserDao {
    private static UserDaoImpl instance;
    private List<User> dataset;

    private UserDaoImpl() {
        dataset = new ArrayList<>();
    }

    public static synchronized UserDaoImpl getInstance() {
        if (instance == null) {
            instance = new UserDaoImpl();
        }
        return instance;
    }

    @Override
    public boolean insert(User user) {
        return dataset.add(user);
    }

    @Override
    public boolean login(String email, String password) {
        for (User u : dataset) {
            if (email.equals(u.getEmail()) && password.equals(u.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
