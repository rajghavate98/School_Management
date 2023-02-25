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
@WebServlet("/adds")
public class AddStudentServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String fees=req.getParameter("fees");
		String stream=req.getParameter("stream");
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Raj");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Student s=new Student();
		s.setId(Integer.valueOf(id));
		s.setName(name);
		s.setFees(Double.valueOf(fees));
		s.setStream(stream);
		
		et.begin();
		em.persist(s);
		et.commit();
		
		RequestDispatcher rd =req.getRequestDispatcher("Student.html");
		rd.forward(req, resp);
		PrintWriter pw=resp.getWriter();
		pw.write("stduent added succefully");
		resp.setContentType("text/html");
		
		
	}
}
