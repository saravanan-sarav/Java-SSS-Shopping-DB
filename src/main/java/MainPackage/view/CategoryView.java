package MainPackage.view;

import MainPackage.models.Category;
import MainPackage.utils.StringUtils;

import java.util.ArrayList;

import static MainPackage.utils.Utils.println;

public class CategoryView {

    public static void CategoryView(ArrayList<Category> categories) {
        for (Category category:categories){
            println(category.getCatogoryName());
        }
    }

    public void catogoryGreet() {
        println(StringUtils.SEPERATOR);
        println(StringUtils.CATORGORY_GREET);
        println(StringUtils.SEPERATOR);
    }

    public void choicePrint() {
        println(StringUtils.CATEGORY_CHOICE);
    }

    public void seperator() {
        println(StringUtils.SEPERATOR);
    }
}
