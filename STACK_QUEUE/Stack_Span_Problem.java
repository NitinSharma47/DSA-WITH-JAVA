/* 
    Given an array arr of size n, where each element arr[i] represents the stock price on day i. Calculate the span of stock prices for each day.

        The span Sᵢ for a specific day i is defined as the maximum number of consecutive previous days **(including the current day) 
        for which the stock price was less than or equal to the price on day i.

*       Means - hume wo element count(span) krne hai , jo current element(i) se consecutive (lagatar) chhote hai ya barabar hai..array ke andar

*       IDEA ->
            Use a stack..
            Traverse from 0 to n
            For first element the span is always 1 , because there is none element, which is before him
            Now store only those element in stack which are greater than current element, with their index numbers
            Else pop all the elements which are lesser or equal than it 
            & when if the stack is empty , then means the current element is the largest element so far , So its span is = current index + 1
            Now ,the span for each element is ->  
*           Span ->  current index - top element index 



*/
package STACK_QUEUE;
import java.util.* ;

public class Stack_Span_Problem {
    public static  List<Integer> span(int stocks []){

        int n = stocks.length ;
        List < Integer > result = new ArrayList<>();            // to store result

        Stack < Integer > st = new Stack<>();               // *the stack stores the indexes of that element, which are previous greater than current

        for(int i = 0 ; i < n ; i ++){

            if ( i == 0) {                                  // for first element
                st.push(i) ;
                result.add(1);
            }
            else{
                while(!st.isEmpty() && stocks[st.peek()] <= stocks[i]){    //*when top element is smaller than current.. pop(), because we dont need smaller elementss in stack
                    st.pop();
                }

                if(!st.isEmpty() && stocks[st.peek()] > stocks[i]){     // when top is already greater than current 
                    result.add(i - st.peek()) ;                         // *span of that current element is..its index - top element index..
                    st.push(i) ;                                        // *because it counts the elments which are lesser or equal between them
                }
                if(st.isEmpty()){                               // after popping all smaller elements , if stack becomes empty,  
                    st.push(i) ;                                // means the current element is greater of all in Array..
                    result.add(i + 1) ;
                }
            }
        }
        return result ;
    }
    public static void main(String[] args) {
        int stocks [] = {120, 100, 60, 80, 90, 110, 115} ;
        System.out.println(span(stocks));
    }
    
}
