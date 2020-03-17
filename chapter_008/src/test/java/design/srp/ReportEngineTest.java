package design.srp;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;

public class ReportEngineTest {

   @Test
    public void whenGeneratedReportEngine() {
       MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer worker = new Employer("Olla", now, now, 100);
        store.add(worker);
        Reports engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        Assert.assertEquals(expect.toString(), engine.generate(em -> true));
    }

    @Test
    public void whenGeneretedForProgrammersWithHTML() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer workOne = new Employer("Olla", now, now, 100);
        Employer workTwo = new Employer("Anna", now, now, 50);
        store.add(workOne);
        store.add(workTwo);
        Reports engine = new ReportEngineForProgammer(store);
        StringBuilder expect = new StringBuilder()
                .append("<head>").append(System.lineSeparator())
                .append("<title>  Report for Programmer</title>").append(System.lineSeparator())
                .append("</head>").append(System.lineSeparator())
                .append("<body>").append(System.lineSeparator())
                .append("<table class= \"reportTable\">").append(System.lineSeparator())
                .append("<tr>").append(System.lineSeparator())
                .append("<th> Name </th>").append(System.lineSeparator())
                .append("<th> Hired </th>").append(System.lineSeparator())
                .append("<th> Fired </th>").append(System.lineSeparator())
                .append("<th> Salary </th>").append(System.lineSeparator())
                .append("</tr>").append(System.lineSeparator())
                .append("<tr>").append(System.lineSeparator())
                .append("<td  =\"name\"><a>").append(workOne.getName()).append("</a>").append(System.lineSeparator())
                .append("<td  =\"hired\"><a>").append(workOne.getHired()).append("</a>").append(System.lineSeparator())
                .append("<td  =\"fired\"><a>").append(workOne.getFired()).append("</a>").append(System.lineSeparator())
                .append("<td  =\"salary\"><a>").append(workOne.getSalary()).append("</a>").append(System.lineSeparator())
                .append("</tr>").append(System.lineSeparator())
                .append("<tr>").append(System.lineSeparator())
                .append("<td =\"name\"><a>").append(workTwo.getName()).append("</a>").append(System.lineSeparator())
                .append("<td  =\"hired\"><a>").append(workTwo.getHired()).append("</a>").append(System.lineSeparator())
                .append("<td  =\"fired\"><a>").append(workTwo.getFired()).append("</a>").append(System.lineSeparator())
                .append("<td  =\"salary\"><a>").append(workTwo.getSalary()).append("</a>").append(System.lineSeparator())
                .append("</tr>").append(System.lineSeparator())
        .append("</body>").append(System.lineSeparator());
        Assert.assertEquals(expect.toString(), engine.generate(em -> true));
    }

    @Test
    public void whenGeneretedForAccountingsAnotherSalaryFormat() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer workOne = new Employer("Ivan", now, now, 100);
        Employer workTwo = new Employer("Anna", now, now, 50);
        store.add(workOne);
        store.add(workTwo);
        Reports engine =  new ReportEngineForAccounting(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(workOne.getName()).append(";")
                .append(workOne.getHired()).append(";")
                .append(workOne.getFired()).append(";")
                .append(String.format("|%100a|", workOne.getSalary())).append(";")
                .append(System.lineSeparator())
                .append(workTwo.getName()).append(";")
                .append(workTwo.getHired()).append(";")
                .append(workTwo.getFired()).append(";")
                .append(String.format("|%10.00|", workTwo.getSalary())).append(";")
                .append(System.lineSeparator());
        Assert.assertEquals(expect.toString(), engine.generate(em -> true));
    }

    @Test
    public void whenGeneretedForHR() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer workOne = new Employer("Petr", now, now, 100);
        Employer workTwo = new Employer("Seva", now, now, 50);
        store.add(workTwo);
        store.add(workOne);
        Reports engine = new HRReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;").append(System.lineSeparator())
                .append(workOne.getName()).append(";")
                .append(workOne.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(workTwo.getName()).append(";")
                .append(workTwo.getSalary()).append(";")
                .append(System.lineSeparator());
        Assert.assertEquals(expect.toString(), engine.generate(em -> true));
    }
}

