import java.util.*;

public class Generate_Parenthesis{
    public static void backtrack(String curr, int open, int close, int n, List<String> res) {

        if (curr.length() == 2 * n) {           // *checking the length of curr(which contains parenthesis) is valid or not, curr ? ->  2 * 3 == 6
            res.add(curr);                      // if valid then add it to result
            return;
        }

        if (open < n) backtrack(curr + "(", open + 1, close, n, res);               
        if (close < open) backtrack(curr + ")", open, close + 1, n, res);
    }

    public static List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();                       // Store all vald parenthesis of Size N
        backtrack("", 0, 0, n, res);                // calling backtrack to generate all parenthesis of n size

        return res;
    }

    public static void main(String[] args) {
        
        List<String> result = generateParenthesis(3);           // N is 3
        for (String s : result) {
            System.out.println(s);
        }
    }
}

