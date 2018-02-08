package model;

import java.util.List;
import java.util.UUID;

public class DetailedResult {
    private UUID uuid;
    private List<String> verseList;
    private List<String> overlapList;

    public DetailedResult(UUID uuid){
        this.uuid = uuid;
    }

    public void setVerseList(List<String> verseList) {
        this.verseList = verseList;
    }

    public void setOverlapList(List<String> overlapList) {
        this.overlapList = overlapList;
    }
}
