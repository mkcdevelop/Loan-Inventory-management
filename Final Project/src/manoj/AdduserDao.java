package manoj;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdduserDao {
public Boolean addUser(Loginbean loginbean){
	String username=loginbean.getUsername();
	String password=loginbean.getPassword();
	String firstname=loginbean.getFirstname();
	String lastname=loginbean.getLastname();
	String dateofbirth=loginbean.getDateofbirth();
	String phonenumber=loginbean.getPhonenumber();
	String city=loginbean.getCity();
	String userrole=loginbean.getUserrole();
	
	Connection con=null;
	Statement statement=null;
	
	try{
		con= DBconnection.createConnection();
		con.setAutoCommit(false);
		statement=con.createStatement();
		String query="INSERT INTO login VALUES ('"+username+"','"+password+"','"+firstname+"','"+lastname+"','"+dateofbirth+"','"+phonenumber+"','"+city+"','"+userrole+"');";
		statement.executeUpdate(query);
		con.commit();
		return true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		try {
			con.rollback();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	finally{
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return false ;
}
public ResultSet searchBanker(String username){
	
	Connection con=null;
	Statement statement=null;
	ResultSet rs=null;
	
	try{
	con=DBconnection.createConnection();
	statement=con.createStatement();
	String query="SELECT * FROM login WHERE username='"+username+"';";
	rs=statement.executeQuery(query);
	return rs;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return rs;	
}

public Boolean deleteBanker(String username){
	Connection con=null;
	Statement statement=null;	
	
	try {
		con=DBconnection.createConnection();
		con.setAutoCommit(false);
		statement=con.createStatement();
		String query="DELETE FROM login WHERE username='"+username+"';";
		statement.executeUpdate(query);
		con.commit();
		return true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		try {
			con.rollback();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	return false;
	
	
	
}
}
