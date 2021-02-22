package fetcher.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

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

}
