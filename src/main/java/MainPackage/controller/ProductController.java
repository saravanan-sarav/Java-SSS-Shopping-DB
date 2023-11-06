package MainPackage.controller;

import MainPackage.controller.impl.IProductController;
import MainPackage.models.Product;
import MainPackage.utils.AppException;
import MainPackage.utils.MapUtils;
import MainPackage.utils.StringUtils;
import MainPackage.view.ProductView;
import com.sun.net.httpserver.Authenticator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static MainPackage.utils.LoadUtils.getProducts;
import static MainPackage.utils.Utils.println;

public class ProductController implements IProductController {
    private ArrayList<Product> products = new ArrayList<>();
    private Map<Integer,Long> productsMap = new HashMap<>();
    private static long categoryId = 0;
    private static CategoryController categoryController;
    private static ProductView productView;
    private static CartController cartController;


    public ProductController(CategoryController categoryController) {
        this.categoryController = categoryController;
        productView = new ProductView();
        cartController = new CartController(this);
    }

    public ProductController() {
        productView = new ProductView();
        cartController = new CartController(this);
    }
    @Override
    public void productMenu() {
        products = getProducts();
        if(categoryId!=0){
            ArrayList<Product> UpdatedProducts = new ArrayList<>();
            int flag = 0;
            for (Product product:products){
                if(product.getCatogory().getId()==categoryId){
                    UpdatedProducts.add(product);
                    flag = 1;
                }
            }
            if(flag==1){
                products=UpdatedProducts;
                this.productsMap = MapUtils.getCategoryProductsMap(products);
                productView.productListInit(products);
                cartController.addToCart(productsMap,products);

            }else {
                productView.productNotFound();
                categoryController.catogoryMenu();
            }
        }else{
            productsMap = MapUtils.getProductsMap(products);
            productView.productListInit(products);
            cartController.addToCart(productsMap,products);
            }
        }
    @Override
    public void setcategoryId(long categoryId) {
        this.categoryId = categoryId;
    }


}
