package MainPackage.controller;

import MainPackage.controller.impl.IOrderController;
import MainPackage.models.CartProduct;
import MainPackage.models.Orders;
import MainPackage.models.User;
import MainPackage.utils.Utils;

import java.util.ArrayList;


public class OrderController implements IOrderController {
    ArrayList<Orders> userOrders = new ArrayList<>();
    public void orderMenu() {
        Utils.println("Orders");
    }

    @Override
    public void checkoutMenu(User user, ArrayList<CartProduct> cartProducts) {

    }
}
