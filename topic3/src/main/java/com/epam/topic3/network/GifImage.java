package com.epam.topic3.network;

/**
 * Created by Iurii_Talalaev on 4/1/2016.
 */
public class GifImage extends Image {

    public GifImage(String imageName) {
        super(imageName);

        sendLogCreate();
    }

    public String getImageName() {
        return (imageName + ".GIF");
    }

    public final void preview() {
        logger.info("GIF image preview.");
    }

    public final void download() {
        logger.info("Download GIF image, complete.");
    }

    public final void delete() {
        logger.info("Image <<" + getImageName() + ">> - deleted.");
    }

    private void sendLogCreate() {
        logger.info("GIF image create: " + getImageName());
    }

    public static void logInfoClass() {
        logger.info("Class <<GifImage>> info: \n"
                + "Class extend <<Image>> which the <<implements Downloadable>>, and have:\n"
                + "    <<public String>> method: getImageName \n"
                + "    <<public final void>> method: preview, download, delete \n"
                + "    <<private void>> method: sendLogCreate \n"
                + "    <<public static void>> method: logInfoClass"
        );
    }
}
