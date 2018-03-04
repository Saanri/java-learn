package com.epam.topic3.network;

/**
 * Created by Iurii_Talalaev on 4/1/2016.
 */

// Музыкальный контент
public class Audio extends MediaContent {
    String groupName; // Исполнитель песни
    String songName;  // Название композиции

    public Audio(String mediaName, String groupName, String songName) {
        super(mediaName);

        setGroupName(groupName);
        setSongName(songName);

        sendLogCreate();
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getSongName() {
        return songName;
    }

    private void sendLogCreate() {
        logger.info("Audio create: file name - " + getMediaFileName() + "; group name name - " + getGroupName() + "; song name - " + getSongName());
    }

    public static void logInfoClass() {
        logger.info("Class <<Audio>> info: \n"
                + "Class extend <<MediaContent>> which the <<implements Streamable>>, and have:\n"
                + "    <<String>> property: groupName, songName \n"
                + "    <<public void>> method: setGroupName, setSongName \n"
                + "    <<public String>> method: getGroupName, getSongName \n"
                + "    <<private void>> method: sendLogCreate \n"
                + "    <<public static void>> method: logInfoClass"
        );
    }

}
//
