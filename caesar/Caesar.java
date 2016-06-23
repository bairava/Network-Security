package caesar;

import java.util.Arrays;
import java.util.Random;

public class Caesar {

    public static char alphabetArray[] = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    public static void main(String[] args) {
		System.out.println(caesarEncrypt("abcdefgZ!", 261));
		System.out.println(caesarDecrypt("cdefghiB!", 2));
		System.out.println(crackCipher("hel.,.,.,.lo", 10));
		System.out.println(crackCipher("Yg.$gv E.,g??jf.,afy", 25));
        char[] charArray = new char[]{'c','a','e','s','a','r'};
        shuffle(charArray);
        //generatePermutation();
        String cipherText = permuteEncrypt("caesar");
        System.out.println("The encrypted text is " +cipherText);
    }
    
    public static String caesarEncrypt(String originalMessage, int shift) {
		shift = shift % 26;
		String finalString = "";
		char holder;
		for (int i = 0; i < originalMessage.length(); i++) {

			holder = originalMessage.charAt(i);
			if ('a' <= holder && holder <= 'z') {

				if (holder + shift > 'z') {
					holder -= 26;
					holder += shift;
				} else {
					holder += shift;
				}
			}

			if (('A' <= holder && holder <= 'Z')) {

				if (holder + shift > 'Z') {
					holder -= 26;
					holder += shift;
				} else {
					holder += shift;
				}
			}

			finalString += Character.toString(holder);
		}
		return finalString;
	}

	public static String caesarDecrypt(String encryptedMessage, int shift) {
		return caesarEncrypt(encryptedMessage, 26 - shift % 26);

	}

	public static String crackCipher(String encoded, int numberLetters) {

		String[] numberOfShifts = new String[(numberLetters - 1)];
		int[] numberOfWords = new int[(numberLetters - 1)];

		for (int i = 0; i < numberLetters - 1; i++) {
			numberOfShifts[i] = caesarDecrypt(encoded, i);
			numberOfWords[i] = SentenceChecker.countEnglishWords(numberOfShifts[i]);
			//System.out.println(numberOfShifts[i] +"  "+ numberOfWords[i]);
		}
		String result = numberOfShifts[0];
		for (int i = 1; i < numberLetters - 1; i++) {
			if (numberOfWords[i] > numberOfWords[i-1]) {
				result = numberOfShifts[i];
			}
		}
		 result = result.replaceAll("[^A-Za-z]", "");
		 
		return result;
	}
	
    public static void shuffle(char[] charArray) {
        int n = charArray.length;
        int power = n*n*n*n;
            char tempArray[] = new char[n];
            Random generator = new Random(12345);
              for(int i=0;i<n;i++){
                for(int j=1;j<=power;j++){
                    int k = generator.nextInt(n);
                    //System.out.println(k);
                     tempArray[i]=charArray[i]; 
                        charArray[i]=charArray[k]; 
                            charArray[k]=tempArray[i]; 
                            }
                }  
              System.out.print(Arrays.toString(charArray));
              System.out.println("\n");
    }
    
    public static char[] generatePermutation(){
        shuffle(alphabetArray);
        return alphabetArray;
    }

public static String permuteEncrypt(String plainText){
    generatePermutation();
    plainText = plainText.toUpperCase();
    char ch;
    int ascii;
    String cipherText = "";
    for(int i=0; i<plainText.length(); i++){
        ch=plainText.charAt(i);
        ascii=ch;
        if(ascii>64&&ascii<91){
            //generatePermutation();
            cipherText=cipherText+alphabetArray[ascii-65];}
        else
            cipherText=cipherText+plainText.charAt(i);
         }
    return cipherText;
    }
}