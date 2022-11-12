import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main3 {
    public static void main(String[] args) throws IOException {
        String testsFile = "tests.json";
        String valuesFile = "values.json";
        String reportFile = "report.json";
        if (args.length >= 2) {
            testsFile = args[0];
            valuesFile = args[1];
        }
        if (args.length >= 3) {
            reportFile = args[2];
        }

        BufferedReader tr = new BufferedReader(new FileReader(testsFile));
        Tests tests = Tests.parse(tr);
        tr.close();

        BufferedReader vls = new BufferedReader(new FileReader(valuesFile));
        Values values = Values.parse(vls);
        vls.close();

        updateReport(tests, values);

        BufferedWriter report = new BufferedWriter(new FileWriter(reportFile));
        tests.serialize(report);
        report.close();
    }

    static void updateReport(Tests tests, Values values) {
        Map<Integer, String> map = new HashMap<>();
        for (Value v : values.getValues()) {
            map.put(v.getId(), v.getValue());
        }
        travers(tests, map);
    }

    static void travers(Tests tests, Map<Integer, String> map) {
        Stack<Test> stack = new Stack<>();
        for (Test test : tests.getTests()) {
            stack.push(test);
        }

        while (!stack.isEmpty()) {
            Test t = stack.pop();
            if (t.getValue() != null) {
                String status = map.get(t.getId());
                if (status == null) {
                    throw new RuntimeException("can't find status for test=" + t.getId());
                }
                t.setValue(map.get(t.getId()));
            }

            if (t.getValues() == null) {
                continue;
            }

            for (Test test : t.getValues()) {
                stack.push(test);
            }
        }
    }
}
