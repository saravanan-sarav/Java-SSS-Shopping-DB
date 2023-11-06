package MainPackage.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {

    public static File credentials;
    public static FileWriter fileWriter;

    public static File categories;
    public static File products;
    public static File carts;


    public static File getCredentials(){
        if(credentials==null){
            credentials = new File("src/main/java/MainPackage/assets/credentials.csv");
        }
        return credentials;
    }

    public static FileWriter writeFile(File file) throws IOException {
        if(fileWriter==null){
            fileWriter = new FileWriter(file,true);
        }
        return fileWriter;
    }
    public static File getCategories(){
        if(categories==null){
            categories = new File("src/main/java/MainPackage/assets/catogories.csv");
        }
        return categories;
    }

    public static File getProducts(){
        if(products==null){
            products = new File("src/main/java/MainPackage/assets/products.csv");
        }
        return products;
    }

    public static File getCart(){
        if(carts==null){
            carts = new File("src/main/java/MainPackage/assets/carts.csv");
        }
        return carts;
    }


}
