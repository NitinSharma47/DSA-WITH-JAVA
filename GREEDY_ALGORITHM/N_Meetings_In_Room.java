/*    
    There is one meeting room in a firm. You are given two arrays, start and end each of size N. 
    For an index ‘i’, start[i] denotes the starting time of the ith meeting while end[i] will denote the ending time of the ith meeting. 
    Find the maximum number of meetings that can be accommodated if only one meeting can happen in the room at a particular time. 
    Print the order in which these meetings will be performed.
        Examples
        Input: N = 6,  start[] = {1,3,0,5,8,5}, end[] =  {2,4,5,7,9,9}
        Output: [1, 2, 4, 5]  , means maximum meeting conducted->> 1,2,4,5 

*       The greedy rule is: Select the meeting with the earliest ending time, because it can end early and then we are flexible to attend more meetings
*       then select the next meeting whose start time is ≥ the last selected meeting's ending time , becuase it shows that the meeting times are not overlapping

*/

import java.util.*;

public class N_Meetings_In_Room {
    static class pair {
        int start ;
        int end ;
        int position ;

        pair(int start , int end , int position){
            this.start = start ;
            this.end = end ;
            this.position = position ;
        }
    }

    public static List <Integer> meeting(int start[] , int end []){

        int n =  start.length ;
        pair endSorted [] = new pair [n] ;                                 // Array to store all meetings with starting time , ending time , position

        List <Integer> max_meetings = new ArrayList<>() ;

        for( int i = 0 ; i  < start.length ; i ++){                                 // we have store all values as pair(start, end , original index)
            endSorted[i] = new pair(start[i], end[i], i) ;                       
        }

        Arrays.sort(endSorted , (x,y) -> Integer.compare(x.end, y.end));           // Sorting the array on the basis of end[] values of current meeting
        int lastEnd = -1 ;                                                         // * Variable to store the ending time of meeting, to comapre to next meetings

        for(int i = 0 ; i < n ; i ++){

            if (endSorted[i].start >= lastEnd) {                     // *Checking that starting time of current meeting is more than ending time of last meeting..or not
                
                max_meetings.add(endSorted[i].position);            // Add the Original Position of of current meeting , if this meeting can happen
                lastEnd = endSorted[i].end;                         // updating ending time of last meeting from current meeting
            }
        }
        return max_meetings ;
    }
    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end   = {2, 4, 6, 7, 9, 9};

        System.out.println(meeting(start, end));
    }
    
}
