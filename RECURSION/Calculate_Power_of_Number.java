public class Calculate_Power_of_Number {
    public static double powerr(double num , int poww){

        if (poww == 0 ){                            // 0 , power of any number made it 1
            return 1 ;
        }
        if(poww < 0){                               // when power is negative....
            return 1 / powerr(num , -poww) ;
        }

        double half = powerr(num, poww / 2) ;       // using half for reducing time complexity.. (2)^10  =>  (2*2)^5
        if( poww % 2 == 0){                         // when power is even 
            return half * half ;
        }

        return num * half * half ;                // when odd     
    }
    public static void main(String[] args) {
        double num = 2 ;
        int poww = 5 ;            // 2^5
        System.out.println(powerr(num, poww));

    }
    
}
