public class BackPack {
    public static void main(String[] args) {
        int[] a = {2, 3, 4, 5, 6, 7, 8, 9};
        int w = 10;
        System.out.println(maxItems(a, w));
    }

    public static int maxItems(int[] weights, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (weights[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + 1);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][capacity];
    }
}