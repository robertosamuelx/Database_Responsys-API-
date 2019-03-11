package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dao.LoginOracle;

public class ConnectionOracle {
	LoginOracle login;
	private static String driver;
	
	public ConnectionOracle(LoginOracle login){
		driver = "oracle.jdbc.driver.OracleDriver";
		this.login = login;
	}

	public Connection openConnection() throws SQLException, ClassNotFoundException{
		Class.forName(driver);
		return DriverManager.getConnection("jdbc:oracle:thin:@"+login.getServer()+":1521:orcl", login.getUser(), login.getPassword());
	}
	
	public void closeConnection(Connection con) throws SQLException {
		con.close();
	}
}
