public class Main1 {
    private static String circle(int n, int m) {
        StringBuilder stringBuilder = new StringBuilder();
        int step = m - 1;
        int i = 0;
        stringBuilder.append(i + 1);
        while (true) {
            i += step;
            if (i >= n) {
                i = i % n;
            }
            if (i == 0) {
                return stringBuilder.toString();
            }
            stringBuilder.append(i + 1);
        }
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            throw new RuntimeException("Expected <n> <m> arguments");
        }

        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        System.out.println(circle(n, m));
    }
}
