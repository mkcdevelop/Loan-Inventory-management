package manoj;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AddItemServlet")
public class AddItemServlet extends HttpServlet {
	
    public AddItemServlet() {       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String itemname=request.getParameter("itemname");
		
		AddItemDao additemdao = new AddItemDao();
		Boolean bol=additemdao.addItem(itemname);
			if(bol==true){
				request.setAttribute("itemName", itemname);
				String message="Item "+itemname+" has been successfully added";
				request.setAttribute("Message",message);
				request.getRequestDispatcher("/AdminHome.jsp").forward(request, response);
			}
			else{
				String err="Invalid Data!!!";
				request.setAttribute("errMessage", err);
				request.getRequestDispatcher("/AddItem.jsp").forward(request, response);
			}
	}

}
