package manoj;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/AddLoanServlet")
public class AddLoanServlet extends HttpServlet {
	
    public AddLoanServlet() {
         }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(true);
		String username=(String) session.getAttribute("userName");
		String loandate=(String) session.getAttribute("loandate");
		String itemtype=request.getParameter("itemtype");
		String itemname=request.getParameter("itemname");
		String comments=request.getParameter("comments");
		double totalweight=Double.parseDouble(request.getParameter("totalweight"));
		double netweight=Double.parseDouble(request.getParameter("netweight"));
		double loanamount=Double.parseDouble(request.getParameter("loanamount"));
		String intrestrate=request.getParameter("intrestrate");
		String releasedate=null;
		double releaseamount=0;
		String loanstatus="NOTCLEARED";
		
		Loanbean loanbean= new Loanbean();
		
		loanbean.setUsername(username);
		loanbean.setLoandate(loandate);
		loanbean.setItemtype(itemtype);
		loanbean.setItemname(itemname);
		loanbean.setComment(comments);
		loanbean.setTotalweight(totalweight);
		loanbean.setNetweight(netweight);
		loanbean.setLoanamount(loanamount);
		loanbean.setIntrestrate(intrestrate);
		loanbean.setReleasedate(releasedate);
		loanbean.setReleaseamount(releaseamount);
		loanbean.setLoanstatus(loanstatus);
		
		LoanDao loandao = new LoanDao();
		Boolean loanadded=loandao.addLoan(loanbean);
		if(loanadded==true){
			request.setAttribute("userName",username);
			request.setAttribute("loanDate",loandate);
			request.setAttribute("itemType",itemtype);
			request.setAttribute("itemName", itemname);
			request.setAttribute("comments",comments);
			request.setAttribute("totalWeight",totalweight);
			request.setAttribute("netWeight",netweight);
			request.setAttribute("loanAmount", loanamount);
			request.setAttribute("intrestRate",intrestrate);
			request.getRequestDispatcher("/AddLoanSuccess.jsp").forward(request, response);
		}
		else{
			String err="Invalid Data!!";
			request.setAttribute("errMessage",err);
			request.getRequestDispatcher("/CustomerSearch.jsp").forward(request, response);
		}
	}

}
