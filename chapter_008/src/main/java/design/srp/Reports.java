package design.srp;

import java.util.function.Predicate;

public interface Reports {
    String generate(Predicate<Employer> filter);

}

