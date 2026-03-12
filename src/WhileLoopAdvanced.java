public class WhileLoopAdvanced {

    // GCD using Euclidean algorithm
    static int gcd(int a, int b) {
        while (b != 0) { int t = b; b = a % b; a = t; }
        return a;
    }

    // Convert decimal to binary
    static String decToBinary(int n) {
        if (n == 0) return "0";
        StringBuilder sb = new StringBuilder();
        int temp = Math.abs(n);
        while (temp > 0) { sb.insert(0, temp % 2); temp /= 2; }
        return (n < 0 ? "-" : "") + sb;
    }

    // Sum of digits
    static int digitSum(int n) {
        int s = 0;
        n = Math.abs(n);
        while (n > 0) { s += n % 10; n /= 10; }
        return s;
    }

    // Happy number check
    static boolean isHappy(int n) {
        int slow = n, fast = sumSquareDigits(sumSquareDigits(n));
        while (fast != 1 && slow != fast) { slow = sumSquareDigits(slow); fast = sumSquareDigits(sumSquareDigits(fast)); }
        return fast == 1;
    }
    static int sumSquareDigits(int n) {
        int s = 0; while (n > 0) { int d = n % 10; s += d*d; n /= 10; } return s;
    }

    public static void main(String[] args) {
        System.out.println("=== GCD using Euclidean Algorithm ===");
        int[][] pairs = {{48, 18}, {100, 75}, {17, 13}, {252, 105}};
        for (int[] p : pairs)
            System.out.printf("GCD(%d, %d) = %d%n", p[0], p[1], gcd(p[0], p[1]));

        System.out.println("\n=== Decimal to Binary ===");
        int[] nums = {0, 1, 5, 10, 42, 255, 1024};
        for (int n : nums)
            System.out.printf("%5d → %s%n", n, decToBinary(n));

        System.out.println("\n=== Digit Sum ===");
        for (int n : new int[]{0, 9, 123, 9999, -456})
            System.out.printf("digitSum(%5d) = %d%n", n, digitSum(n));

        System.out.println("\n=== Happy Numbers 1-50 ===");
        for (int i = 1; i <= 50; i++) if (isHappy(i)) System.out.print(i + " ");
        System.out.println();
    }
}
