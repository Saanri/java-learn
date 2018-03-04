package com.epam.topic3.network;

/**
 * Created by Iurii_Talalaev on 4/1/2016.
 */
// Медиа контент
public class MediaContent extends Content implements Streamable {
    String mediaFileName;

    public MediaContent(String mediaName) {
        setMediaFileName(mediaName);
    }

    public void setMediaFileName(String mediaFileName) {
        this.mediaFileName = mediaFileName;
    }

    public String getMediaFileName() {
        return mediaFileName;
    }

    @Override
    public void playMediaFile() {
        logger.info("Media file <<" + mediaFileName + ">> played.");
    }

    @Override
    public void downloadMediaFile() {
        logger.info("Download media file <<" + mediaFileName + ">>, complete.");
    }
}
//