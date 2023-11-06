package MainPackage.utils;

import MainPackage.models.Cart;
import MainPackage.models.Category;
import MainPackage.models.Orders;
import MainPackage.models.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MapUtils {
    public static Map<Integer, Long> categoryMap = new HashMap<>();
    public static Map<Integer, Long> categoryProductsMap = new HashMap<>();
    public static Map<Integer, Long> productsMap = new HashMap<>();
    public static Map<Integer, Long> cartMap = new HashMap<>();
    public static Map<Integer, Long> orderMap = new HashMap<>();

    public static Map<Integer, Long> getCategoryMap(ArrayList<Category> categoryList) {
        if (categoryMap != null) {
            categoryMap.clear();
        }
        int i = 1;
        for (Category category : categoryList) {
            categoryMap.put(i, category.getId());
            i++;
        }
        return categoryMap;
    }

    public static Map<Integer, Long> getCategoryProductsMap(ArrayList<Product> ProductList) {
        if (categoryProductsMap != null) {
            categoryProductsMap.clear();

        }
        int i = 1;
        for (Product product : ProductList) {
            categoryProductsMap.put(i, product.getId());
            i++;
        }
        return categoryProductsMap;
    }

    public static Map<Integer, Long> getProductsMap(ArrayList<Product> ProductList) {
        if (productsMap != null) {
            productsMap.clear();

        }
        int i = 1;
        for (Product product : ProductList) {
            productsMap.put(i, product.getId());
            i++;
        }
        return productsMap;
    }

    public static Map<Integer, Long> getCartMap(ArrayList<Cart> cartList) {
        if(cartMap!=null){
            cartMap.clear();

        }
        int i = 1;
        for (Cart cart : cartList) {
            cartMap.put(i, cart.getId());
            i++;
        }
        return cartMap;
    }

    public static Map<Integer, Long> getOrderMap(ArrayList<Orders> orderList) {
        if(orderMap!=null){
            orderMap.clear();
        }
        int i = 1;
        for (Orders order : orderList) {
            orderMap.put(i, order.getId());
            i++;
        }
        return orderMap;
    }


}
