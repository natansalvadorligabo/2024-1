package br.edu.ifsp.arq.tsi.deoo.view;

import br.edu.ifsp.arq.tsi.deoo.dao.UserDao;
import br.edu.ifsp.arq.tsi.deoo.dao.UserDaoImpl;
import br.edu.ifsp.arq.tsi.deoo.model.User;

public class App {
    public static void main(String[] args) throws Exception {
        UserDao userDao = UserDaoImpl.getInstance();

        User natan = new User("natan", "natan@email.com", "natan123");
        User ednilson = new User("ednilson", "ednilson@email.com", "ednilson123");

        boolean addUserNatan = userDao.insertUser(natan);
        boolean addUserEdnilson = userDao.insertUser(ednilson);

        System.out.println("Insert Natan: " + (addUserNatan ? "OK" : "ERROR"));
        System.out.println("Insert Ednilson: " + (addUserEdnilson ? "OK" : "ERROR"));

        // recover password
        boolean recoverPasswordResult = userDao.recoverPassword("natan", "natan@email.com");
        System.out.println("Password recovery: " + (recoverPasswordResult ? "OK" : "ERROR"));

        // login
        boolean loginResult = userDao.login("ednilson", "ednilson123");
        System.out.println("Login: " + (loginResult ? "OK" : "ERROR"));

        // testing errors
        boolean recoverPasswordResultWrong = userDao.recoverPassword("edn", "natan@email.com");
        System.out.println("Password recovery wrong: " + (recoverPasswordResultWrong ? "OK" : "ERROR"));

        boolean loginResultWrong = userDao.login("ednilson", "natan123");
        System.out.println("Login wrong: " + (loginResultWrong ? "OK" : "ERROR"));
    }
}
