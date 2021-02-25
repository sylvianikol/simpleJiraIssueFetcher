package fetcher.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "issues")
@XmlAccessorType(XmlAccessType.FIELD)
public class IssueContainer {

    @XmlElement(name = "issue")
    private List<Issue> issues;

    public IssueContainer() {
        this.issues = new ArrayList<>();
    }

    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }
}
