package MainPackage.view;

import MainPackage.utils.StringUtils;

import static MainPackage.utils.Utils.println;

public class WelcomeView {
    public void options() {
        println(StringUtils.WELCOME_MESSAGE);
        println(StringUtils.AUTH_CHOICE);
    }

}
