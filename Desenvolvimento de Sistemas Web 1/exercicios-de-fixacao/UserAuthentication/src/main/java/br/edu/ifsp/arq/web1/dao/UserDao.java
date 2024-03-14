package br.edu.ifsp.arq.web1.dao;

import br.edu.ifsp.arq.web1.model.User;

public interface UserDao {
	public boolean insert(User user);
	
	boolean login(String email, String password);
}
