package MainPackage.models;

public class Product {
    private long id;
    private String title;
    private String description;
    private Double price;
    private int stocks;
    private Category category;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        if (price <=0) {
            throw new RuntimeException("Price Can't be 0.");
        }else {
            this.price = price;
        }
    }

    public int getStocks() {
        return stocks;
    }

    public void setStocks(int stocks) {
        this.stocks = stocks;
    }

    public Category getCatogory() {
        return category;
    }

    public void setCatogory(Category category) {
        this.category = category;
    }
}
