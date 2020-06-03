package filemanager;

import java.io.FileReader;
import java.util.TreeMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonParser
{

	@SuppressWarnings("unchecked")
	public static TreeMap<String, String> parseJSON(String jsonPath)
	{

		JSONParser parser = new JSONParser();

		TreeMap<String, String> objects = null;
		
		try
		{

			JSONObject jsonObject = (JSONObject) parser
					.parse(new FileReader(jsonPath));

			objects = new TreeMap<>(jsonObject);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return objects;

	}

}
