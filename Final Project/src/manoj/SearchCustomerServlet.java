package manoj;


import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SearchCustomerServlet")
public class SearchCustomerServlet extends HttpServlet {

    public SearchCustomerServlet() {
        
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		
		AdduserDao adduserdao=new AdduserDao();
		ResultSet rs=adduserdao.searchBanker(username);
		HttpSession session=request.getSession(true);
		if(username!=""&&username!=null){
			try{
			while(rs.next()){
				request.setAttribute("userName",rs.getString("username"));
				request.setAttribute("firstName",rs.getString("firstname"));
				request.setAttribute("lastName",rs.getString("lastname"));
				request.setAttribute("dateofBirth",rs.getString("dateofbirth"));
				request.setAttribute("phoneNumber",rs.getString("phonenumber"));
				request.setAttribute("cityName",rs.getString("city"));
				request.setAttribute("userRole",rs.getString("userrole"));
				session.setAttribute("user",rs.getString("username"));
				request.getRequestDispatcher("/AddLoan.jsp").forward(request, response);
			}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		else{
			String err="invalid data!";
			request.setAttribute("errMessage",err );
			request.getRequestDispatcher("/CustomerSearch.jsp").forward(request, response);
		}
	}
}

