package fetcher.extractor;

import fetcher.model.Comment;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static fetcher.common.Attribute.*;
import static fetcher.util.IssueFieldExtractor.getFieldName;
import static fetcher.util.IssueFieldExtractor.getFieldValue;

public class CommentExtractor implements Extractor<List<Comment>, Comment> {

    private JSONObject jsonComment;

    public CommentExtractor() {
        this.jsonComment = new JSONObject();
    }

    @Override
    public List<Comment> fillContainer(JSONArray jsonCommentsArray) {
        List<Comment> comments = new ArrayList<>();

        for (int i = 0; i < jsonCommentsArray.length(); i++) {
            this.jsonComment = jsonCommentsArray.getJSONObject(i);
            comments.add(this.assembleElement());
        }

        return comments;
    }

    @Override
    public Comment assembleElement() {

        String commentText = getFieldName(jsonComment, BODY);
        String author = getFieldValue(jsonComment, AUTHOR, DISPLAYNAME);

        return new Comment(commentText, author);
    }

}
