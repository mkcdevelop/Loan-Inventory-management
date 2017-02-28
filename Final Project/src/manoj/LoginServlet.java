package manoj;


import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    public LoginServlet() {
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName= request.getParameter("username");
		String passWord= request.getParameter("password");
		
		Loginbean loginbean = new Loginbean();
		loginbean.setUsername(userName);
		loginbean.setPassword(passWord);
		LoginDao logindao = new LoginDao();
		HttpSession session = request.getSession(true);
		
		String userValidate = logindao.loginAuthenticate(loginbean);
		
		if(userValidate.equals("ADMIN"))
		{
			request.setAttribute("userName",userName);
			request.getRequestDispatcher("/AdminHome.jsp").forward(request, response);
		}
		
		else if(userValidate.equals("BANKER"))
		{
			request.setAttribute("userName",userName);
			request.getRequestDispatcher("/BankerHome.jsp").forward(request, response);
		}
		
		else if(userValidate.equals("CUSTOMER"))
		{
			session.setAttribute("userName", userName);
			request.setAttribute("userName",userName);
			request.getRequestDispatcher("/CustomerHome.jsp").forward(request, response);
				
			}
		
		else 
		{
			request.setAttribute("errMessage", userValidate);
			request.getRequestDispatcher("/Login.jsp").forward(request,response);
		}
		}

}
