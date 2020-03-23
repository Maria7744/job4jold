package warehouseProduct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Date;

public class Milk extends Food{
    private static final Logger LOG = LogManager.getLogger(Milk.class.getName());
    public Milk(String name, Date expaireDate, Date createDate, double price, double disscount) {
        super(name, expaireDate, createDate, price, disscount);
    }
}
