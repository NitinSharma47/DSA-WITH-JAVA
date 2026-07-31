public class Wildcard_Matching {

    public static boolean isMatch(String s, String p) {

        int n = s.length();
        int m = p.length();

        boolean[][] dp = new boolean[n + 1][m + 1];

        // Empty string matches empty pattern
        dp[0][0] = true;

        // If pattern starts with *, it can match an empty string
        for (int j = 1; j <= m; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= m; j++) {

                char strChar = s.charAt(i - 1);
                char patChar = p.charAt(j - 1);

                // Same character or '?'
                if (patChar == '?' || patChar == strChar) {
                    dp[i][j] = dp[i - 1][j - 1];
                }

                // '*' can match:
                // 1. zero characters -> dp[i][j-1]
                // 2. one or more characters -> dp[i-1][j]
                else if (patChar == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {

        String s = "adceb";
        String p = "*a*b";

        System.out.println(isMatch(s, p));
    }
}
