package ru.job4j.design.srp;
/*
 * Chapter_009. OOD [#143].
 * Task: 1. Отчеты. [#850].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 1.
 */
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.Calendar;

/**
 * Report tests.
 */
public class ReportEngineTest {

    /**
     * Old report test.
     */
    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    /**
     * Test report for HR.
     */
    @Test
    public void whenGeneratedForHR() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker2 = new Employee("Ivan2", now, now, 102);
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker2);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getSalary()).append(";");
        assertThat(engine.generateForHR(em -> true), is(expect.toString()));
    }

    /**
     * Test report for Developers.
     */
    @Test
    public void whenGeneratedForDeveloper() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("<html><head></head><body>")
                .append("<div>").append(worker.getName()).append("</div>")
                .append("<div>").append(worker.getHired()).append("</div>")
                .append("<div>").append(worker.getFired()).append("</div>")
                .append("<div>").append(worker.getSalary()).append("</div>")
                .append("</body><html>");
        assertThat(engine.generateForDeveloper(em -> true), is(expect.toString()));
    }

    /**
     * Test report for Accounting.
     */
    @Test
    public void whenGeneratedForAccounting() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; OtherSalary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";");
        assertThat(engine.generateForAccounting(em -> true), is(expect.toString()));
    }
}
