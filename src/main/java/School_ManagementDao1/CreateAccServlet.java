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

import School_ManagementDto.Principle;
@WebServlet("/create")
public class CreateAccServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//getting data from createaccount page 
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		String age=req.getParameter("age");
		String contact=req.getParameter("contact");
		String email=req.getParameter("email");
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Raj");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Principle p=new Principle();
		p.setName(name);
		p.setPass(password);
		p.setAge(Integer.valueOf(age));
		p.setContact(Long.valueOf(contact));
		p.setEmail(email);
		
		et.begin();
		em.persist(p);
		et.commit();
		
		RequestDispatcher rd=req.getRequestDispatcher("Login.html");
		rd.forward(req, resp);
		resp.setContentType("text/html");
		
//		PrintWriter pw=resp.getWriter();
//		pw.write("invalid credential");
		
		
		
		
	}

}
