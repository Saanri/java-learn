package com.epam.topic3.network;

/**
 * Created by Iurii_Talalaev on 4/1/2016.
 */
public class Video extends MediaContent {
    String videoName;

    public Video(String mediaFileName, String videoName) {
        super(mediaFileName);

        setVideoName(videoName);

        sendLogCreate();
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getVideoName() {
        return videoName;
    }

    private void sendLogCreate() {
        logger.info("Video create: file name - " + getMediaFileName() + "; video name - " + getVideoName());
    }

    public static void logInfoClass() {
        logger.info("Class <<Video>> info: \n"
                + "Class extend <<MediaContent>> which the <<implements Streamable>>, and have:\n"
                + "    <<String>> property: videoName \n"
                + "    <<public void>> method: setVideoName \n"
                + "    <<public String>> method: getVideoName \n"
                + "    <<private void>> method: sendLogCreate \n"
                + "    <<public static void>> method: logInfoClass"
        );
    }
}