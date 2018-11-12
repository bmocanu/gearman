package gearman.commons;

public class AppPaths {

    public static final String ROOT_FOLDER = System.getProperty("user.home") + "/.gearman";
    public static final String MODULES_FOLDER = ROOT_FOLDER + "/modules";
    public static final String MODULES_CONFIG_FILE = MODULES_FOLDER + "/modules.xml";
    public static final String LOGGING_FOLDER = ROOT_FOLDER + "/logs";
    public static final String LOGGING_CONFIG_FILE = ROOT_FOLDER + "/logging.xml";
    public static final String APP_CONFIG_FILE = ROOT_FOLDER + "/config.xml";

}
