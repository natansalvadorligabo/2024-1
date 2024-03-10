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
		String emails = request.getParameter("emails");
		String[] options = request.getParameterValues("options");
		String selectedOptions = "";
		for(String opt : options) {
			selectedOptions += opt + " ";
		}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.println("<html lang=\"pt-br\">");
		writer.println("<head>");
		writer.println("\t<meta charset=\"UTF-8\">");
		writer.println("\t<title>Matrícula Realizada</title>");
		writer.println("\t<link rel=\"stylesheet\" href=\"style.css\">");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("\t<div class=\"container\">");
		writer.println("\t\t<h1>Matrícula Realizada com Sucesso!</h1><hr />");
		writer.println("\t\t<p>Olá, <b>" + name + "</b>! </p>");
		writer.println("\t\t<p>Sua matrícula nos cursos de extensão foi realizada com sucesso. Vamos te manter informado(a) por e-mail\n"
						+ "(<b>" + emails + "</b>) sobre o início das aulas e demais informações importantes.</p>");
		writer.println("\t\t<h2>Cursos selecionados: " + selectedOptions + "</h2>");
		writer.println("\t\t<p>Agradecemos a sua inscrição! Esperamos te ver em breve.</p>");
		writer.println("\t</div>");
		writer.println("</body>");
		writer.println("</html>");
		writer.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}