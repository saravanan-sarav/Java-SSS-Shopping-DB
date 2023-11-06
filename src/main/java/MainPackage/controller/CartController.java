package MainPackage.controller;

import MainPackage.controller.impl.ICartController;
import MainPackage.models.Cart;
import MainPackage.models.CartProduct;
import MainPackage.models.Product;
import MainPackage.utils.AppException;
import MainPackage.utils.CartLoadUtils;
import MainPackage.utils.LoggedInUser;
import MainPackage.utils.StringUtils;
import MainPackage.view.CartView;

import java.util.ArrayList;
import java.util.Map;

import static MainPackage.utils.AppInput.enterInt;
import static MainPackage.utils.Utils.println;

public class CartController implements ICartController {
    OrderController orderController;
    public CartController() {
        cartView = new CartView();
        orderController = new OrderController();

    }

    private Long actualProductId;

    private static CartView cartView;
    private ProductController productController;
    private ArrayList<Cart> cart;

    public CartController(ProductController productController) {
        cartView = new CartView();
        cart = new ArrayList<>();
        orderController = new OrderController();
        this.productController = productController;
    }

    public void cartMenu() {
        cart = CartLoadUtils.getUserCart(LoggedInUser.getLoggedInUser());
        ArrayList<CartProduct> tempCartProduct = new ArrayList<>();
        for (Cart cartload : cart) {
            for (CartProduct cartProduct : cartload.getCartProducts()) {
                tempCartProduct.add(cartProduct);
            }
        }
        if(tempCartProduct.size()>0){
            cartView.cartPrint(tempCartProduct);
            orderController.checkoutMenu(LoggedInUser.getLoggedInUser(),tempCartProduct);
        }else {
            cartView.cartEmpty();
            HomeController.homeMenu();
        }

    }

    @Override
    public void addToCart(Map<Integer, Long> productMap, ArrayList<Product> product) {
        cartView.cartGreet();

        boolean flag = false;
        try {
            int choice = enterInt(StringUtils.CART_CHOICE);
            for (int j : productMap.keySet()) {
                if (choice == j) {
                    actualProductId = productMap.get(j);
                    flag = true;
                }
            }
            if (flag == true) {
                cartView.showProductInCart(actualProductId, product);
                int count = enterInt(StringUtils.CART_COUNT);
                Cart tempCart =  LoggedInUser.getLoggedInUser().getCart();


            } else {
                invalidChoice(new AppException(StringUtils.ERROR_MESSAGE));
            }

        } catch (AppException e) {
            throw new RuntimeException(e);
        }
    }

    private void invalidChoice(AppException e) {
        println(StringUtils.SEPERATOR);
        println(e.getMessage());
        println(StringUtils.SEPERATOR);
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        productController.productMenu();
    }
}
