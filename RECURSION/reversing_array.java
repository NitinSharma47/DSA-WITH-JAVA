public class reversing_array {
    public static int [] reverse(int arr[]){

        // making a variable to get the length of the array...
        int n = arr.length;

        // making a new array to store the value of reverse array...
        int rev[] = new int[n];

        // starting a loop in reverse to get the element from last, to fill in from start in rev[] array...
        for (int i = n - 1; i >= 0; i--){

            // this reverse the array
            rev[n-1-i] = arr[i];

        }
        return rev;
    }

    public static void main(String[] args) {
        
        int arr[] = { 1,2,3,4,5};
        reverse(arr);

        // storing the returned array in rev
        int rev[] = reverse(arr);
        for (int result : rev){
            System.out.print(result+ " ");
        }
    
    }
       
         
    
}
