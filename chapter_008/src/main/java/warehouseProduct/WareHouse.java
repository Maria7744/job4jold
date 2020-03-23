package warehouseProduct;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
public class WareHouse implements StorageProduct {
        private static final Logger LOG = LogManager.getLogger(WareHouse.class.getName());
        /**
         * inner list for keeping T objects
         */
        private LinkedList<Food> base = new LinkedList<>();


        @Override
        public Food get() {
            return base.pollLast();
        }

    @Override
    public void push(Food t) {

    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public boolean accept(double dbl) {
        return  dbl > 0.75 ;
    }


    public void push(double check) {
    }
}
