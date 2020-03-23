package warehouseProduct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Date;

public class Potato extends Food {
    private static final Logger LOG = LogManager.getLogger(Potato.class.getName());

    public Potato(String name, Date expaireDate, Date createDate, double price, double disscount) {
        super(name, expaireDate, createDate, price, disscount);
    }


}

