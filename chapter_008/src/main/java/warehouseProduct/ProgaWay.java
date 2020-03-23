package warehouseProduct;

import java.util.Date;

public interface ProgaWay {
    void setName(String name);

    void setPrice(double price);

    void setDisscount(double disscount);

    Date getCreateDate();

    String getName();

    Date getExpaireDate();

    double getPrice();

    double getDisscount();


}


