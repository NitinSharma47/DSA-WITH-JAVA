//*                                               THIS CODE CAN ALSO WORK IN ->

//*                           <<   SPLIT ARRAY - LARGEST SUM PROBLEM & PAINTER 's PARTITION PROBLEMs  >>
//*                                             ( Because all three problems are same )


// *                                                    <<  MOST IMPORTANT  >>
// *                                               << BINARY SEARCH OPTIMAL APPROACH >>

/*                 Given an array ‘arr of integer numbers, ‘arr[i]’ represents the number of pages in the ‘i-th’ book. 
                    There are a ‘m’ number of students, and the task is to allocate all the books to the students.

        Allocate books in such a way that:-

        Each student gets at least one book.
        Every book should be allocated.
        Each book should be allocated to only one student.
        Book allocation should be in a contiguous manner.
    
    You have to allocate the book to ‘m’ students such that the maximum number of pages assigned to a student is minimum. 
    If the allocation of books is not possible. return -1

Example 1:

Input Format: n = 4, m = 2, arr[] = {12, 34, 67, 90}
Result: 113
Explanation: The allocation of books will be 12, 34, 67 | 90. One student will get the first 3 books and the other will get the last one.

Example 2:
Input Format:
 n = 5, m = 4, arr[] = {25, 46, 28, 49, 24}
Result:
 71
Explanation: The allocation of books will be 25, 46 | 28 | 49 | 24.
*/

package BINARY_SEARCH.BS_IN_ANS;

import java.util.Arrays;

public class Allocating_Minimum_pages {

    public static int Count_Student_required(int Books [] , int currentpages){      // function to count students required to allocate current books

        int n = Books.length;       // size of array
        int students = 1;        //Students are initially 1

        long pagesStudent = 0;                          // variable to store pages hold by student currently
        for (int i = 0; i < n; i++) {

            if (pagesStudent + Books[i] <= currentpages) {          // when a student(holding pages) + pages at i index is lesser than the pages(71) which are allowed to hold
                pagesStudent += Books[i];                       // add holding pages to current pages at i index
            }
            else {
                students++;                     // add pages to next student
                pagesStudent = Books[i];
            }
        }
        return students;
    }
    public static int allocation(int Books [], int m , int n){             // taking array as arraylist

        if( m > n){              // Edge Case, when students are more than books, then we cant allocate books to them..
            return -1 ;
        }

        int low = Arrays.stream(Books).max().getAsInt();              // largest number of page in Books (largest element in Books Array)
        int high = Arrays.stream(Books).sum();             // Total pages in full Books array (sum of whole array)

        while (low <= high){

            int mid = low + (high -low) / 2 ;
            int students = Count_Student_required(Books, mid) ;         // storing the student required for current pages

            if(students > m ){                  // when students required is more than initial student(4)
                low = mid + 1 ;                 // means then each student have less no. of books , so going for right part
            }
            else{                               // when students required is less
                high = mid - 1;                  // then means each student have more no. of books(although combination of more books)
            }
        }
        return low ;                // final answer is store in low
    }

    public static void main(String[] args) {
        int Books [] = {25, 46, 28, 49, 24} ;
        
        int m = 4 ;                 // Students 
        int n = 4 ;                 // Size of Book ArrayList 
        System.out.println(allocation(Books, m , n));
    }
}
