
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInString{

    // BRUTE FORCE -->
    // TC: O(n * k log k)
    // SC: O(k)
    // public static void main(String[] args){
    //     String s = "cbaebabacd";
    //     String p = "bac";
    //     List<Integer> result = anagrams(s,p);
        
    //     for(int i=0; i<result.size(); i++){
    //         System.out.print(result.get(i)+" ");
    //     }
    // }
    // public static List<Integer> anagrams(String s, String p){
    //     List<Integer> result = new ArrayList<>();
    //     int n = s.length();
    //     int k = p.length();

    //     if(n<n){
    //         return result;
    //     }
    //     char[] pArr = p.toCharArray();
    //     Arrays.sort(pArr);

    //     String sortedP = new String(pArr);

    //     for(int i=0; i<=n-k; i++){
    //         String window = s.substring(i,i+k);
    //         char[] wArr = window.toCharArray();
    //         Arrays.sort(wArr);
    //         String sortedWindow = new String(wArr);
    //         if(sortedWindow.equals(sortedP)){
    //             result.add(i);
    //         }
    //     }
    //     return result;
    // }

    // BETTER -->
    // TC: O(k) + O(n * k)
    // SC: O(26+26) = O(1)
    // public static void main(String[] args){
    //     String s = "cbaebabacd";
    //     String p = "bac";
    //     List<Integer> result = anagrams(s,p);
        
    //     for(int i=0; i<result.size(); i++){
    //         System.out.print(result.get(i)+" ");
    //     }
    // }
    // public static List<Integer> anagrams(String s, String p){
    //     List<Integer> result = new ArrayList<>();
    //     int n = s.length();
    //     int k = p.length();

    //     if(n<k){
    //         return result;
    //     }
    //     int[] pCount = new int[26];
    //     for(int i=0; i<k; i++){
    //         pCount[i - 'a']++;
    //     }

    //     for(int i=0; i<=n-k; i++){
    //         int[] windowCount = new int[26];
    //         for(int j=i; j<i+k; j++){
    //             windowCount[s.charAt(j)- 'a']++;
    //         }
    //         if(Arrays.equals(windowCount,pCount)){
    //             result.add(i);
    //         }
    //     }
    //     return result;
    // }

    // OPTIMAL -->
    // TC: O(k)+O(n-k)
    // SC: O(26+26) = O(1)
    public static void main(String[] args){
        String s = "cbaebabacd";
        String p = "bac";
        List<Integer> result = anagrams(s,p);
        
        for(int i=0; i<result.size(); i++){
            System.out.print(result.get(i)+" ");
        }
    }
    public static List<Integer> anagrams(String s, String p){
        List<Integer> result = new ArrayList<>();
        int n = s.length();
        int k = p.length();

        if(n<k){
            return result;
        }
        int[] pCount = new int[26];
        int[] windowCount = new int[26];

        for(int i=0; i<k; i++){
            pCount[p.charAt(i) - 'a']++;
            windowCount[s.charAt(i) - 'a']++;
        }
        if(Arrays.equals(pCount,windowCount)){
            result.add(0);
        }
        for(int i=k; i<n; i++){
            windowCount[s.charAt(i) - 'a']++;
            windowCount[s.charAt(i-k) - 'a']--;

            if(Arrays.equals(pCount,windowCount)){
                result.add(i-k+1);
            }
        }
        return result;
    }
}