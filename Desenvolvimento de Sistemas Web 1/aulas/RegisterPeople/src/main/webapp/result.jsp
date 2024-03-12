<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="java.util.List, br.edu.ifsp.arq.web1.model.Person" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Pessoas</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<% List<Person> persons = (List<Person>) request.getAttribute("list"); %>
	<table>
		<tr>
			<th>Nome</th>
			<th>CPF</th>
			<th>E-mail</th>
		</tr>
		<% for(Person person: persons) { %>
		<tr>
			<td><%= person.getName() %></td>
			<td><%= person.getCpf() %></td>
			<td><%= person.getEmail() %></td>
		</tr>
		<% } %>
	</table>
</body>
</html>