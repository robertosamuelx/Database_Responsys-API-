package action;
/**
 * @author R2
 * @version 1.0
 * @lastUpdate 03/2019
 * Thanks GOD*/

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.google.gson.Gson;

import connections.ConnectionOracle;
import dao.Login;
import dao.LoginOracle;
import dao.LoginResponsys;

public class Main{
	Login login;
	ReadFile readFile;

	public static void main(String[] args) {
		try {
			while(true) {
				new Main();
				long segundo = 1000, minuto = 60*segundo, hora = 60*minuto;
				Thread.sleep(hora);
			}
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public Main() {
		try {
			System.out.print("INICIANDO SOFTWARE");
			for(int i = 0; i < 6;i++) {
				System.out.print(".");
				Thread.sleep(500);
			}
			System.out.println();
			readFile = new ReadFile();
			login = getParameters();
			Connection con = new ConnectionOracle(login.getOracle()).openConnection();
			System.out.println("CONEXÃO ESTABELECIDA COM O BANCO");
			ResultSet rs = getUpdates(con,login.getOracle().getQuery());
			System.out.println("DADOS OBTIDOS DO BANCO");
			new ManageJson().rsToJson(rs,login.getResponsys());
			con.close();
		} 
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private Login getParameters() throws IOException {
		Gson gson = new Gson();
		Login login = new Login();
		login.setOracle(gson.fromJson(readFile.getMyJSon(new File(System.getProperty("user.home")+"//Desktop//my_api//jsonOracleDatabase.json")), LoginOracle.class));
		login.setResponsys(gson.fromJson(readFile.getMyJSon(new File(System.getProperty("user.home")+"//Desktop//my_api//jsonResponsys.json")), LoginResponsys.class));
		return login;
	}

	private ResultSet getUpdates(Connection con,String sql) throws SQLException{
		PreparedStatement ps = con.prepareStatement(sql);
		return ps.executeQuery();
	}
}
