package dao;

public class LoginResponsys implements ILogin{

	private String user, password,auth_type, key, urlPost, urlConnection;
	private Formatter formatter;

	public String getAuth_type() {
		return auth_type;
	}

	public void setAuth_type(String auth_type) {
		this.auth_type = auth_type;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public void setUser(String user) {
		this.user = user;
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

	public String getUrlPost() {
		return urlPost;
	}

	public void setUrlPost(String urlPost) {
		this.urlPost = urlPost;
	}

	public String getUrlConnection() {
		return urlConnection;
	}

	public void setUrlConnection(String urlConnection) {
		this.urlConnection = urlConnection;
	}

	public Formatter getFormatter() {
		return formatter;
	}

	public void setFormatter(Formatter formatter) {
		this.formatter = formatter;
	}
}
