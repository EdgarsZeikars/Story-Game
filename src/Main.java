import ChapterMapping.Book;
import ChapterMapping.Chapter;
import com.fasterxml.jackson.databind.JsonNode;

import java.nio.file.Files;
import java.nio.file.Paths;

class Main {
    public static void main(String[] args) throws Exception {
        String file = "src/ChapterOne.json";
        String book = readFileAsString(file);

        JsonNode node = Json.parse(book);
        Book data = Json.fromJson(node , Book.class);

        for (Chapter c : data.getChapter()) {
            System.out.println(c.getChunkId());
        }
    }
    public static String readFileAsString(String file)throws Exception
    {
        return new String(Files.readAllBytes(Paths.get(file)));
    }
}