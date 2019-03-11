package action;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import connections.ConnectionResponsys;
import dao.JsonResponsys;
import dao.LoginResponsys;

public class ManageJson {
	
	public HttpResponse sendJson(String textJson,String urlPost, String key) throws ClientProtocolException, IOException {
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(urlPost);
		post.setHeader("Authorization",key);
		post.setHeader("Charset","UTF-8");
		post.setHeader("Content-type", "application/json");
		HttpEntity body = new StringEntity(textJson,"UTF-8");
		post.setEntity(body);
		return httpClient.execute(post);
	}
	
	public void rsToJson(ResultSet rs,LoginResponsys loginResponsys) throws SQLException, JsonSyntaxException, JsonIOException, ClientProtocolException, IOException, InterruptedException{
		JsonResponsys responsys = new ReadFile().getJsonResponsysFormat();
		ResultSetMetaData meta = rs.getMetaData();
		int columns = meta.getColumnCount();
    	String[] column_names_array = new String[columns];
    	for(int i = 0; i < columns;i++) {
    		column_names_array[i] = meta.getColumnName(i+1);
    	}
    	ArrayList<String[]> arrayOfarray = new ArrayList<String[]>();
    	int k = 1,m = 0;
        while (rs.next()) {
        	m++;
        	System.out.println(m);
        	k++;
        	if(k < 200) {
	        	String[] records = new String[columns];
	        	for(int i = 0; i < columns;i++) {
	        		if(rs.getString(column_names_array[i]) == null)
	        			records[i] = "";
	        		else
	        			records[i] = rs.getString(column_names_array[i]);
	        	}
	        	arrayOfarray.add(records);
        	}
        	else {
        		 String[][] arrayRecord = new String[arrayOfarray.size()][columns];
        	        for(int i = 0; i < arrayOfarray.size();i++) {
        	        	for(int j = 0; j < columns;j++) {
        	        		arrayRecord[i][j] = arrayOfarray.get(i)[j];
        	        	}
        	        }
        	        responsys.getRecordData().setFieldNames(getReplace(column_names_array,loginResponsys));
        	        responsys.getRecordData().setRecords(arrayRecord);
        	        sendJson(new GsonBuilder().serializeNulls().create().toJson(responsys), loginResponsys.getUrlPost(), new ConnectionResponsys(new Gson().fromJson(new ReadFile().getMyJSon(new File(System.getProperty("user.home")+"//Desktop//my_api//jsonResponsys.json")), LoginResponsys.class)).getKey());
        	        k = 0;
        	        arrayOfarray.clear();
        	        try {
        	        	Thread.sleep(10000);
        	        }
        	        catch(InterruptedException e) {
        	        	e.printStackTrace();
        	        }
        	}
        }
        if(!arrayOfarray.isEmpty()) {
        	String[][] arrayRecord = new String[arrayOfarray.size()][columns];
	        for(int i = 0; i < arrayOfarray.size();i++) {
	        	for(int j = 0; j < columns;j++) {
	        		arrayRecord[i][j] = arrayOfarray.get(i)[j];
	        	}
	        }
	        responsys.getRecordData().setFieldNames(getReplace(column_names_array,loginResponsys));
	        responsys.getRecordData().setRecords(arrayRecord);
	        sendJson(new GsonBuilder().serializeNulls().create().toJson(responsys), loginResponsys.getUrlPost(), new ConnectionResponsys(new Gson().fromJson(new ReadFile().getMyJSon(new File(System.getProperty("user.home")+"//Desktop//my_api//jsonResponsys.json")), LoginResponsys.class)).getKey());
	        k = 0;
	        arrayOfarray.clear();
        }
        rs.close();
	}

	private String[] getReplace(String[] column_names_array, LoginResponsys responsys) {
		String[] aux = column_names_array.clone();
		for(int i = 0; i < aux.length;i++) {
			String coluna = aux[i];
			for(int j = 0; j < responsys.getFormatter().getDatabaseFields().length;j++) {
				if(coluna.equals(responsys.getFormatter().getDatabaseFields()[j])) {
					aux[i] = responsys.getFormatter().getResponsysFields()[j];
				}
			}
		}
		return aux;
	}
	
	
}

