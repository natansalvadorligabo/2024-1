package br.edu.ifsp.arq.web1;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class AgeCalculatorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public AgeCalculatorServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
	        String birth = request.getParameter("birth");
	        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        LocalDate currentYear = LocalDate.now();
	        LocalDate birthYear = LocalDate.parse(birth, formatterDate);
	        
	        Period diff = Period.between(birthYear, currentYear);
	        int age = diff.getYears();
	        
	        if (currentYear.getYear() < birthYear.getYear()) throw new ServletException();

			response.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<html lang=\"pt-br\">");
			writer.println("<head>");
			writer.println("\t<title>" + age + " ano(s)</title>");
			writer.println("\t<meta charset=\"UTF-8\">");
			writer.println("\t<link rel=\"stylesheet\" href=\"style.css\">");
			writer.println("</head>");
			writer.println("<body>");
			writer.println("\t<div class=\"container\">");
			writer.println("\t\t<h1>Sua idade é: " + age + " ano(s)</h1><hr />");
			writer.println("\t\t<a href=\"index.html\">Voltar para a página inicial</a>");
			writer.println("\t</div>");
			writer.println("</body>");
			writer.println("</html>");
			writer.close();
		} catch (Throwable e) {
		 	  throw new ServletException();
		}
	}  
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}