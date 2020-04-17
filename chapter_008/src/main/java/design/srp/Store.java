package design.srp;

import javax.sql.rowset.Predicate;
import java.util.List;

public interface Store {

        List<Employer> findBy(Predicate<Employer> filter);
    }

