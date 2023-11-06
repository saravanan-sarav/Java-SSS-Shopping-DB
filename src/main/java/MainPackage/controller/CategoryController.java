package MainPackage.controller;

import MainPackage.models.Category;
import MainPackage.utils.AppException;
import MainPackage.utils.MapUtils;
import MainPackage.utils.StringUtils;
import MainPackage.view.CategoryView;

import java.util.ArrayList;
import java.util.Map;

import static MainPackage.utils.AppInput.enterInt;
import static MainPackage.utils.LoadUtils.getCategories;
import static MainPackage.utils.Utils.println;

public class CategoryController{
    private  Map<Integer, Long> categoryMap;

    private CategoryView categoryView;
    private ArrayList<Category> categories = getCategories();
    private ProductController productController;

    public CategoryController() {
        categoryView = new CategoryView();
        productController = new ProductController(this);

    }

    public void catogoryMenu() {
        categoryView.catogoryGreet();
        int i = 1;
        this.categoryMap = MapUtils.getCategoryMap(categories);
        long categoryId = 0;
        try {
            CategoryView.CategoryView(categories);
            int choice = enterInt(StringUtils.CHOICE_SELECT);
            if (choice <= categoryMap.size()) {
                for (int j : categoryMap.keySet()) {
                    if (choice == j) {
                        categoryId = categoryMap.get(j);
                    }
                }
            } else {
                invalidChoice(new AppException(StringUtils.ERROR_MESSAGE));
            }
            productController.setcategoryId(categoryId);
            categoryMap.clear();
            productController.productMenu();
        } catch (AppException e) {
            invalidChoice(e);
        }


    }

    private void invalidChoice(AppException e) {
        categoryView.seperator();
        println(e.getMessage());
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        catogoryMenu();
    }
}