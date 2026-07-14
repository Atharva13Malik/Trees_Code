import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] grid = new int[N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                grid[i][j] = sc.nextInt();
            }
        }

        long[][] dp = new long[N][M];

        for(int i = 0; i < N; i++){
            Arrays.fill(dp[i], -1);
        }

        long ans = Long.MIN_VALUE;

        for(int j = 0; j < M; j++){
            ans = Math.max(ans, solve(0, j, dp, grid));
        }

        System.out.println(ans);
    }

    public static long solve(int i, int j, long[][] dp, int[][] grid){

        int n = grid.length;
        int m = grid[0].length;

        // Invalid column
        if(j < 0 || j >= m)
            return (long)-1e18;

        // Last row
        if(i == n - 1)
            return grid[i][j];

        // Memoization
        if(dp[i][j] != -1)
            return dp[i][j];

        long best = Long.MIN_VALUE;

        // Next row ke kisi bhi column me ja sakte hain
        for(int k = 0; k < m; k++){

            long curr = solve(i + 1, k, dp, grid)
                        - Math.abs(k - j);

            best = Math.max(best, curr);
        }

        return dp[i][j] = grid[i][j] + best;
    }
}
