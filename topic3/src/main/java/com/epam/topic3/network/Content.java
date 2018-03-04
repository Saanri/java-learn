package com.epam.topic3.network;

import com.epam.topic3.LogFactory;
import org.apache.log4j.Logger;

//, Comment
public abstract class Content {
    protected static Logger logger = null;

    public Content() {
        LogFactory logFactory = new LogFactory(this.getClass().getName());
        logger = logFactory.getLogger();
    }
}


