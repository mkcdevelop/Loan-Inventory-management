package manoj;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddItemDao {
public boolean addItem(String itemname){
	
	String itemname1=itemname.toUpperCase();
	Connection con=null;
	Statement statement=null;
	if(itemname1!=""){
	try{
		con=DBconnection.createConnection();
		con.setAutoCommit(false);
		statement=con.createStatement();
		String query="INSERT INTO items (itemname) values('"+itemname1+"');";
		statement.executeUpdate(query);
		con.commit();
		return true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	finally{
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
	return false;
}

public ResultSet searchItem() throws SQLException{
	Connection con=DBconnection.createConnection();
	Statement statement=con.createStatement();
	String query="SELECT * FROM items;";
	ResultSet rs=statement.executeQuery(query);
	return rs;
}
}
