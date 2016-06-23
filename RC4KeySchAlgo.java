import java.util.Scanner;
public class RC4KeySchAlgo {

    public static void main(String[] args) {
        System.out.println("Please enter a value between 1 to 256");
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int[] K ;
        if(l>0 && l<257){
        K = new int[l];
        K[0] = 15; K[1]=202; K[2]=33; K[3]=6; K[4]=8;
        int[] S = new int[256];
        int[] T = new int[10];
        for(int i=0;i<256;i++){
        S[i] = i;
        }
        System.out.println(" ");
        int j=0;
        for(int i=0;i<256;i++){
            j = (j+S[i]+K[i%l])%256;
            T[0] = S[i];
            S[i] = S[j];
            S[j] = T[0];
        }
        
        j=0;
        int i=0;
        int u=0;
        int key;
        int count = 0;
        
        while(true){
            u=u+1;
            i=(i+1)%256;
            j=(j+S[i])%256;
            T[0] = S[i];
            S[i] = S[j];
            S[j] = T[0];
            key = S[(S[i]+S[j])%256];
            System.out.print(key+",");
            count++;
            if(count==20)
                break;
            } 
        }  
        else{
            System.out.println("Invalid input " +l);
        }
    }
}