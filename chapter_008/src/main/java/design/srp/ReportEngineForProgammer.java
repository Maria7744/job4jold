package design.srp;

import java.util.function.Predicate;

public class ReportEngineForProgammer implements Reports{
    private Store store;
    public ReportEngineForProgammer(Store store) {
        this.store = store;
    }
    public String generate(Predicate<Employer> filter) {
        StringBuilder answer = new StringBuilder()
                .append("<!DOCTYPE>").append(System.lineSeparator())
                .append("<head>").append(System.lineSeparator())
                .append("<title>  Report for Programmer</title>").append(System.lineSeparator())
                .append("</head>").append(System.lineSeparator())
                .append("<body>").append(System.lineSeparator())
                .append("<table \"reportTable\">").append(System.lineSeparator())
                .append("<tr>").append(System.lineSeparator())
                .append("<th> Name </th>").append(System.lineSeparator())
                .append("<th> Hired </th>").append(System.lineSeparator())
                .append("<th> Fired </th>").append(System.lineSeparator())
                .append("<th> Salary </th>").append(System.lineSeparator())
                .append("</tr>").append(System.lineSeparator());
        for (var worker : store.findBy(filter)) {
            answer.append("<tr>").append(System.lineSeparator())
                    .append("<td =\"name\"><a>").append(worker.getName()).append("</a>").append(System.lineSeparator())
                    .append("<td  =\"hired\"><a>").append(worker.getHired()).append("</a>").append(System.lineSeparator())
                    .append("<td  =\"fired\"><a>").append(worker.getFired()).append("</a>").append(System.lineSeparator())
                    .append("<td  =\"salary\"><a>").append(worker.getSalary()).append("</a>").append(System.lineSeparator())
                    .append("</tr>").append(System.lineSeparator())
             .append("</body>").append(System.lineSeparator());
        }
        return answer.toString();
    }


}
