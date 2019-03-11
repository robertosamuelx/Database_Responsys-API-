package action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import dao.JsonResponsys;

public class ReadFile {

	public String getMyJSon(File file) throws IOException {
		FileReader reader = new FileReader(file);
		BufferedReader buff = new BufferedReader(reader);
		StringBuilder build = new StringBuilder();
		while(buff.ready()) {
			build.append(buff.readLine());
		}
		buff.close();
		reader.close();
		return build.toString();
	}
	
	public JsonResponsys getJsonResponsysFormat() throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		File file = new File(System.getProperty("user.home")+"//Desktop//my_api//file.json");
		return new Gson().fromJson(new FileReader(file), JsonResponsys.class);
	}
}
