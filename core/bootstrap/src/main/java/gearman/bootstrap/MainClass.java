package gearman.bootstrap;

public class MainClass {

    public static void main(String[] args) {
        try {
            new AppFolderSetup().init();
        } catch (Exception e) {
            System.out.println("ERROR: Cannot initialize the app config folder");
            e.printStackTrace();
        }
    }

}
