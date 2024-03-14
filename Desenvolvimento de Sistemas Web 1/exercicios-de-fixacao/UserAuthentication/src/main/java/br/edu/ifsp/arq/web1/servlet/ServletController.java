package br.edu.ifsp.arq.web1.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsp.arq.web1.dao.UserDaoImpl;
import br.edu.ifsp.arq.web1.model.User;

@WebServlet("/login")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            
            UserDaoImpl dao = UserDaoImpl.getInstance();
            
            User admin = new User("Admin", "admin@email.com", "password");
            dao.insert(admin);
            
            if (dao.login(email, password)) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
                dispatcher.forward(request, response);
            } else {
            	throw new ServletException();
            }
        } catch (Throwable e) {
            throw new ServletException();
        }
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
