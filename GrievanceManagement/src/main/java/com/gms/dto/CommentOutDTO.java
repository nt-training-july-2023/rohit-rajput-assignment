package com.gms.dto;

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
    private String name;

    /**
     * This is no-argument constructor.
     */
    public CommentOutDTO() {
        super();
    }

    /**
     * This is all-argument constructor.
     * @param comment
     * @param name
     */
    public CommentOutDTO(final String comment, final String name) {
        super();
        this.comment = comment;
        this.name = name;
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
     * getter method for @getName.
     * @return String - name
     */
    public String getName() {
        return name;
    }

    /**
     * setter method for @setName.
     * @param name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * This is @hashCode method.
     */
    @Override
    public int hashCode() {
        return Objects.hash(comment, name);
    }

    /**
     * This is @equals method.
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
        return Objects.equals(comment, other.comment) && Objects.equals(name, other.name);
    }

    /**
     * This is @toString method.
     */
    @Override
    public String toString() {
        return "CommentOutDTO [comment=" + comment + ", name=" + name + "]";
    }

}
