import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main4 {
    public static int min_Step(List<Integer> list) {
        if (list.size() <= 1) {
            return 0;
        }
        List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());
        int median = list.size() / 2;
        int number = sortedList.get(median);
        int countStep = 0;
        for (Integer i : sortedList) {
            int count = Math.abs(number - i);
            countStep += count;
        }
        return countStep;
    }

    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 1) {
            throw new RuntimeException("Expected <fil1> argument");
        }
        Scanner scanner = new Scanner(new File(args[0]));
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNext()) {
            list.add(scanner.nextInt());
        }
        scanner.close();
        System.out.println(min_Step(list));
    }
}
