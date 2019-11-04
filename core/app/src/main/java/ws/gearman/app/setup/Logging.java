package ws.gearman.app.setup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.util.ContextInitializer;

public class Logging {

    private static Logger log;

    public static void init() {
        System.setProperty("gearman.loggingFolder", AppPaths.LOGGING_FOLDER);
        System.setProperty(ContextInitializer.CONFIG_FILE_PROPERTY, AppPaths.LOGGING_CONFIG_FILE);
        log = LoggerFactory.getLogger(Logging.class);
        log.info("Initialized logging to {}", AppPaths.LOGGING_FOLDER);
    }

}
