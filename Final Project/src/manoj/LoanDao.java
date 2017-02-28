package manoj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class LoanDao {
	public boolean addLoan(Loanbean loanbean){
		String username=loanbean.getUsername();
		String loandate=loanbean.getLoandate();
		String itemtype=loanbean.getItemtype();
		String itemname=loanbean.getItemname();
		String comments=loanbean.getComment();
		double totalweight=loanbean.getTotalweight();
		double netweight=loanbean.getNetweight();
		double loanamount=loanbean.getLoanamount();
		String releasedate=loanbean.getReleasedate();
		String loanstatus=loanbean.getLoanstatus();
		double releaseamount=loanbean.getReleaseamount();
		String intrestrate=loanbean.getIntrestrate();
		
		Connection con=null;
		PreparedStatement statement=null;
		
		try{
		con=DBconnection.createConnection();
		con.setAutoCommit(false);
		String query="INSERT INTO loans(username,loandate,loanamount,intrestrate,itemtype,itemname,totalweight,netweight,releasedate,releaseamount,loanstatus,comments) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		statement=con.prepareStatement(query);
		statement.setString(1,username);
		statement.setString(2,loandate);
		statement.setDouble(3, loanamount);
		statement.setString(4, intrestrate);
		statement.setString(5, itemtype);
		statement.setString(6, itemname);
		statement.setDouble(7, totalweight);
		statement.setDouble(8, netweight);
		statement.setString(9, releasedate);
		statement.setDouble(10, releaseamount);
		statement.setString(11, loanstatus);
		statement.setString(12, comments);
		statement.executeUpdate();
		con.commit();
		return true;
		} catch (SQLException e){
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return false;
	}
	
	public ResultSet searchLoan(String username) throws SQLException{
		Connection con= DBconnection.createConnection();
		java.sql.Statement statement=con.createStatement();
		String query="SELECT * FROM loans WHERE username ='"+username+"';";
		ResultSet rs=statement.executeQuery(query);
		return rs;
	}
	
	public ResultSet searchLoanData(int loanid) throws SQLException{
		Connection con= DBconnection.createConnection();
		java.sql.Statement statement=con.createStatement();
		String query="SELECT * FROM loans WHERE loanid ='"+loanid+"' AND loanstatus='NOTCLEARED';";
		ResultSet rs=statement.executeQuery(query);
		return rs;
	}
	
	public Boolean deleteLoan(int loanid , double releaseamount, String releasedate ){
		Connection con=null;
		String query="UPDATE loans SET loanstatus='CLEARED',releasedate='"+releasedate+"',releaseamount="+releaseamount+" WHERE loanid=?;";
		try {
			con=DBconnection.createConnection();
			con.setAutoCommit(false);
			PreparedStatement statement=con.prepareStatement(query);
			statement.setInt(1, loanid);
			statement.executeUpdate();
			con.commit();
			return true;
			
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return false;
		
		
	}
}
