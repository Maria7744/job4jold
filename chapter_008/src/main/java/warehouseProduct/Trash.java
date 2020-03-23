package warehouseProduct;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Trash extends WareHouse {
    private static final Logger LOG = LogManager.getLogger(Trash.class.getName());

    @Override
    public boolean accept(double dbl) {
        return dbl >= 1;
    }
}

