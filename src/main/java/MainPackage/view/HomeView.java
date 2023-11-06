package MainPackage.view;

import MainPackage.utils.StringUtils;

import static MainPackage.utils.Utils.println;

public class HomeView {
    public void homeMenuList() {
        println(StringUtils.SEPERATOR);
        println(StringUtils.HOMEPAGE_WECOME);
        println(StringUtils.SEPERATOR);
        println(StringUtils.PRODUCT_MENU);
    }

    public void logoutAlert() {
        println(StringUtils.SEPERATOR);
        println(StringUtils.LOGOUT_GREET);
        println(StringUtils.SEPERATOR);
    }
}
