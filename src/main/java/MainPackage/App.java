package MainPackage;

import MainPackage.controller.AppController;
import MainPackage.controller.HomeController;

public class App {
    public static void main(String[] args) {
        AppController appController = new AppController();
        appController.initial();
    }
}
