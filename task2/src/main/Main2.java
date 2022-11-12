import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main2 {
    public static int point_in_circle(float pointX, float pointY, float centerX, float centerY, float radius) {
        float diff = ((pointX - centerX) * (pointX - centerX)) + ((pointY - centerY) * (pointY - centerY));
        float radius2 = radius * radius;
        if (diff > radius2) {
            return 2;
        }
        if (diff < radius2) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 2) {
            throw new RuntimeException("Expected <fil1> <file2> arguments");
        }

        String file1 = args[0];
        Scanner scanner1 = new Scanner(new File(file1));

        float centerX = scanner1.nextFloat();
        float centerY = scanner1.nextFloat();
        float radius = scanner1.nextFloat();

        scanner1.close();

        String file2 = args[1];

        Scanner scanner2 = new Scanner(new File(file2));
        while (scanner2.hasNext()) {
            float pointX = scanner2.nextFloat();
            float pointY = scanner2.nextFloat();

            int res = point_in_circle(pointX, pointY, centerX, centerY, radius);
            System.out.println(res);
        }
        scanner2.close();
    }
}
