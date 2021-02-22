package fetcher.common;

public class Constants {

    public static final String SERVER =
            "https://jira.atlassian.com";

    public static final String REST_API =
            "/rest/api/latest/search";

    public static final String FIELDS =
            "&fields=summary,issuetype,priority,description,reporter,created,comment";

    public static final String JQL =
            "?issuetype%20in%20(Bug%2CDocumentation%2CEnhancement)AND%20updated%203E%20startOfWeek()";

    public static final String URL = SERVER + REST_API + JQL + FIELDS;

    public static final String SYSTEM_LINE = System.lineSeparator();
    public static final String DASH_LINE = "-".repeat(20) + SYSTEM_LINE;
    public static final String STAR_LINE = "*".repeat(20) + SYSTEM_LINE;

    public static final String FAILED_RESPONSE = "Failed : HTTP error code : ";

    public static final String EMPTY = "N/A";

    public static final String JSON_FILE_PATH = "src/main/resources/files/json/issues.json";
    public static final String XML_FILE_PATH = "src/main/resources/files/xml/issues.xml";

    public static final String FILETYPE_INVALID = "Invalid filetype!";


}
