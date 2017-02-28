package manoj;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/DeleteLoanServlet")
public class DeleteLoanServlet extends HttpServlet {

    public DeleteLoanServlet() {
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoanDao loandao= new LoanDao();
		HttpSession session=request.getSession(true);
		int id=(int) session.getAttribute("id");
		String releasedate=(String) session.getAttribute("relaesedate");
		double releaseamount=(double) session.getAttribute("releaseamount");
		Boolean loancleared=loandao.deleteLoan(id,releaseamount,releasedate);
		if(loancleared==true){
			String message="Loan has been successfully cleared";
			request.setAttribute("Message",message);
			request.getRequestDispatcher("/BankerHome.jsp").forward(request, response);
		}
		else{
			String err="Something has Gone wrong!! Try again";
			request.setAttribute("errMessage",err);
			request.getRequestDispatcher("/LoanSearch.jsp").forward(request, response);
		}
	}

}
