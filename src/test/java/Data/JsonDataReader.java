package Data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JsonDataReader {
    public String userName,password,newUserRole,newUserStatus;
    public void jsonReader() throws IOException, ParseException {
        String filePath = System.getProperty("user.dir") + "/src/test/java/Data/UserData.json";
        File srcFile = new File(filePath);
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(srcFile));

        for (Object obj : jsonArray) {
            JSONObject data = (JSONObject) obj;
            userName = (String) data.get("UserName");
            password = (String) data.get("Password");
            newUserRole = (String) data.get("NewUserRole");
            newUserStatus = (String) data.get("NewUserStatus");
        }
    }
}