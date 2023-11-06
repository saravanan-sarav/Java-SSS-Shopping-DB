package MainPackage.view;

import MainPackage.controller.OrderController;
import MainPackage.models.CartProduct;
import MainPackage.models.Product;
import MainPackage.utils.StringUtils;

import java.util.ArrayList;

import static MainPackage.utils.Utils.print;
import static MainPackage.utils.Utils.println;

public class CartView {
    private ProductView productView;
    private ArrayList<Product> tempProduct = new ArrayList<>();

    public CartView() {
        productView = new ProductView();
    }

    public void cartGreet() {
        println(StringUtils.SEPERATOR);
        println(StringUtils.CART_GREET);
        println(StringUtils.SEPERATOR);
    }

    public void showProductInCart(Long actualProductId, ArrayList<Product> products) {
        for (Product product : products) {
            if (actualProductId == product.getId()) {
                tempProduct.add(product);
            }
        }
        println(StringUtils.SEPERATOR);
        println(StringUtils.CART_SELECTED);
        productView.productDisplay(tempProduct);
        println(StringUtils.SEPERATOR);


    }

    public void cartPrint(ArrayList<CartProduct> tempCartProduct) {
        int titleLength = 0;
        int descriptionLength = 0;
        for (CartProduct cartProduct : tempCartProduct) {
            if (titleLength < cartProduct.getProduct().getTitle().length()) {
                titleLength = cartProduct.getProduct().getTitle().length();
            }
        }
        for (CartProduct cartProduct : tempCartProduct) {
            if (descriptionLength < cartProduct.getProduct().getDescription().length()) {
                descriptionLength = cartProduct.getProduct().getDescription().length();
            }
        }
        print("id\t");
        print("Product");
        for (int j = 0; j <= titleLength - 6; j++) {
            System.out.print(" ");
        }
        print("Price\t");
        print("Quantity\t\t");
        print("Total\n");
        for (CartProduct cartProduct : tempCartProduct) {
            print(String.valueOf(cartProduct.getProduct().getId()) + "\t");
            print(cartProduct.getProduct().getTitle());

            for (int j = 0; j <= titleLength - cartProduct.getProduct().getTitle().length(); j++) {
                System.out.print(" ");
            }

            print("\t" + String.valueOf(cartProduct.getProduct().getPrice()) + "\t\t");
            print(String.valueOf(cartProduct.getCount()) + "\t");
            for (int j = 0; j <= 7; j++) {
                System.out.print(" ");
            }
            print(String.valueOf((cartProduct.getCount()) * cartProduct.getProduct().getPrice()) + "\t");
            print("\n");

        }
    }

    public void cartEmpty() {
        println(StringUtils.SEPERATOR);
        println(StringUtils.CART_EMPTY);
        println(StringUtils.SEPERATOR);
    }
}
