package miller;

import java.math.BigInteger;
import java.util.Scanner;

public class MillerPrimality {
    //Static Variable Declaration
    private static final BigInteger ZERO = BigInteger.ZERO;
    private static final BigInteger ONE = BigInteger.ONE;
    private static final BigInteger TWO = new BigInteger("2");
    
    public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
        //Request User Input
        System.out.println("Please enter a positive odd number (N) greater than 2 to use in Primality test");
        BigInteger N = sc.nextBigInteger();
        //Checking whether the entered number is odd or even
        if(N.mod(TWO).equals(ZERO))
            System.out.println("Please enter an odd number to execute Primality Test, the entered input is an even number "+N);
        else
        millerCalculate(N); //Calling the method to perform primality test
    }
    //Method to perform Miller Rabin Primality Test
    public static void millerCalculate(BigInteger n){
        int k=0;
        BigInteger a=TWO;
        BigInteger q;
        //Calculation of first step of algorithm : q and k
        q = n.subtract(ONE);   
        while(q.mod(TWO).equals(ZERO)){
            k++;
            q = (q).divide(TWO);
        }
       System.out.println("The value of q & k is " +q +" "+k);
       //Calculation of second step of algorithm with a=2
       BigInteger c =  a.modPow(q,n);
       boolean prime=false;
        //Check whether 'c' equals One to decide the entered number as probable prime
        if(c.equals(ONE))
               System.out.println("Probable Prime " + n);
           else{//Perform further calculation to determine n-1
               for(int j=0; j<k; j++){
                   c = c.modPow(TWO, n);
                    if(c.equals(n.subtract(ONE))){
                       System.out.println("Probable Prime " + n); 
                       prime = true;
                       break;
                    }
               }//If none of the condition satisfied, the entered number is composite    
                    if(prime==false){
                        System.out.println("The given number is composite " + n);
                        }
                }
            
        }
}