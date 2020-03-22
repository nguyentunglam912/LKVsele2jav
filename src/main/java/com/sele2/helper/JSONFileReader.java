package com.sele2.helper;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONFileReader {
	
	public static String propertyFilePath = System.getProperty("user.dir") + "\\src\\main\\java\\com\\sele2\\support\\TestData.json";

	public String getValueFromJsonObjectGivenKeys(JSONObject jsonObject, String[] keys) throws FileNotFoundException, IOException, ParseException {
		String currentKey = keys[0];

	    if (keys.length == 1 && jsonObject.containsKey(currentKey)) {
	    	return (String) jsonObject.get(currentKey);
	    }

	    JSONObject nestedJsonObjectVal = (JSONObject) jsonObject.get(currentKey);
	    int nextKeyIdx = 1;
	    String[] remainingKeys = Arrays.copyOfRange(keys, nextKeyIdx, keys.length);
	    return getValueFromJsonObjectGivenKeys(nestedJsonObjectVal, remainingKeys);
	    }
	
	public String[] extractKeys(String path) {
		String leadingSlash = "/";
	    return path.substring(1).split(leadingSlash);
	}
	
	public String getValueFromJson(String keyPath){
		String[] keys = extractKeys(keyPath);
		JSONParser parser = new JSONParser();
		String value = null;
		try {
			Object obj = parser.parse(new FileReader(propertyFilePath));
			JSONObject jsonObject = (JSONObject) obj;
			value = getValueFromJsonObjectGivenKeys(jsonObject, keys);
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return value;
	}
}