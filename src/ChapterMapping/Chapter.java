package ChapterMapping;

import java.util.List;

public class Chapter {
    private String chunkId;
    private String setting;
    private List<Dialogue> dialogue;

    public String getChunkId() {
        return chunkId;
    }

    public void setChunkId(String chunkId) {
        this.chunkId = chunkId;
    }

    public String getSetting() {
        return setting;
    }

    public void setSetting(String setting) {
        this.setting = setting;
    }

    public List<Dialogue> getDialogue() {
        return dialogue;
    }

    public void setDialogue(List<Dialogue> dialogue) {
        this.dialogue = dialogue;
    }
}
