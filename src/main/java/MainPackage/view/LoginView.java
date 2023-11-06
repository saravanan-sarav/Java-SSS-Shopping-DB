package MainPackage.view;

import MainPackage.utils.StringUtils;

import static MainPackage.utils.Utils.println;

public class LoginView {
    public void loginMenu(){
        println(StringUtils.SEPERATOR);
        println(StringUtils.LOGIN_INTRO);
        println(StringUtils.SEPERATOR);
//        println(StringUtils.NEW_LINE);
    }

    public void invalidCredetials() {
        println(StringUtils.SEPERATOR);
        println(StringUtils.INVALID_CREDENTIAL);
        println(StringUtils.SEPERATOR);
    }
}
