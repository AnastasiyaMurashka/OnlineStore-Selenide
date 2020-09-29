package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class AbstractPage {
    protected Logger logger;

    public AbstractPage() {
        logger = LogManager.getRootLogger();
    }
}
