package br.edu.ifsp.arq.web1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/enroll")
public class StudentCoursesServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public StudentCoursesServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
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
		writer.println("\t<title>Olá, " + name + "</title>");
		writer.println("\t<meta charset=\"UTF-8\">");
		writer.println("\t<link rel=\"stylesheet\" href=\"styles.css\">");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("\t<h1>Seja bem-vindo(a), "+ name + "!</h1><br>");
		writer.println("\t<h2>Nome: " + name + "</h2>");
		writer.println("\t<h2>E-mail: " + email + "</h2>");
		writer.println("\t<h2>Cursos de extensão escolhido: " + selectedOptions + "</h2>");
		writer.println("</body>");
		writer.println("</html>");
		writer.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}