package manoj;

import java.io.IOException;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SearchLoanDataServlet")
public class SearchLoanDataServlet extends HttpServlet {
	
    public SearchLoanDataServlet() {
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int loanid=Integer.parseInt(request.getParameter("loanid"));
		
		LoanDao loandao=new LoanDao();
		HttpSession session=request.getSession(true);
		try{
		ResultSet rs=loandao.searchLoanData(loanid);
		while(rs.next()){
			request.setAttribute("loanid",rs.getInt(1));
			request.setAttribute("username",rs.getString(2));
			request.setAttribute("loandate",rs.getString(3));
			request.setAttribute("loanamount", rs.getDouble(4));
			request.setAttribute("interestrate",rs.getString(5));
			request.setAttribute("itemtype",rs.getString(6));
			request.setAttribute("itemname", rs.getString(7));
			request.setAttribute("totalweight", rs.getDouble(8));
			request.setAttribute("netweight", rs.getDouble(9));
			request.setAttribute("comments", rs.getString(13));
			String startdate=rs.getString(3);
			SimpleDateFormat format=new SimpleDateFormat("yyyyy-MM-dd");
			java.util.Date d1=format.parse(startdate);
			String stopdate=format.format(new java.util.Date());
			java.util.Date d2=format.parse(stopdate);
			double releaseamount=interest(rs.getDouble(4),Integer.parseInt(rs.getString(5)),d1,d2);
			request.setAttribute("releaseamount",releaseamount);
			session.setAttribute("id",rs.getInt(1));
			session.setAttribute("releasedate",format.format(d2) );
			request.getRequestDispatcher("/DeleteLoan.jsp").forward(request, response);
		}
		String err="enter a loan ID which hasn't been cleared!";
		request.setAttribute("errMessage",err );
		request.getRequestDispatcher("/LoanDataSearch.jsp").forward(request, response);
		
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public double interest(Double amount,int rateofinterest,java.util.Date d1, java.util.Date d2) throws ParseException{
		
		long milliseconddiff=d2.getTime()-d1.getTime();
		double years=milliseconddiff/1000/60/60/24/365;
		double rate=rateofinterest/100.00;
		double totalamount= (amount)*(Math.pow(1+(rate/12.00),12* years));
		int t1=(int) (totalamount*100);
		double t2=t1/100.0;
		return t2;
	}

}
