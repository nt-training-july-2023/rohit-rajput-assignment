package com.gms.dto;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * This is @CommentOutDTO for details of comment.
 */
public class CommentOutDTO {
    /**
     * This is comment message.
     */
    private String comment;
    /**
     * This is the name of user who commented.
     */
    private String userName;
    /**
     * This is comment time.
     */
    private LocalDateTime commentTime;

    /**
     * This is no-argument constructor.
     */
    public CommentOutDTO() {
        super();
    }

    /**
     * This is all-argument constructor.
     * @param comment
     * @param userName
     * @param lastUpdationTime
     */
    public CommentOutDTO(final String comment, final String userName, final LocalDateTime commentTime) {
        super();
        this.comment = comment;
        this.userName = userName;
        this.commentTime = commentTime;
    }

    /**
     * getter method for @getComment.
     * @return String - comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * setter method for @setComment.
     * @param comment
     */
    public void setComment(final String comment) {
        this.comment = comment;
    }

    /**
     * getter method for @getUserName.
     * @return String - userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * setter method for @setUserName.
     * @param userName
     */
    public void setUserName(final String userName) {
        this.userName = userName;
    }

    /**
     * getter method for @getLastUpdationTime.
     * @return String - lastUpdationTime
     */
    public LocalDateTime getLastUpdationTime() {
        return commentTime;
    }

    /**
     * setter method for @setLastUpdationTime.
     * @param lastUpdationTime
     */
    public void setLastUpdationTime(final LocalDateTime commentTime) {
        this.commentTime = commentTime;
    }

    /**
     * This is @hashCode method
     */
    @Override
    public int hashCode() {
        return Objects.hash(comment, commentTime, userName);
    }

    /**
     * This is @equals method,
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        CommentOutDTO other = (CommentOutDTO) obj;
        return Objects.equals(comment, other.comment) && Objects.equals(commentTime, other.commentTime)
                && Objects.equals(userName, other.userName);
    }

    /**
     * This is @toString method.
     */
    @Override
    public String toString() {
        return "CommentOutDTO [comment=" + comment + ", userName=" + userName + ", commentTime=" + commentTime
                + "]";
    }

}
