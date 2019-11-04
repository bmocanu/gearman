package ws.gearman.app.setup;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class AppFolder {

    private static Logger log;

    public static void init() throws Exception {
        log = LoggerFactory.getLogger(AppFolder.class);
        ensureFolderExists(AppPaths.ROOT_FOLDER);
        ensureFolderExists(AppPaths.MODULES_FOLDER);
        ensureFolderExists(AppPaths.LOGGING_FOLDER);
        ensureFileExists(AppPaths.MODULES_CONFIG_FILE, "/default-config/modules.xml");
        ensureFileExists(AppPaths.LOGGING_CONFIG_FILE, "/default-config/logging.xml");
        ensureFileExists(AppPaths.APP_CONFIG_FILE, "/default-config/config.xml");
    }

    // ----------------------------------------------------------------------------------------------------

    private static void ensureFolderExists(String folderPath) {
        File folder = new File(folderPath);
        if (!folder.exists()) {
            if (!folder.mkdirs()) {
                System.out.println("ERROR: Cannot create app folder at " + folderPath);
                // TODO replace this with UI feedback
                System.exit(1);
            }
        }
    }

    private static void ensureFileExists(String filePath, String defaultFile) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            if (!file.createNewFile()) {
                System.out.println("ERROR: Cannot create configuration file at " + filePath);
                // TODO replace this with UI feedback
                System.exit(1);
            }

            InputStream defaultFileStream = null;
            OutputStream fileOutputStream = null;
            try {
                defaultFileStream = AppFolder.class.getResourceAsStream(defaultFile);
                fileOutputStream = new FileOutputStream(file);

                IOUtils.copy(defaultFileStream, fileOutputStream);
            } finally {
                if (defaultFileStream != null) {
                    defaultFileStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            }
        }
    }

}
