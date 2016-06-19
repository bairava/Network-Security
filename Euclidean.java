import java.util.Scanner;
public class Euclidean {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Please enter first positive integer");
    int a = sc.nextInt();
    System.out.println("Please enter second positive integer");
    int b = sc.nextInt();
    Euclidean ec= new Euclidean();
    int result = ec.findgcd(a, b);
    System.out.println("The GCD of "+ a + " and " + b + " is " + result);
    }
//Method to find the GCD of two given numbers
public int findgcd(int a, int b){
         if(b == 0) 
             return a;
        while (b != 0)
        {
        int temp = b;
        b= a%b;
        a = temp;
            }
        return a;
    }
}
