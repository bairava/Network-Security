import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LZWAlgorithm {
public static Map<String,String> dictionary = new HashMap<>();
private static int indexCount;
public static boolean deCompress = false;
    public static void main(String[] args) {
       
       createDictionary();
       System.out.println("Please enter alphanumeric text to compress");
       Scanner sc = new Scanner(System.in);
       String input = sc.nextLine();
       encodeLZW(input);
       
      deCompress = true; 
       ArrayList<Integer> inputArray = new ArrayList<>();
       System.out.println("\n\nPlease enter a compressed text to decompress");
       input = sc.nextLine();
       for(String part : input.split("\\s")){
           int p=(Integer.parseInt(part));
           inputArray.add(p);
           }
       createDictionary();
       decodeLZW(inputArray);
    }
    
    public static void createDictionary(){
       dictionary.clear();
    if(!deCompress){  
        for (int i = 0; i < 256; i++)
            dictionary.put(""+(char)i,""+i);
        }
    else
        {
         for (int i = 0; i < 256; i++)
            dictionary.put(""+i,""+(char)i);
        }
    }
    
    public static void printDictionary(){
        System.out.println("\nDictionary words");
        indexCount = 0;
    if(!deCompress){    
    for(Map.Entry content : dictionary.entrySet()){
        if(Integer.parseInt(content.getValue().toString())>255){
        indexCount = indexCount+1;    
        System.out.print(content.getKey() +" "+content.getValue() +";");
                }
            }
        }
    else{
        for(Map.Entry content : dictionary.entrySet()){
            if(Integer.parseInt(content.getKey().toString())>255)
            System.out.print(content.getKey() +" "+content.getValue() +";");
            }
        }
    } 
    public static void encodeLZW(String input){
        String word="";
        int count = 0;
        List<String> CompressedOutput = new ArrayList<>();
        for(char c : input.toCharArray()){
            count = count+1;
            String wordC=word+c;
            if(dictionary.containsKey(wordC)){
                word=wordC;
            }
            else{
                CompressedOutput.add(dictionary.get(word));
                int dictSize = dictionary.size() + 1; 
                dictionary.put(wordC, ""+dictSize);
                word=""+c;
            }
        }
        
        if(!word.equals(""))
            CompressedOutput.add(dictionary.get(word));
        
        System.out.println("\nCompression Result");
        for(Object print:CompressedOutput)
            System.out.print(print+" ");
        
        System.out.println(" ");
        printDictionary();
        
        System.out.println("\n\nThe compression ratio is");
        double ratio = (indexCount*1.0)/count;
        System.out.printf("%.3f",ratio);
    }
    
    public static void decodeLZW(ArrayList compressed){
            String word = "" + (char)(int)compressed.remove(0);
            StringBuilder result = new StringBuilder(word);
        for (Object ks : compressed) {
            String k = ks.toString();
            String entry;
            if (dictionary.containsKey(k))
                entry = dictionary.get(k);
            else if (k.equals(dictionary.size()))
                entry = word + word.charAt(0);
            else
                throw new IllegalArgumentException("Bad compressed for: " + k);
 
            result.append(entry);
            int dictSize = dictionary.size() +1;
            dictionary.put(""+dictSize,word + entry.charAt(0));
            word = entry;
        }
        System.out.println("\nDecompression Result");
        System.out.print(result.toString());
        System.out.println(" ");
        printDictionary();
    }
}