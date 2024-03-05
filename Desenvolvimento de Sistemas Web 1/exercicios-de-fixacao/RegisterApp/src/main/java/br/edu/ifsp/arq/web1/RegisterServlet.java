package br.edu.ifsp.arq.web1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String fullName = request.getParameter("name");
		String email = request.getParameter("email");
		String[] options = request.getParameterValues("options");
		String selectedOptions = "";
		for(String opt : options) {
			selectedOptions += opt + " ";
		}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.println("<html lang=\"pt-br\">");
		writer.println("<head>");
		writer.println("\t<title>Thank you =D</title>");
		writer.println("\t<meta charset=\"UTF-8\">");
		writer.println("\t<link rel=\"stylesheet\" href=\"styles.css\">");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("\t<h1>Thanks, "+ fullName + "! You're now part of our newsletter!</h1><br>");
		writer.println("\t<h2>Name: " + fullName + "</h2>");
		writer.println("\t<h2>E-mail: " + email + "</h2>");
		writer.println("\t<h2>Preferences: " + selectedOptions + "</h2>");
		writer.println("</body>");
		writer.println("</html>");
		writer.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	
	
	
	
	
	

}