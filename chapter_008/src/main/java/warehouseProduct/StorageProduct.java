package warehouseProduct;

public interface StorageProduct {
    Food get();


    void push(Food t);


    boolean hasNext();


    boolean accept(double dbl);
}

