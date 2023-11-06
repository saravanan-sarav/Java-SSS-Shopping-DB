package MainPackage.view;

import MainPackage.models.Product;
import MainPackage.utils.StringUtils;

import java.util.ArrayList;

import static MainPackage.utils.Utils.print;
import static MainPackage.utils.Utils.println;

public class ProductView {
    public void productNotFound() {
        println(StringUtils.SEPERATOR);
        println(StringUtils.CATEGORY_PRODUCT_NOT_FOUND);
        println(StringUtils.SEPERATOR);
    }

    public void productListInit(ArrayList<Product> updatedProducts){
        println("Available Products..!!!");
        productDisplay(updatedProducts);
    }

    public void productDisplay(ArrayList<Product> updatedProducts) {
        int titleLength = 0;
        int descriptionLength = 0;
        for (Product product : updatedProducts) {
            if (titleLength < product.getTitle().length()) {
                titleLength = product.getTitle().length();
            }
        }
        for (Product product : updatedProducts) {
            if (descriptionLength < product.getDescription().length()) {
                descriptionLength = product.getDescription().length();
            }
        }
        print("id\t");
        print("Product");
        for (int j = 0; j <= titleLength-8; j++) {
            System.out.print(" ");
        }
        print("\tStock\t");
        print("Price\n");
        for (Product product : updatedProducts) {
            print(String.valueOf(product.getId()) + "\t");
            print(product.getTitle());
            for (int j = 0; j <= titleLength - product.getTitle().length(); j++) {
                System.out.print(" ");
            }
            print("\t"+String.valueOf(product.getStocks()) + "\t");
            print(String.valueOf(product.getPrice()) + "\t");
            print("\n");
        }
    }
}
