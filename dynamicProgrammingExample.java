public class dynamicProgrammingExample {
    static int fib(int n, int[] dp) {
        if (n <= 1) {
            return n; // Base case
        }
        if (dp[n] != 0) { // Check if result is already computed
            return dp[n];
        }
        dp[n] = fib(n - 1, dp) + fib(n - 2, dp); // Store result in dp array
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
        int dp[] = new int[n + 1]; // Initialize dp array
        System.out.println("Fibonacci of " + n + " is:");
        System.out.println(fib(n, dp)); // Call fib with dp array
    }
}
