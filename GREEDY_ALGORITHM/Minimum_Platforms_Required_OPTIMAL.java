package GREEDY_ALGORITHM;
import java.util.Arrays ;

public class Minimum_Platforms_Required_OPTIMAL {
    public static int platforms(int arrival[] , int departure []){

        Arrays.sort(arrival);
        Arrays.sort(departure);

        int n = arrival.length ;

        int count = 0 ; 
        int maxPlatforms = 0 ;

        int i = 0 , j = 0 ;

        while(i < n && j < n){

            if (arrival[i] <= departure[j]) {        // If next train arrives before current one departs
                count++;             // One more platform needed
                i++;
            } 
            else {              // One train departs, platform freed
                count--;
                j++;
            }
            // Update maximum required platforms
            maxPlatforms = Math.max(maxPlatforms, count) ;
        }

        return maxPlatforms ;
    }
     public static void main(String[]args){

        int arrival [] = {900, 940, 950, 1100, 1500, 1800} ;
        int departure [] = {910, 1200, 1120, 1130, 1900, 2000} ;

        System.out.println(platforms(arrival, departure));
    }
}
