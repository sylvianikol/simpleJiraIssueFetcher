package fetcher.extractor;

import fetcher.entity.Comment;
import fetcher.entity.Issue;
import fetcher.entity.IssueContainer;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import static fetcher.common.Attribute.*;
import static fetcher.util.IssueFieldGetter.*;
import static fetcher.common.Constants.SERVER;

public class IssueExtractor implements Extractor<IssueContainer, Issue> {

    private final Extractor<List<Comment>, Comment> commentExtractor;
    private JSONObject jsonIssue;
    private JSONObject jsonFields;

    public IssueExtractor() {
        this.jsonIssue = new JSONObject();
        this.jsonFields = new JSONObject();
        this.commentExtractor = new CommentExtractor();
    }

    @Override
    public IssueContainer fillContainer(JSONArray jsonIssueArray) {

        IssueContainer issueContainer = new IssueContainer();

        for (int i = 0; i < jsonIssueArray.length(); i++) {
            this.jsonIssue = jsonIssueArray.getJSONObject(i);
            this.jsonFields = getJsonObject(jsonIssue, FIELDS);
            issueContainer.getIssues().add(this.assembleElement());
        }

        return issueContainer;
    }

    @Override
    public Issue assembleElement() {

        Issue issue = new Issue();

        issue.setSummary(getFieldName(this.jsonFields, SUMMARY));
        issue.setKey(getFieldName(this.jsonIssue, KEY));
        issue.setUrl(SERVER + "/browse/" + getFieldName(jsonIssue, KEY));
        issue.setIssueType(getFieldValue(this.jsonFields, ISSUETYPE, NAME));
        issue.setPriority(getFieldValue(this.jsonFields, PRIORITY, NAME));
        issue.setDescription(getFieldName(this.jsonFields, DESCRIPTION));
        issue.setReporter(getFieldValue(this.jsonFields, REPORTER, DISPLAYNAME));
        issue.setCreatedDate(getFieldName(this.jsonFields, CREATED));

        JSONArray commentsArray = getJsonArray(this.jsonFields, COMMENT, COMMENTS);

        List<Comment> comments = this.commentExtractor.fillContainer(commentsArray);
        issue.setComments(comments);

        return issue;
    }
}
