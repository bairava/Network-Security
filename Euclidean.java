import java.util.Scanner;
public class Euclidean {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Please enter two positive integers");
    int a = sc.nextInt();
    int b = sc.nextInt();
    Euclidean ec= new Euclidean();
    int result = 1;
    
    if(a>0 && b>0){
        result = ec.findgcd(a, b);
        System.out.println("The GCD of "+ a + " and " + b + " is " + result);
    }
    else
        System.out.println("Please enter only positive numbers!!!");
    }
//Method to find the GCD of two given numbers
public int findgcd(int a, int b){
        while (b != 0)
        {
        int temp = b;
        b= a%b;
        a = temp;
            }
        return a;
    }
}