// printing sum of first N natural numbers....

class sumoffirst_naturalno {
    public static int sum(int number){
        if (number == 1 ){
            return 1;
        }
        return number + sum(number - 1);
    }
    public static void main(String[] args) {
        
        System.out.println(sum(10));
        
    } 
}
