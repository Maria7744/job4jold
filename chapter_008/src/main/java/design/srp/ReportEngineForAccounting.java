package design.srp;
import java.util.function.Predicate;
public class ReportEngineForAccounting implements Reports{


        private Store store;


        public ReportEngineForAccounting(Store store) {
            this.store = store;
        }



    public String generate(Predicate<Employer> filter) {
            StringBuilder text = new StringBuilder();
            text.append("Name; Hired; Fired; Salary;");
            text.append(System.lineSeparator());
            for (Employer worker : store.findBy(filter)) {
                text.append(worker.getName()).append(";")
                        .append(worker.getHired()).append(";")
                        .append(worker.getFired()).append(";")
                        .append(String.format("|%10a|", worker.getSalary())).append(";")
                        .append(System.lineSeparator());
            }
            return text.toString();
        }
    }

