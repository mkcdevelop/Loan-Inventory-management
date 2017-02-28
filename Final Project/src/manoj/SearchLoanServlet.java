package manoj;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchLoanServlet")
public class SearchLoanServlet extends HttpServlet {
	
    public SearchLoanServlet() {
        }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String username=request.getParameter("username");	
	
	Loanbean loan=null;
	LoanDao loandao=new LoanDao();
	if(username!="" && username!=null){
	try{
	ResultSet rs= loandao.searchLoan(username);
	List<Loanbean> list=new ArrayList();
	while(rs.next()){
		loan=new Loanbean();
		loan.setLoanid(rs.getInt(1));
		loan.setUsername(rs.getString(2));
		loan.setLoandate(rs.getString(3));
		loan.setLoanamount(rs.getDouble(4));
		loan.setIntrestrate(rs.getString(5));
		loan.setItemtype(rs.getString(6));
		loan.setItemname(rs.getString(7));
		loan.setTotalweight(rs.getDouble(8));
		loan.setNetweight(rs.getDouble(9));
		loan.setComment(rs.getString(13));
		list.add(loan);
	}
	request.setAttribute("loanlist",list);
	request.getRequestDispatcher("/LoanList.jsp").forward(request, response);
	}
	catch(SQLException e){
		e.printStackTrace();
		
	}
	}
	else{
		String err="No such Loans!! try Again!!";
		request.setAttribute("errMessage",err );
		request.getRequestDispatcher("/LoanSearch.jsp").forward(request, response);
	
	}
	}

}
