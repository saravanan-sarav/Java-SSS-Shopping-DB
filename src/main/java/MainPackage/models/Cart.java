package MainPackage.models;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Cart {
    private long id;
    private ArrayList<CartProduct> cartProducts;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ArrayList<CartProduct> getCartProducts() {
        return cartProducts;
    }

    public void setCartProducts(ArrayList<CartProduct> cartProducts) {
        this.cartProducts = cartProducts;
    }


}
