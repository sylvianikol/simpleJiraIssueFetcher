package fetcher.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.Objects;

import static fetcher.common.Constants.DASH_LINE;

@XmlRootElement(name = "comment")
@XmlAccessorType(XmlAccessType.FIELD)
public class Comment {

    @XmlElement(name = "comment-text")
    private String commentText;
    @XmlElement
    private String author;

    public Comment() {
    }

    public Comment(String commentText, String author) {
        this.commentText = commentText;
        this.author = author;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return String.format("Comment: %s%n%n\tAuthor: %s%n%s", this.getCommentText(), this.getAuthor(), DASH_LINE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment)) return false;
        Comment comment = (Comment) o;
        return Objects.equals(commentText, comment.commentText) &&
                Objects.equals(author, comment.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentText, author);
    }
}
