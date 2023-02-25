package School_ManagementDao1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import School_ManagementDto.Student;
import School_ManagementDto.Teacher;
@WebServlet("/deleteteacher")
public class DeleteTeacherServlet extends HttpServlet
{
protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
	String id1=req.getParameter("id");
	int id=Integer.parseInt(id1);
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Raj");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	Teacher t=em.find(Teacher.class,id);
	
	if(t!=null)
	{
	et.begin();
	em.remove(t);
	et.commit();
	
	PrintWriter pw=res.getWriter();
	pw.write("Removed successfully");
	RequestDispatcher rd=req.getRequestDispatcher("ViewTeacher.jsp");
	rd.include(req,res);
	res.setContentType("text/html");
	}
	else
	{
		PrintWriter pw=res.getWriter();
		pw.write("Id not found");
		RequestDispatcher rd=req.getRequestDispatcher("Teacher.html");
		rd.include(req,res);
		res.setContentType("text/html");
		
	}
	
	
}
}
