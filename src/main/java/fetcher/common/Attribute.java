package fetcher.common;

public enum Attribute {

    SUMMARY("summary"),
    KEY("key"),
    ISSUETYPE("issueType"),
    NAME("name"),
    PRIORITY("priority"),
    DESCRIPTION("description"),
    REPORTER("reporter"),
    DISPLAYNAME("displayName"),
    CREATED("created"),
    COMMENT("comment"),
    COMMENTS("comments"),
    BODY("body"),
    AUTHOR("author"),
    FIELDS("fields"),
    ISSUES("issues");

    public final String label;

    Attribute(String label) {
        this.label = label;
    }
}
