package MainPackage.controller;

import MainPackage.controller.impl.IHomeController;
import MainPackage.utils.AppException;
import MainPackage.utils.LoadUtils;
import MainPackage.utils.StringUtils;
import MainPackage.view.HomeView;

import static MainPackage.utils.AppInput.enterInt;
import static MainPackage.utils.Utils.println;

public class HomeController implements IHomeController {
    private static HomeView homeView;
    private static AuthController authController;
    private static ProductController productController;
    private static CartController cartController;
    private static OrderController orderController;
    private static CategoryController categoryController;

    public HomeController(AuthController authController) {
        homeView = new HomeView();
        this.authController = authController;
        LoadUtils.loadCategories();
        LoadUtils.loadProducts();

    }

    public static void homeMenu() {
        homeView.homeMenuList();
        int choice = 0;
        try {
            choice = enterInt(StringUtils.CHOICE_SELECT);
            if (choice == 99) {
                homeView.logoutAlert();
                authController.authDestination();
            } else if (choice == 1) {
                categoryController = new CategoryController();
                categoryController.catogoryMenu();
            } else if (choice == 2) {
                productController = new ProductController();
                productController.productMenu();
            } else if (choice == 3) {
                cartController = new CartController();
                cartController.cartMenu();

            } else if (choice == 4) {
                orderController = new OrderController();
                orderController.orderMenu();
            } else {
                invalidChoice(new AppException(StringUtils.ERROR_MESSAGE));
            }
        } catch (AppException appException) {
            invalidChoice(appException);
        }
    }

    private static void invalidChoice(AppException appException) {
        println(appException.getMessage());
        homeMenu();
    }

}
