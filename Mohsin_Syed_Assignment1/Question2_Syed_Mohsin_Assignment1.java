
class Example {
    // static fields maintain their state during recursive calls
    private static long a = 0, b = 1, sum;
    public static void fiboSeriesRec(int n) {
        if (n > 0) {
            System.out.print(a + " ");
            sum = a + b;
            a = b;
            b = sum;
            fiboSeriesRec(n - 1);
        } else {
            System.out.println();
            a = 0;
            b = 1;
        }
    }
    
    public static void fiboSeriesIte(int n) {
        long a = 0, b = 1, sum;
        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");
            sum = a + b;
            a = b;
            b = sum;
        }
        System.out.println();
    }
    
    public static void main(String args[]) {
        long start, end;
        long[][] time = new long[5][2];
        // 5 test cases
        for (int i = 1; i <= 5; i++) {
            int n = i * 10;
            // print series and save time of execution for recursive method
            System.out.println("n = " + n + "\nRecursive");
            start = System.nanoTime();
            fiboSeriesRec(n);
            end = System.nanoTime();
            time[i - 1][0] = (end - start);
            // print series and save time of execution for iterative method
            System.out.println("Iterative");
            start = System.nanoTime();
            fiboSeriesIte(n);
            end = System.nanoTime();
            time[i - 1][1] = (end - start);
        }
        System.out.println("\t\t\tRecursive\tIterative");
        for (int i = 1; i <= 5; i++) {
            int n = i * 10;
            System.out.print("n = " + n);
            for (int j = 0; j < 2; j++) {
                System.out.print("\t\t" + time[i - 1][j]);
            }
            System.out.println();
        }
    }
}
