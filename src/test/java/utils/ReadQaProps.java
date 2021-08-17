package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ReadQaProps {
    JSONObject data;
    static ReadQaProps readQaProps;
    JSONParser parser = new JSONParser();

    private ReadQaProps() {

    }

    public static ReadQaProps _init() {
        if (readQaProps == null)
            return new ReadQaProps();
        else
            return readQaProps;
    }

    public JSONObject config() {
        try {
            data = (JSONObject) parser.parse(
                    new FileReader("src/test/resources/config.json"));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return data;
    }

    public JSONObject invalidInput() {
        try {
            data = (JSONObject) parser.parse(
                    new FileReader("src/test/resources/testData/invalid.json"));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return data;
    }

    public JSONObject validInput() {
        try {
            data = (JSONObject) parser.parse(
                    new FileReader("src/test/resources/testData/valid.json"));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static String getValue(Object o) {
        _init();
        return o.toString();
    }
}
