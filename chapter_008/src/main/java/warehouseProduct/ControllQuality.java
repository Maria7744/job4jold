package warehouseProduct;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
public class ControllQuality {
    private static final Logger LOG = LogManager.getLogger(ControllQuality.class.getName());

    private Set<StorageProduct> listStorage;
    private LinkedList<Food> base = new LinkedList<>();
    ControllQuality(Set<StorageProduct> listStorage) {
        this.listStorage = listStorage;
    }



    public List<Food> prepareList() {
        List<Food> answer = new ArrayList<>();
        for (var e : listStorage) {
            while (e.hasNext()) {
                answer.add(e.get());
            }
        }
        return answer;
    }


    public void add(Food e) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        Date today = cal.getTime();
        double check = ((double) (e.getCreateDate().getTime() - today.getTime()))
                / ((double) (e.getCreateDate().getTime() - e.getExpaireDate().getTime()));
        for (var str : listStorage) {
            if (str.accept(check)) {
                if (check > 0.75 && check < 1.0) {
                    e.setDisscount(check);
                }
                else if (check<0.75 && check>0.25){
                    e.Shop.push( check);

                }else
                str.push(e);
            }
        }
    }

    public void addAll(List<Food> list) {
        for (var e : list) {
            add(e);
        }
    }


    public void resort() {
        List<Food> tempList = prepareList();
        addAll(tempList);
    }
}

