import java.util.Scanner;

public class Eratosthenes {
    public static void main(String[] args) throws Exception {
        try
        {
        //Request User Input
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a positive number(N) greater than 1 to display the prime numbers from 2 to N");
        int N = sc.nextInt();
        //Method call to execute Eratosthenes algorithm
        calculate(N);
        }
        catch(Exception E){
        System.out.println("Invalid input!!! Please enter a positive number greater than 1 " + E);
        }
    }
    //Method to perform Eratosthenes calculation
    public static void calculate(int n){
        int prime[] = new int[n+1];
        int i=0;
        //Creating an array of n elements
        prime[0] = 1;
        prime[1] = 1;
        for(i=2;i<=n;i++){
            prime[i] = i;
        } 
        //Replacing the composite numbers with 1 in the array
	double mulValue = 1;
        for(i=2;i<=(n/2);i++)
        {
            for(int j=2;j<=(n/2);j++)
            {
		mulValue = j*i;
                if(mulValue <=n)
                	prime[j*i] = 1;
		else
			break;	
            }
        }
        System.out.println("The prime number(s) upto "+n+" are");
        int count=0;
        //Printing the prime numbers between 2 and N
        for(i=2;i<=n;i++){
            if(prime[i]!=1){
            System.out.println(prime[i]);
            count++;
            }
        }
        //Printing the count of prime numbers between 2 and N
        System.out.println("Count of prime number(s) upto "+n+" is "+count);
    }
}