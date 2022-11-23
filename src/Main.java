import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.nio.file.Files;
import java.nio.file.Paths;

class Main {
    public static void main(String[] args) throws Exception {
        JSONParser parser = new JSONParser();

        String file = "src/ChapterOne.json";
        String chapter = readFileAsString(file);

        Object obj = parser.parse(chapter);
        JSONArray data = (JSONArray)obj;

        for (int i = 0; i<data.size(); i++) {
            Object intentData = data.get(i);
        }
    }
    public static String readFileAsString(String file)throws Exception
    {
        return new String(Files.readAllBytes(Paths.get(file)));
    }
}