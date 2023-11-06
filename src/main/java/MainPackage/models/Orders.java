package MainPackage.models;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class Orders {
    private long id;
    private Date date;
     private ArrayList<Cart> cart;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<Cart> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Cart> cart) {
        this.cart = cart;
    }
}
