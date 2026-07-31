/*      Given the arrival and departure times of all trains reaching a particular railway station, 
        determine the minimum number of platforms required so that no train is kept waiting. Consider all trains arrive and depart on the same day.

    In any particular instance, the same platform cannot be used for both the departure of one train and the arrival of another train,
    necessitating the use of different platforms in such cases.

Note: Time intervals are in the minutes , Leading zeros for minutes less than 1000 are optional (e.g., 0900 is the same as 900).

Example -
            Input : Arrival = [900, 940, 950, 1100, 1500, 1800] , Departure = [910, 1200, 1120, 1130, 1900, 2000]

            Output : 3
            Explanation : The first , second , fifth number train can use the platform 1.
            The third and sixth train can use the platform 2.
            The fourth train will use platform 3.
            So total we need 3 different platforms for the railway station so that no train is kept waiting.

        APPROACH ->   IF for any train, its departure time is bigger than the, Arrival time of next train..
                      In that case we are going to use a different platform

*                                                 <<    BRUTE FORCE APPROACH    >>
 */ 

package GREEDY_ALGORITHM;

public class Minimum_Platforms_Required {
    public static int platform( int arrival[] , int departure []){

        int n = arrival.length ;
        int platform = 0;

        for (int i = 0; i < n; i++) {
            int count = 0;              // variable to count platforms and increase if overlappin of train founds

            for (int j = 0; j < n; j++) {

                if (arrival[j] <= arrival[i] &&         // when a train i arrives , between the arrival and departure time of train j..then it is a overlapping condition
                    arrival[i] <= departure[j]) {

                    count++;            // then, means we need a extra platform for it
                }
            }
            platform = Math.max(platform, count);               //maximum platforms usedd
        }
        return platform;
    }

    public static void main(String[]args){

        int arrival [] = {900, 940, 950, 1100, 1500, 1800} ;
        int departure [] = {910, 1200, 1120, 1130, 1900, 2000} ;
        
        System.out.println(platform(arrival, departure));
    }
    
}
