package MainPackage.controller;

import MainPackage.controller.impl.IAuthController;
import MainPackage.models.User;
import MainPackage.utils.*;
import MainPackage.view.HomeView;
import MainPackage.view.LoginView;
import MainPackage.view.RegistrationView;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static MainPackage.utils.AppInput.enterInt;
import static MainPackage.utils.AppInput.enterString;
import static MainPackage.utils.AppScanner.getFileScanner;
import static MainPackage.utils.Utils.println;

public class AuthController implements IAuthController {
    private final AppController appController;
    private LoginView loginView;
    private RegistrationView registrationView;
    private HomeController homeController;
    private LoggedInUser loggedInUser;
    User user = new User();


    public AuthController(AppController appController) {
        this.appController = appController;

    }

    public void authDestination() {
        appController.printDestinationMenu();
        int choice;
        try {
            choice = enterInt(StringUtils.CHOICE_SELECT);
            if (choice == 1) {
                login();
            } else if (choice == 2) {
                register();
            } else if (choice==99) {
                System.exit(0);
            } else {
                Thread.sleep(500);
                invalid(new AppException(StringUtils.ERROR_MESSAGE));
            }
        } catch (AppException appException) {
            try {
                Thread.sleep(500);
                invalid(appException);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private void invalid(AppException e) {
        println(e.getMessage());
        authDestination();

    }

    @Override
    public void login() {
        try {
            Thread.sleep(500);
            this.loginView = new LoginView();
            loginView.loginMenu();
            String email = enterString(StringUtils.ENTER_EMAIL);
            String password = enterString(StringUtils.ENTER_PASSWORD);

            User validUser = isValidUser(email, password);

            if (validUser != null) {
                LoggedInUser.setLoggedInUser(validUser);
                User user = LoggedInUser.getLoggedInUser();
                System.out.println(user.getEmail());
                homeController = new HomeController(this);
                homeController.homeMenu();
            } else {
                loginView.invalidCredetials();
                authDestination();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    public User isValidUser(String email, String password) {
        Scanner fileData = getFileScanner(FileUtils.getCredentials());
        while (fileData.hasNext()) {
            String value = fileData.next();
            if (!value.startsWith("id")) {
                String[] tempLogin = value.split(",");
                if (tempLogin[2].equalsIgnoreCase(email) && tempLogin[3].equalsIgnoreCase(password)) {
                    user = new User();
                    user.setId(Long.parseLong(tempLogin[0]));
                    user.setEmail(email);
                    user.setPassword(password);
                    user.setUserName(tempLogin[1]);
                    return user;
                }
            }
        }
        return null;
    }

    @Override
    public void register() throws IOException {
        long id;
        String name, email, password, confirmPassword;
        registrationView = new RegistrationView();
        try {
            Thread.sleep(500);
            registrationView.registrationIntro();
            id = IdUtil.IdGenerator();
            name = enterString(StringUtils.REGISTER_NAME);
            email = enterString(StringUtils.REGISTER_EMAIL);
            password = enterString(StringUtils.REGGISTER_PASSWORD);
            confirmPassword = enterString(StringUtils.REGISTER_CONFIRMPASSWORD);

            if (password.equalsIgnoreCase(confirmPassword)) {
                FileWriter writeFile = FileUtils.writeFile(FileUtils.getCredentials());
                writeFile.append("\n");
                writeFile.append(id + "," + name + "," + email + "," + password);
                writeFile.flush();
                writeFile.close();
                RegistrationView.registerSuccess();
                authDestination();
            } else {
                RegistrationView.passWordInvalid();
                try {
                    Thread.sleep(500);
                    register();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void logout() {

    }
}
