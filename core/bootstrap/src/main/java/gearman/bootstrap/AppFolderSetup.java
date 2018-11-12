package gearman.bootstrap;

import gearman.commons.AppPaths;
import org.apache.commons.io.IOUtils;

import java.io.*;

public class AppFolderSetup {

    public void init() throws Exception {
        ensureFolderExists(AppPaths.ROOT_FOLDER);
        ensureFolderExists(AppPaths.MODULES_FOLDER);
        ensureFolderExists(AppPaths.LOGGING_FOLDER);
        ensureFileExists(AppPaths.MODULES_CONFIG_FILE, "/default-config/default-modules.xml");
        ensureFileExists(AppPaths.LOGGING_CONFIG_FILE, "/default-config/default-logging.xml");
        ensureFileExists(AppPaths.APP_CONFIG_FILE, "/default-config/default-config.xml");
    }

    // ----------------------------------------------------------------------------------------------------

    private void ensureFolderExists(String folderPath) {
        File folder = new File(folderPath);
        if (!folder.exists()) {
            if (!folder.mkdirs()) {
                System.out.println("ERROR: Cannot create app folder at " + folderPath);
                // TODO replace this with UI feedback
                System.exit(1);
            }
        }
    }

    private void ensureFileExists(String filePath, String defaultFile) throws IOException {
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
                defaultFileStream = this.getClass().getResourceAsStream(defaultFile);
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
