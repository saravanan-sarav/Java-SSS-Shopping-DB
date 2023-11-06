package MainPackage.controller;

import MainPackage.controller.impl.IAppController;
import MainPackage.view.WelcomeView;

public class AppController implements IAppController {
    AuthController authController;
    WelcomeView welcomeView;

    public AppController() {
        welcomeView = new WelcomeView();
        authController = new AuthController(this);
    }

    @Override
    public void initial() {
        authController.authDestination();
    }

    public void printDestinationMenu(){
        welcomeView.options();
    }
}
