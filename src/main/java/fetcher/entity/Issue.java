package fetcher.entity;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@XmlRootElement(name = "issue")
@XmlAccessorType(XmlAccessType.FIELD)
public class Issue {

    @XmlElement
    private String summary;
    @XmlElement
    private String key;
    @XmlElement
    private String url;
    @XmlElement(name = "issue-type")
    private String issueType;
    @XmlElement
    private String priority;
    @XmlElement
    private String description;
    @XmlElement
    private String reporter;
    @XmlElement(name = "created-date")
    private String createdDate;

    @XmlElementWrapper(name = "comments")
    @XmlElement(name = "comment")
    private List<Comment> comments;

    public Issue() {
        this.comments = new ArrayList<>();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Issue)) return false;
        Issue issue = (Issue) o;
        return Objects.equals(summary, issue.summary) &&
                Objects.equals(key, issue.key) &&
                Objects.equals(url, issue.url) &&
                Objects.equals(issueType, issue.issueType) &&
                Objects.equals(priority, issue.priority) &&
                Objects.equals(description, issue.description) &&
                Objects.equals(reporter, issue.reporter) &&
                Objects.equals(createdDate, issue.createdDate) &&
                Objects.equals(comments, issue.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(summary, key, url, issueType, priority, description, reporter, createdDate, comments);
    }
}
