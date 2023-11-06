package MainPackage.utils;

import MainPackage.models.*;

import java.util.ArrayList;
import java.util.Scanner;

import static MainPackage.utils.AppScanner.getFileScanner;

public class LoadUtils {
    private static final ArrayList<Category> categories = new ArrayList<>();
    private static final ArrayList<Product> products = new ArrayList<>();
    private static final ArrayList<Cart> cart = new ArrayList<>();

    public static ArrayList<Category> getCategories() {
        return categories;
    }

    public static ArrayList<Product> getProducts() {
        return products;
    }

    public static void loadCategories() {
        Scanner categoryData = getFileScanner(FileUtils.getCategories());
        while (categoryData.hasNext()) {
            String value = categoryData.next();
            if (!value.startsWith("id")) {
                String[] tempValue = value.split(",");
                Category tempCatogory = new Category();
                tempCatogory.setId(Long.parseLong(tempValue[0]));
                tempCatogory.setCatogoryName(tempValue[1]);
                categories.add(tempCatogory);
            }
        }

    }

    public static void loadProducts() {
        Scanner productFile = getFileScanner(FileUtils.getProducts());
        while (productFile.hasNext()) {
            String value = productFile.next();
            if (!value.startsWith("id")) {
                String[] tempValue = value.split(",");
                Product tempProduct = new Product();
                tempProduct.setId(Long.parseLong(tempValue[0]));
                tempProduct.setTitle(tempValue[1]);
                tempProduct.setDescription(tempValue[2]);
                tempProduct.setPrice(Double.parseDouble(tempValue[3]));
                tempProduct.setStocks(Integer.parseInt(tempValue[4]));
                for (Category category : categories) {
                    if (category.getCatogoryName().equalsIgnoreCase(tempValue[5])) {
                        Category categorySetter = category;
                        tempProduct.setCatogory(categorySetter);
                    }
                }
                products.add(tempProduct);
            }

        }

    }

    public static ArrayList<Cart> loadCart(User currentUser) {
        Scanner cartFile = getFileScanner(FileUtils.getCart());
        ArrayList<CartProduct> cartArray = new ArrayList<>();
        ArrayList<Cart> userCart = new ArrayList<>();
        User user = currentUser;
        while (cartFile.hasNext()) {
            String value = cartFile.next();
            if (!value.startsWith("userId")) {
                String[] tempValue = value.split(",");
                if(user.getId()==Long.parseLong(tempValue[0])){

                    Product product = new Product();
                    product.setId(Long.parseLong(tempValue[2]));
                    product.setTitle(tempValue[3]);
                    product.setDescription(tempValue[4]);
                    product.setPrice(Double.parseDouble(tempValue[5]));

                    CartProduct cartStruct = new CartProduct();
                    cartStruct.setProduct(product);
                    cartStruct.setCount(Integer.parseInt(tempValue[6]));
                    cartArray.add(cartStruct);

                    Cart tempCart = new Cart();
                    tempCart.setId(user.getId());
                    tempCart.setCartProducts(cartArray);
                    userCart.add(tempCart);
                }

            }
        }
        return userCart;
    }
}