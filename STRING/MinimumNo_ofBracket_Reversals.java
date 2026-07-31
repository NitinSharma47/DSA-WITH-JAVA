/*              Given a string s consisting of only opening and closing brackets '(' and ')', 
            find out the minimum number of reversals required to convert the string into a balanced expression.

            If it is not possible to make the brackets balanced, return -1. A reversal means changing '(' to ')' or vice-versa.

*      The only case when balancing the brackets is not possible -> is when the total nummber of brackets are odd..
*       Approach -> 
              - we use a stack approach in this cas..when i encounters  " ( " then open count is increases..
              - Otherwise, when i encounters " ) " & then , if there are previous open counts.. 
                        then this iterationn is used to eliminate the open counts 
        *               (ONLY CLOSED COUNT CAN ELIMINATE THE OPEN COUNTS , OPEN COUNTS CAN'T ELIMINATE THE CLOSE COUNTS)
              - otherwise , close count is increased by 1 .
              - And , at then end the total reversal is calculated by the formula -> (open+1) /2 + (close+1) /2

        *       formula -> (open + 1)/ 2 + (close + 1)/2   is derived from various logic conditions....                            
                    
 */
package STRING;
public class MinimumNo_ofBracket_Reversals {
    public static int Bra(String s){

        int open = 0 ;                  // variable to track open bracket count
        int close = 0 ;                 // variable to track close bracket count

        if (s.length() % 2 != 0){
            return -1 ;
        }

        for(int i = 0 ; i < s.length() ; i ++){
            if(s.charAt(i) == '(' ) {
                open ++ ;
            }
            else{
                if( open > 0 ) {
                    open -- ;
                }
                else{
                    close ++ ;
                }
            }
        }
        return (open + 1 )/ 2 + (close + 1)/ 2  ;

    }
    public static void main(String[] args) {
        
        String s = ")(())(((" ;
        System.out.println(Bra(s)) ;
    }
    
}
