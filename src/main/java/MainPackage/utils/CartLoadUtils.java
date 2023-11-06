package MainPackage.utils;

import MainPackage.models.Cart;
import MainPackage.models.User;

import java.util.ArrayList;

public class CartLoadUtils {

    private static ArrayList<Cart> userCart = new ArrayList<>();

    public static ArrayList<Cart> getUserCart(User user){
        userCart = LoadUtils.loadCart(user);
        return userCart;
    }
}
