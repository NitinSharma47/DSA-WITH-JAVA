/*  
Consider a scenario where a teacher wants to distribute cookies to students, with each student receiving at most one cookie. 
Given two arrays, student and cookie, the ith value in the student array describes the minimum size of cookie that the ith student can be assigned. 
The jth value in the cookie array represents the size of the jth cookie. If cookie[j] >= student[i], 
the jth cookie can be assigned to the ith student. 
Maximize the number of students assigned with cookies and output the maximum number.

 Input : Student = [1, 2, 3] , Cookie = [1, 1]
Output :1
Explanation : Only the first cookie (1) satisfies the first student (1), therefore only 1 student is content.
Input : Student = [1, 2] , Cookie = [1, 2, 3]
Output : 2
Explanation : Cookie 1 satisfies student 1 and cookie 2 satisfies student 2. Therefore, 2 students are content.
 */

import java.util.Arrays;

class Assign_Cookies {
    public static int assign(int cookies[] , int greed []){

        Arrays.sort(cookies);                                   // * Sort, becuase to maximize the number of childrens that can get the cookkies
        Arrays.sort(greed);

        int i = 0 ; int j = 0 ;                                 // two pointers to traverse in both arrays

        while(i < cookies.length && j < greed.length){
            if(cookies[i] >= greed[j]){                         // *if cookie size is bigger than it can, relax the greed of child
                i ++ ;
                j ++;
            }
            else{
                i ++ ;                                          // when current cookie is smaller than the greed , then move to next one and check it
            }
        }
        return j ;                                              // j stands at a index , before that index , all students greed is fulfilled..
                                                                // so maximum number of greed fullfilled is j
    }
    public static void main(String[] args) {
        int cookies [] = {1,2,3} ;
        int greed [] = {1,2} ;

        System.out.println(assign(cookies, greed));
    }
    
}
