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
@WebServlet("/teacherupdate")
public class UpdateTeacherServlet extends HttpServlet
{
	@Override
protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("Raj");
    EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
		
    	
	String id1=req.getParameter("id");
	int id=Integer.parseInt(id1);
	String name=req.getParameter("name");
	String salary=req.getParameter("salary");
	double salary1=Double.parseDouble(salary);
	
	
	Teacher t=new Teacher();
	t.setId(id);
	t.setName(name);
	t.setSalary(salary1);
	
    et.begin();
    em.merge(t);
    et.commit();
    
    PrintWriter pw=res.getWriter();
    pw.write("Successfully Updated");
    
    RequestDispatcher rd=req.getRequestDispatcher("Teacher.html");
    rd.include(req,res);
    res.setContentType("text/html");
    
    
}
}

