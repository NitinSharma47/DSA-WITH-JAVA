package STRING;

public class Largest_Odd_Integer_In_Number {
    public static String large( String s){

        int i = 0 ;                     // at starting
        int j = s.length() - 1 ;    // at ending
        
        while(i < j && s.charAt(i) == '0'){     // when i  encounters a leading 0, skip it
           i ++ ;
        }
        while ( j >= i && (s.charAt(j) - '0') % 2  == 0){       // when last digit is even , move j backward, because we have to find a odd number
            j -- ;
        }
        if(j < i){ return "" ;}             // when no odd number exists

        return s.substring(i , j + 1) ;             // return the substring starting from i to j ...(j +  1) because to also include j value..
    }
    public static void main(String[] args) {
        String s = "0214638" ;
        System.out.println(large(s));
    }   
}
