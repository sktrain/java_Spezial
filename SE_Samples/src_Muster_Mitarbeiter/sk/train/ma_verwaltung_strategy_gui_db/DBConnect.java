package sk.train.ma_verwaltung_strategy_gui_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	
	public static Connection createConnection() throws ClassNotFoundException, SQLException{
		Class.forName("org.h2.Driver");
		Connection con =  DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");	
		System.err.println(con);
		return con;
	}
	
	public static void closeConnection(Connection con) throws SQLException{
		con.close();
	}

}
