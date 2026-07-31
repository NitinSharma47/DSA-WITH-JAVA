/*      Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
        A shift on s consists of moving the leftmost character of s to the rightmost position.
        For example, if s = "abcde", then it will be "bcdea" after one shift.

    Approach ->
            if doubling of string s contains goal then , yes string can be rotated in goal..
                example ->  s = rotation 
                            double_s = rotationrotation
                            goal  =        tionrota            (matched)
 */
package STRING ;

public class Check_String_rotation {
    public static boolean rotation(String s , String goal){

        if(s.length() != goal.length()){            // when lengths are not equal then, obviously goal cannot be made by rotating s
            return false ;
        }
        String double_s = s + s ;
        return double_s.contains(goal) ;
    }
    public static void main(String[] args) {
        String s = "rotation" ;
        String goal = "tionrota" ;
        System.out.println(rotation(s, goal));
    }
}