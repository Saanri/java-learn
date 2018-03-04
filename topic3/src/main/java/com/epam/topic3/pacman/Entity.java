package com.epam.topic3.pacman;

import com.epam.topic3.LogFactory;
import org.apache.log4j.Logger;

public abstract class Entity {

    protected Logger logger = null;
    private int posX = 0;
    private int posY = 0;

    public Entity() {
        LogFactory logFactory = new LogFactory(this.getClass().getName());
        logger = logFactory.getLogger();
        logger.info("Entity's created"); //example!
    }
}
