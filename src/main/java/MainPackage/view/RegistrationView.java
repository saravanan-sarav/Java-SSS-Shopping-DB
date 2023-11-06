package MainPackage.view;

import MainPackage.utils.StringUtils;

import static MainPackage.utils.Utils.println;

public class RegistrationView {
    public static void passWordInvalid() {
        println(StringUtils.SEPERATOR);
        println(StringUtils.PASSWORD_MISMATCH);
        println(StringUtils.REGISTER_AGAIN);
        println(StringUtils.SEPERATOR);
    }

    public static void registerSuccess() {
        println(StringUtils.SEPERATOR);
        println(StringUtils.REGISTRATION_SUCCESS);
        println(StringUtils.REGISTRATION_GREET);
        println(StringUtils.SEPERATOR);
    }

    public void registrationIntro() {
        println(StringUtils.SEPERATOR);
        println(StringUtils.REGISTRATION_INTRO);
        println(StringUtils.SEPERATOR);
    }


}
