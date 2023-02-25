<%@page import="School_ManagementDto.Teacher"%>
<%@page import="School_ManagementDto.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="javax.persistence.Persistence"%>
    <%@page import="javax.persistence.EntityManagerFactory"%>
    <%@page import="javax.persistence.EntityManager"%>
    <%@page import="java.io.PrintWriter"%>
   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     
    <%
	String id = request.getParameter("id");
	int id1= Integer.parseInt(id);
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Raj");
	EntityManager em = emf.createEntityManager();
	Teacher t=em.find(Teacher.class, id1);
	%>
  
	<form action="teacherupdate" method="post">
	Id:<input type="text" value="<%=t.getId()%>" name="id"><br><br>
	Name:<input type="text" value="<%=t.getName()%>" name="name"><br><br>
	Salary:<input type="text" value=<%=t.getSalary()%> name="salary"><br><br>
	<button type=submit>Update</button> 
	
	</form>
			
			
</body>
</html>
