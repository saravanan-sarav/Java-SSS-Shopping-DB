package MainPackage.controller.impl;

import java.io.IOException;

public interface IAuthController {
    void login();
    void register() throws IOException;
    void logout();
    void authDestination() throws InterruptedException;
}
