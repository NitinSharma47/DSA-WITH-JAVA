/*                                              << OPTIMAL APPROACH >> 
                                    This approach uses two pointers , left and right--
            
    *APPROACH -
                The key insight is that the amount of water trapped at any position depends on the tallest bars
                to the left and right of that position. By maintaining two pointers starting from both ends of the elevation array
                and tracking the maximum heights encountered so far from both sides, we can determine the trapped water at each step.
                If the left height is smaller or equal to the right height, the trapped water depends on the left side's maximum; otherwise,
                it depends on the right side's maximum. This two-pointer technique lets us compute trapped water in one pass while using constant
                extra space.

*       Trick -
                When left element is lesser than right element , then the water trapped depends on leftmax - left
                When right element is lesser than left element , then the water trapped depends on rightmax - right


                ⚡ Algorithm:-
                        left = 0, right = n-1                      // pointers
                        leftMax = 0, rightMax = 0                  // variables to store leftmax and rightmax value
                                         

                        While left < right:-
                            If height[left] < height[right]:
                                if height[left] >= leftMax → update
                                else → water += leftMax - height[left]
                                left++
                            else:
                                if height[right] >= rightMax → update
                                else → water += rightMax - height[right]
                                right-- 
*/

package STACK_QUEUE ;

public class Trapping_Rainwater {
    public static int Trapped_Water(int arr[]){

        int n = arr.length;
        int leftmax = 0; int rightmax = 0;          // leftmax & rightmax to store the first leftmax element & rightmax element from index i
        int left = 0; int right = n-1;              // Two pointers 
        int water = 0;
                                                    // Variable to store total water trapped ....
        while(left < right){
            
            if ( arr[left] < arr[right]) {                // when left value is lesser than right 

                if( arr[left] >= leftmax){
                    leftmax = arr[left];                  // update leftmax, when current left is greater than leftmax
                }
                else{                                     // if left < leftMax  =👉 Water can be stored =👉 water = leftMax - height ;
                    water += leftmax - arr[left];
                }
                left ++ ;
            }
            else{

                if( arr[right] >= rightmax){
                    rightmax = arr[right] ;               // update rightmax, when current right is greater than rightmax
                }
                else{
                    water += rightmax - arr[right];
                }
                right -- ;
            }  
        }
        return water;
    }
    public static void main(String[] args) {

        int arr[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(Trapped_Water(arr));
    }
}
