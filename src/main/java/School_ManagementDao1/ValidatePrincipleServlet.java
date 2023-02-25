package School_ManagementDao1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import School_ManagementDto.Principle;
@WebServlet("/login")
public class ValidatePrincipleServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Raj");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		Principle p= em.find(Principle.class, email);
		if(p!=null)
		{
			if(password.equals(p.getPass()))
			{
				RequestDispatcher rd=req.getRequestDispatcher("TeacherStudent.html");
				rd.forward(req, resp);
			}
			else
			{
				RequestDispatcher rd=req.getRequestDispatcher("Login.html");
				rd.forward(req, resp);
				PrintWriter pw=resp.getWriter();
				pw.write("invalid email");
			}
		}
		else
		{
			RequestDispatcher rd=req.getRequestDispatcher("Login.html");
			rd.forward(req, resp);
			PrintWriter pw=resp.getWriter();
			pw.write("invalid password");
		}
	}

}
