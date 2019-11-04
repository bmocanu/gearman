package ws.gearman.app;

import ws.gearman.app.setup.AppFolder;
import ws.gearman.app.setup.Logging;

public class MainClass {

    public static void main(String[] args) throws Exception {
        Logging.init();
        AppFolder.init();
    }

}
