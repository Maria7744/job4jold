package design.srp;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HRReportEngine implements Reports{
    private Store store;

    public HRReportEngine(Store store) {
        this.store = store;
    }




    public String generate(Predicate<Employer> filter) {
        List<Employer> temp = store.findBy(filter).stream()
                .sorted((x, y) -> Double.compare(y.getSalary(), x.getSalary()))
                .collect(Collectors.toList());
        StringBuilder answer = new StringBuilder();
        answer.append("Name; Salary;");
        answer.append(System.lineSeparator());
        for (Employer employer : temp) {
            answer.append(employer.getName()).append(";")
                    .append(employer.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return answer.toString();
    }

}



