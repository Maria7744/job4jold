package design.srp;

import java.util.function.Predicate;

public class ReportEngineHml implements Reports{

    private Store store;
    public ReportEngineHml(Store store) {
        this.store = store;
    }
    public String generate(Predicate<Employer> filter) {
        StringBuilder answer = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>").append(System.lineSeparator())
                .append("<company>").append(System.lineSeparator())
                .append("<name>Report </name>").append(System.lineSeparator())
                .append("<offices>").append(System.lineSeparator())
                .append("<office floor=\"1\" room=\"1\">").append(System.lineSeparator())
                .append(" <employees>").append(System.lineSeparator())
                .append("<employee name=\"Maksim\" Hired=\"4\" Fired=\"6\" " +
                        "Salary=\"$\">").append(System.lineSeparator())

                .append("</employee>").append(System.lineSeparator())
                .append("  </employees>").append(System.lineSeparator())
                .append("   </office>").append(System.lineSeparator())
                .append("</company>").append(System.lineSeparator());

        for (var worker : store.findBy(filter)) {
            answer.append(" <company>").append(System.lineSeparator())
                    .append("employees").append(worker.getName()).append("<employee>").append(System.lineSeparator())
                    .append("<employee name=\"Maksim\\\" Hired=\\\"4\\\" Fired=\\\"6\\\" Salary=\\\"$\\\">\">").append(worker.getHired()).append("</a>").append(System.lineSeparator())

                    .append("</office>").append(System.lineSeparator())
                    .append("</company>").append(System.lineSeparator());
        }
        return answer.toString();
    }


}