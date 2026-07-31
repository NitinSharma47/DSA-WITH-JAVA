/*                                       Find Quads that add up to a target value
                        you need to return an array of all the unique quadruplets [arr[a], arr[b], arr[c], arr[d]]
                                     such that their sum is equal to a given target. 

                                                        << OPTIMAL APPROACH >>

                    
*/

package ARRAYS.HARD;
import java.util.* ;

public class Four_Sum {
    public static List<List<Integer >> foursum(int arr[], int target){

        Arrays.sort(arr);
        int n = arr.length ;
        List < List <Integer >> result = new ArrayList<>() ;

        for( int i = 0 ; i < n-3 ; i ++ ){                  // We stop at n - 3 because we need at least three elements after i(j,left,right)
            if( i > 0 && arr[i] == arr[i-1]){ continue ;}   // preventing again usage of same element..Because processing the same first value again can generate duplicate quadruplets.

            for(int j = i + 1 ; j < n-2 ; j ++){            // We stop at n - 2 because we need at least two elements after j(left,right)
                if( j > i + 1 && arr[j] == arr[j-1]){ continue ;}

                int left = j + 1 , right = n - 1 ;
 
                while( left < right){

                    // * remember ->   i < j < left < right     because array is sorted

                    int sum = arr[i] + arr[j] + arr[left] + arr[right] ;

                    if (sum == target){

                        result.add(Arrays.asList(arr[i] , arr[j] , arr[left] , arr[right]));
                        left ++;
                        right --;

                        while(left < right && arr[left] == arr[left -1]){left ++  ;}
                        while(right > left && arr[right] == arr[right + 1 ]){ right --  ;}
                    }
                    else if(sum < target){
                        left ++ ;
                    }else {
                        right -- ;
                    }
                }
            }
        }
        return result ;
    }
    public static void main(String[] args) {
        int arr[] = { 2,1,2,4,3,4,5};
        int target = 15 ;
        System.out.println(foursum(arr, target));
    }
}
