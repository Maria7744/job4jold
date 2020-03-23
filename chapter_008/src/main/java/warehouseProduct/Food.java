package warehouseProduct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Date;

public class Food implements ProgaWay {
    private static final Logger LOG = LogManager.getLogger(Food.class.getName());
    public warehouseProduct.Shop Shop;
    private String name;
    private final Date expaireDate;
    private  final Date createDate;
    private double price;
    private double disscount;
    public Food(String name, Date expaireDate, Date createDate, double price, double disscount) {
        this.name = name;
        this.expaireDate = expaireDate;
        this.createDate = createDate;
        this.price = price;
        this.disscount = disscount;
    }


    public Date getExpaireDate() {
        return expaireDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public double getDisscount() {
        return disscount;
    }

    public void setDisscount(double disscount) {
        this.disscount = disscount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

