import java.util.*;

public class Comment extends Entity {

    private String comment;
    private final Date date = new Date();
    private final User user;

    public Comment(String comment, User user) {

        super();
        this.comment = comment;
        this.user = user;
    }

    public void validate() {

    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return this.date;
    }

    public User getUser() {
        return this.user;
    }

}
