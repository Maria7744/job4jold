package warehouseProduct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Shop extends  WareHouse{
    private static final Logger LOG = LogManager.getLogger(Shop.class.getName());


    @Override
    public void push(Food t) {

        super.push(t);
    }

    @Override
    public boolean accept(double dbl) {
        return dbl > 0.25 && dbl < 1.0;
    }
}

