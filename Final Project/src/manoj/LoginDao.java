package manoj;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDao {
public String loginAuthenticate(Loginbean loginbean)
{
	String username=loginbean.getUsername();
	String password=loginbean.getPassword();
	
	Connection con=null;
	Statement statement=null;
	ResultSet resultset=null;
		
		try
		{
			con= DBconnection.createConnection();
			statement=con.createStatement();
			resultset=statement.executeQuery("select * from login where username='"+username+"'AND password='"+password+"'");
		
		while(resultset.next())
		{
		if(username.equals(resultset.getString("username")) && password.equals(resultset.getString("password")))
			{
				return resultset.getString("userrole");
			}
		}

		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return "Invalid Credentials!!";		
	}
}

