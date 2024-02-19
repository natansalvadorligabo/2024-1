package br.edu.ifsp.arq.tsi.deoo.dao;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.arq.tsi.deoo.model.User;

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
    public boolean insertUser(User user) {
        if (validateUniqueUser(user)) {
            user.setUserId(dataset.size() + 1);
            if (dataset.add(user)) {
                return true;
            }
        }
        return false;
    }

    private boolean validateUniqueUser(User user) {
        for (User u : dataset) {
            if (u.getUsername().equals(user.getUsername()) || u.getEmail().equals(user.getEmail())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean deleteUser(User user) {
        if (dataset.remove(user)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        int index = dataset.indexOf(user);
        if (index != -1) {
            dataset.set(index, user);
            return true;
        }
        return false;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public boolean login(String username, String password) {
        if (validateLogin(username, password)) {
            return true;
        }
        return false;
    }

    private boolean validateLogin(String username, String password) {
        for (User u : dataset) {
            if (username.equals(u.getUsername()) && password.equals(u.getPassword())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean recoverPassword(String username, String email) {
        if (validateRecoverPassword(username, email)) {
            return true;
        }
        return false;
    }

    private boolean validateRecoverPassword(String username, String email) {
        for (User u : dataset) {
            if (username.equals(u.getUsername()) && email.equals(u.getEmail())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public User findByUsername(String username) {
        for (User u : dataset){
            if(u.getUsername().equals(username)){
                return u;
            }
        }
        return null;
    }
}
