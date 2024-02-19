package br.edu.ifsp.arq.tsi.deoo.dao;

import java.util.List;

import br.edu.ifsp.arq.tsi.deoo.model.User;

public interface UserDao {
    List<User> getAllUsers();

    boolean insertUser(User user);

    boolean deleteUser(User user);

    boolean updateUser(User user);

    boolean login(String username, String password);

    boolean recoverPassword(String username, String email);

    User findByUsername(String username);
}
