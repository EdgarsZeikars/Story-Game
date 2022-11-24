import ChapterMapping.Chapter;
import ChapterMapping.Dialogue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JsonTest {
    private String simpleTestCaseJsonSource = "{ \"title\": \"Coder From Scratch\", \"author\": \"Larry Bends\" }";

    private String chapter1 = "{\n" +
            "  \"chunkId\":\"0\",\n" +
            "  \"setting\": \"The sun was already setting that evening. Kaleb was going to meet Tom to collect the mysterious gem he told about. Kaleb sees Tom resting in the shade under a large oak in the park. Tom is nervously kicking a rock.\",\n" +
            "  \"dialogue\": [\n" +
            "    {\n" +
            "      \"name\": \"Tom\",\n" +
            "      \"text\": [\"Hello.\", \"I have been waiting for you for hours!\", \"We've got to leave here immediately.\",\"I am afraid an old friend of mine will spot me here.\"]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Kaleb\",\n" +
            "      \"text\": [\"Where do you want to go?\", \"Because I don't know anywhere safe and quiet in this town.\", \"And going to your apartment on the first day of meeting you is too fishy...\"]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Tom\",\n" +
            "      \"text\": [\"Maybe your place, [name]?\"]\n" +
            "    }\n" +
            "  ],\n" +
            "  \"responses\": [\n" +
            "    {\n" +
            "      \"res\": \"It's messy and too small.\",\n" +
            "      \"nextChunk\": \"2\",\n" +
            "      \"emo\": \"insecure\",\n" +
            "      \"points\": 1\n" +
            "    },\n" +
            "    {\n" +
            "      \"res\": \"I wouldn't mind.\",\n" +
            "      \"nextChunk\": \"1\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"res\": \"Definitely my house.\",\n" +
            "      \"nextChunk\": \"1\",\n" +
            "      \"emo\": \"Arrogant\",\n" +
            "      \"points\": 3\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    @Test
    void parse() throws IOException {

        JsonNode node = Json.parse(simpleTestCaseJsonSource);

        System.out.println(node.get("title").asText());
        assertEquals(node.get("title").asText(), "Coder From Scratch");
    }

    @Test
    void fromJson() throws IOException {

        JsonNode node = Json.parse(simpleTestCaseJsonSource);
        simpleTestCaseJsonPOJO pojo = Json.fromJson(node , simpleTestCaseJsonPOJO.class);

        assertEquals(pojo.getTitle(), "Coder From Scratch");
    }

    @Test
    void toJson() {
        simpleTestCaseJsonPOJO pojo = new simpleTestCaseJsonPOJO();
        pojo.setTitle("Test title");

        JsonNode node = Json.toJson(pojo);

        assertEquals(node.get("title").asText(), "Test title");
    }

    @Test
    void stringify() throws JsonProcessingException {
        simpleTestCaseJsonPOJO pojo = new simpleTestCaseJsonPOJO();
        pojo.setTitle("Test title");

        JsonNode node = Json.toJson(pojo);

        System.out.println(Json.stringify(node));
    }

    @Test
    void prettyPrint() throws JsonProcessingException {
        simpleTestCaseJsonPOJO pojo = new simpleTestCaseJsonPOJO();
        pojo.setTitle("Test title");

        JsonNode node = Json.toJson(pojo);

        System.out.println(Json.prettyPrint(node));
    }

    @Test
    void chapterTest() throws IOException {

        JsonNode node = Json.parse(chapter1);
        Chapter pojo = Json.fromJson(node , Chapter.class);

        System.out.println("Setting: " + pojo.getSetting());
    }

    @Test
    void chapterTest2() throws IOException {

        JsonNode node = Json.parse(chapter1);
        Chapter pojo = Json.fromJson(node , Chapter.class);

        System.out.println("Setting: " + pojo.getSetting());
        for (Dialogue dp : pojo.getDialogue()) {
            System.out.print(dp.getName()+": ");
            String text[] = dp.getText();
            for (int t = 0; t<text.length; t++) {
                System.out.println(text[t]);
            }
        }
    }
}