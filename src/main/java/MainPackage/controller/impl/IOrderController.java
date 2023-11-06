package MainPackage.controller.impl;

import MainPackage.models.CartProduct;
import MainPackage.models.User;

import java.util.ArrayList;

public interface IOrderController {
    public void orderMenu();

    void checkoutMenu(User user, ArrayList<CartProduct> cartProduct);
}
