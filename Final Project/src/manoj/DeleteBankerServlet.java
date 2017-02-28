package manoj;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/DeleteBankerServlet")
public class DeleteBankerServlet extends HttpServlet {
	
    public DeleteBankerServlet() {
        }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	HttpSession session=request.getSession(true);
	String username=(String) session.getAttribute("user");
	
	AdduserDao adduserdao=new AdduserDao();
	System.out.print("the username to be deleted is :"+username);
	Boolean userdeleted=adduserdao.deleteBanker(username);
	
	if(userdeleted==true){
		String message="user has been successfully deleted";
		request.setAttribute("Message",message);
		request.getRequestDispatcher("/AdminHome.jsp").forward(request, response);
	}
	else{
		String err="Something has Gone wrong!! Try again";
		request.setAttribute("errMessage",err);
		request.getRequestDispatcher("/BankerSearch.jsp").forward(request, response);
	}
	
	}

}
