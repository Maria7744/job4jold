package design.srp;

import java.util.function.Predicate;


public class ReportEngineJoson implements Reports{
    private Store store;
    public ReportEngineJoson(Store store) {
        this.store = store;
    }
    public String generate(Predicate<Employer> filter) {
        StringBuilder answer = new StringBuilder()
                .append("{ \"name\":\"John\", \"Hired\":30, \"Fired\":67,\"Salary\":56 }").append
                        (System.lineSeparator());


        for (var worker : store.findBy(filter)) {
            answer.append(" {").append(System.lineSeparator())
                    .append("{").append(worker.getName()).append("<}").append(System.lineSeparator())
                    .append("{ \"name\":\"John\", \"Hired\":35, \"Fired\":67,\"Salary\":" +
                            "56 }").append(worker.getHired()).append("}").append(System.lineSeparator());


        }
        return answer.toString();
    }


}

