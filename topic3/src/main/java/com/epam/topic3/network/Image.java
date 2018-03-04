package com.epam.topic3.network;

// Картинка
public class Image extends Content implements Downloadable {
    String imageName;

    public Image(String imageName) {
        setImageName(imageName);
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public void preview() {
        logger.info("Image preview.");
    }

    @Override
    public void download() {
        logger.info("Download image, complete.");
    }

    @Override
    public void delete() {
        logger.info("Image <<" + this.imageName + ">>(default *.JPG) - deleted.");
    }
}
//