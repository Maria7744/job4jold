package warehouseProduct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Date;

public class Meat extends Food{
    private static final Logger LOG = LogManager.getLogger(Meat.class.getName());

    public Meat(String name, Date expaireDate, Date createDate, double price, double disscount) {
        super(name, expaireDate, createDate, price, disscount);
    }
}
