package com.epam.topic3.network;

/**
 * Created by Iurii_Talalaev on 4/1/2016.
 */
public class JpegImage extends Image {

    public JpegImage(String imageName) {
        super(imageName);

        sendLogCreate();
    }

    public String getImageName() {
        return (imageName + ".JPG");
    }

    private void sendLogCreate() {
        logger.info("JPG image create: " + getImageName());
    }

    public static void logInfoClass() {
        logger.info("Class <<JpegImage>> info: \n"
                + "Class extend <<Image>> which the <<implements Downloadable>>, and have:\n"
                + "    <<public String>> method: getImageName \n"
                + "    <<private void>> method: sendLogCreate \n"
                + "    <<public static void>> method: logInfoClass"
        );
    }

}
