package MainPackage.controller.impl;

import MainPackage.models.Product;

import java.util.ArrayList;
import java.util.Map;

public interface ICartController {
    public void cartMenu();

    void addToCart(Map<Integer,Long> a, ArrayList<Product> b);
}
