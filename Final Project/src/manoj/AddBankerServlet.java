package manoj;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/AddBankerServlet")
public class AddBankerServlet extends HttpServlet {
    public AddBankerServlet() {
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String dateofbirth=request.getParameter("dateofbirth");
		String phonenumber=request.getParameter("phonenumber");
		String city=request.getParameter("city");
		String password=request.getParameter("password");
		String userrole="BANKER";
		
		Loginbean loginbean=new Loginbean();
		loginbean.setUsername(username);
		loginbean.setFirstname(firstname);
		loginbean.setLastname(lastname);
		loginbean.setDateofbirth(dateofbirth);
		loginbean.setPhonenumber(phonenumber);
		loginbean.setCity(city);
		loginbean.setPassword(password);
		loginbean.setUserrole(userrole);
		
		AdduserDao adduserdao=new AdduserDao();
		Boolean useradded=adduserdao.addUser(loginbean);
		HttpSession session=request.getSession(false);
			if(session!=null){
			if (useradded==true){
				request.setAttribute("userName",username);
				request.setAttribute("firstName",firstname);
				request.setAttribute("lastName",lastname);
				request.setAttribute("dateofBirth",dateofbirth);
				request.setAttribute("phoneNumber",phonenumber);
				request.setAttribute("cityName",city);
				request.setAttribute("userRole",userrole);
				request.getRequestDispatcher("/AddBankerSuccess.jsp").forward(request, response);
			}
			else{
				String err="Invalid Data!!";
				request.setAttribute("errMessage",err);
				request.getRequestDispatcher("/AddBanker.jsp").forward(request, response);
			}
			}
	}

}
