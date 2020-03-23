package warehouseProduct;

import org.apache.logging.log4j.core.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.assertEquals;


public class ControllQualityTest {

    private StorageProduct warehouse = new WareHouse();
    private StorageProduct shop = new Shop();
    private StorageProduct trash = new Trash();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    private Date creation;
    private Date expairation;


    @Before
    public void beforeAct() throws ParseException, java.text.ParseException {
        creation = dateFormat.parse("15.09.2019");
        expairation = dateFormat.parse("25.05.2020");
        shop.push(new Potato("Potato", "15.09.2019", "25.05.2020", 100, 0));
        creation = dateFormat.parse("29.02.2020");
        expairation = dateFormat.parse("25.03.2020");
        shop.push(new Milk("Milk", "29.02.2020", "25.03.2020", 100, 0));
    }

    @Test
    public void test() throws ParseException {
        Set<StorageProduct> act = new HashSet<StorageProduct>(Set.of(warehouse, shop, trash));
        ControllQuality qual = new ControllQuality(act);
        List<Food> temp = new ArrayList<>();
        temp = qual.prepareList();
        qual.addAll(temp);
        qual.resort();
        assertEquals("Potato", trash.get().getName());
        assertEquals("Milk", warehouse.get().getName());

    }
}

