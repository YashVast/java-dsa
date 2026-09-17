
import java.util.Arrays;



public class PermutationInString{

    // BRUTE FORCE -->
    // TC: O(n * k log k)
    // SC: O(k+k) = O(k)
    // public static void main(String[] args){
    //     String s1 = "ab";
    //     String s2 = "eidbaooo";

    //     System.out.println(permutationInString(s1,s2));
    // }
    // public static boolean permutationInString(String s1, String s2){
    //     int k = s1.length();
    //     int n = s2.length();

    //     if(n<k){
    //         return false;
    //     }
    //     char[] s1Arr = s1.toCharArray();
    //     Arrays.sort(s1Arr);
    //     String s1Sorted = new String(s1Arr);

    //     for(int i=0; i<=n-k; i++){
    //         String window = s2.substring(i,i-k);
    //         char[] windowArr = window.toCharArray();
    //         Arrays.sort(windowArr);
    //         String sortedWindow = new String(windowArr);
            
    //         if(sortedWindow.equals(s1Sorted)){
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    // BETTER -->
    // TC: O(k)+O(n*k) = O(n*k)
    // SC: O(2k) = O(k)
    // public static void main(String[] args){
    //     String s1 = "ab";
    //     String s2 = "eidbaooo";

    //     System.out.println(permutationInString(s1,s2));
    // }
    // public static boolean permutationInString(String s1, String s2){
    //     int k = s1.length();
    //     int n = s2.length();

    //     if(n<k){
    //         return false;
    //     }

    //     int[] s1Count = new int[26];
    //     for(int i=0; i<k; i++){
    //         s1Count[s1.charAt(i) - 'a']++;
    //     }

    //     for(int i=0; i<=n-k; i++){
    //         int[] windowCount = new int[26];
    //         for(int j=i; j<i+k; j++){
    //             windowCount[s2.charAt(j) - 'a']++;
    //         }
    //         if(Arrays.equals(s1Count, windowCount)){
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    // OPTIMAL -->
    // TC: O(k)+O(n-k) = O(n)
    // SC: O(2k) = O(k)
    public static void main(String[] args){
        String s1 = "ab";
        String s2 = "eidbaooo";

        System.out.println(permutationInString(s1,s2));
    }
    public static boolean permutationInString(String s1, String s2){
        int k = s1.length();
        int n = s2.length();

        if(n<k){
            return false;
        }

        int[] s1Count = new int[26];
        int[] windowCount = new int[26];

        for(int i=0; i<k; i++){
            s1Count[s1.charAt(i)-'a']++;
            windowCount[s2.charAt(i)-'a']++;
        }
        if(Arrays.equals(s1Count,windowCount)){
            return true;
        }

        for(int i=k; i<n; i++){
            windowCount[s2.charAt(i)-'a']++;
            windowCount[s2.charAt(i-k)-'a']--;

            if(Arrays.equals(s1Count, windowCount)){
                return true;
            }
        }
        return false;
    }
}