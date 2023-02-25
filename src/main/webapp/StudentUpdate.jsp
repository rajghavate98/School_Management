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
	Student s=em.find(Student.class, id1);
	%>
  
	<form action="studentupdate" method="post">
	Id:<input type="text" value="<%=s.getId()%>" name="id"><br><br>
	Name:<input type="text" value="<%=s.getName()%>" name="name"><br><br>
	Stream:<input type="text" value=<%=s.getStream()%> name="stream"><br><br>
	Fees:<input type="text" value="<%=s.getFees()%>" name="fees">
	<button type=submit>Update</button> 
	
	</form>
			
			
</body>
</html>
