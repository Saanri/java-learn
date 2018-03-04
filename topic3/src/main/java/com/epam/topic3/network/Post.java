package com.epam.topic3.network;

import java.util.ArrayList;

// Пост ----------------------------------------------------------------------------------------------------------------
public class Post extends Content {
    String userAuthName;
    String titlePost;
    String textPost;
    ArrayList<Object> addedObject;
    ArrayList<Comment> userComments;

    // inner class Комментарий
    private class Comment {
        String userSndName;
        String commentStr;

        public Comment(String userSndName, String commentStr) {
            setUserSndName(userSndName);
            setCommentStr(commentStr);

            sendLogCreate();
        }

        public void setCommentStr(String commentStr) {
            this.commentStr = commentStr;
        }

        public void setUserSndName(String userSndName) {
            this.userSndName = userSndName;
        }

        public String getUserSndName() {
            return userSndName;
        }

        public String getCommentStr() {
            return commentStr;
        }

        private void sendLogCreate() {
            logger.info("User <<" + getUserSndName() + ">> commented on the post: " + getCommentStr());
        }
    }
    // inner class Комментарий

    public Post(String userAuthName, String titlePost, String textPost, ArrayList<Object> addedObject) {
        setUserAuthName(userAuthName);
        setTitlePost(titlePost);
        setTextPost(textPost);
        if (addedObject.isEmpty())
            setEmptyAddedObject();
        else
            setAddedObject(addedObject);

        setEmptyUserComments();

        sendLogCreate();
    }

    private void setUserAuthName(String userAuthName) {
        this.userAuthName = userAuthName;
    }

    public void setTitlePost(String titlePost) {
        this.titlePost = titlePost;
    }

    public void setTextPost(String textPost) {
        this.textPost = textPost;
    }

    private void setAddedObject(ArrayList<Object> addedObject) {
        this.addedObject = addedObject;
    }

    private void setEmptyAddedObject() {
        this.addedObject = new ArrayList<Object>();
    }

    private void setEmptyUserComments() {
        this.userComments = new ArrayList<Comment>();
    }

    public String getUserAuthName() {
        return userAuthName;
    }

    public String getTitlePost() {
        return titlePost;
    }

    public String getTextPost() {
        return textPost;
    }

    public ArrayList<Object> getAddedObject() {
        return addedObject;
    }

    public void addObject(Object object) {
        this.addedObject.add(object);
    }

    public void addComment(String userSndName, String commentStr) {
        Comment comment = new Comment(userSndName, commentStr);
        this.userComments.add(comment);
    }

    private void sendLogCreate() {
        logger.info("User <<" + userAuthName + ">> send new post. Title - "+ titlePost);
    }

}
// Пост ----------------------------------------------------------------------------------------------------------------
