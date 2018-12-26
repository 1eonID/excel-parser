package beans;

import lombok.Data;

import java.util.List;

@Data
public class ResultRowObject {
    String heading;
    String itemType;
    String summary;
    String description;
    String globalId;
    String domain;
    String panasJiraId;
    String luxJiraId;
    String linkType;
    List<String> linkList;
}
