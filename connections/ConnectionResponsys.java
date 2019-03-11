package connections;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import dao.LoginResponsys;

public class ConnectionResponsys {
	LoginResponsys login;
	
	public ConnectionResponsys(LoginResponsys login) {
		this.login = login;
	}
	
	public String getKey() throws ClientProtocolException, IOException {
		HttpClient httpClient = HttpClientBuilder.create().build(); 
		HttpPost post = new HttpPost(login.getUrlConnection());
		String body = "user_name="+login.getUser()+"&password="+login.getPassword()+"&auth_type="+login.getAuth_type();
	    StringEntity params = new StringEntity(body);
	    post.addHeader("Content-type", "application/x-www-form-urlencoded");
	    post.addHeader("Charset","UTF-8");
	    post.setEntity(params);
	    JsonObject ob = new Gson().fromJson(EntityUtils.toString(httpClient.execute(post).getEntity()),JsonObject.class);
	    return ob.get("authToken").getAsString();
	}
}
