package dao;

public class LoginOracle implements ILogin{

	private String server, user, password, query;

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	@Override
	public void setUser(String user) {
		this.password = user; 
	}

	@Override
	public String getUser() {
		return this.user;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
}
