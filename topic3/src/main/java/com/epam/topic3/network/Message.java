package com.epam.topic3.network;

// Сообщение -----------------------------------------------------------------------------------------------------------
public class Message extends Content {
    String userSndName;
    String userDstName;
    String msgStr;

    public Message(String userSndName, String userDstName, String msgStr) {
        setUserSender(userSndName);
        setUserDestination(userDstName);
        setMessageStr(msgStr);

        sendLogCreate();
    }

    public void setUserSender(String userSndName) {
        this.userSndName = userSndName;
    }

    public void setUserDestination(String userDstName) {
        this.userDstName = userDstName;
    }

    public void setMessageStr(String msgStr) {
        this.msgStr = msgStr;
    }

    public String getUserSender() {
        return userSndName;
    }

    public String getUserDestination() {
        return userDstName;
    }

    public String getMessageStr() {
        return msgStr;
    }

    public String getMessage() {
        return "User <<" + userSndName + ">> send message from <<" + userDstName + ">>: " + msgStr;
    }

    private void sendLogCreate() {
        logger.info(getMessage());
    }
}
// Сообщение -----------------------------------------------------------------------------------------------------------
