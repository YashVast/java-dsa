import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacter {
    // BRUTE FORCE --> 
    // TC: O(n*2)
    // SC: O(256)
    // public static void main(String args[]){
    //     String s = "cadbzabcd";
    //     System.out.println(longestSubstring(s));
    // }
    // public static int longestSubstring(String s){
    //     int n = s.length();
    //     int maxLength = 0;

    //     for(int i=0; i<n; i++){
    //         int[] hash = new int[256];
    //         for(int j=i; j<n; j++){
    //             if(hash[s.charAt(j)] == 1){
    //                 break;
    //             }
    //             hash[s.charAt(j)] = 1;
    //             int length = j-i+1;
    //             maxLength = Math.max(maxLength,length);
    //         }
    //     }
    //     return maxLength;
    // }


    // BETTER -->
    // TC: O(n)
    // SC: O(n)
    // public static void main(String args[]){
    //     String s = "cadbzabcd";
    //     System.out.println(longestSubstring(s));
    // }
    // public static int longestSubstring(String s){
    //     int left = 0;
    //     int right = 0;
    //     int maxLength = 0;
    //     Map<Character,Integer> map = new HashMap<>();

    //     while(right<s.length()){
    //         char current = s.charAt(right);
    //         if(map.containsKey(current) && map.get(current)>=left){
    //             left = map.get(current)+1;
    //         }
    //         map.put(current,right);
    //         maxLength = Math.max(maxLength, right-left+1);
    //         right++;
    //     }
    //     return maxLength;
    // }

    //Same approach is used below but using HashSet and this one is more faster:
    //OPTIMAL -->
    // TC: O(n)
    // SC:O(256)
    public static void main(String args[]){
        String s = "cadbzabcd";
        System.out.println(longestSubstring(s));
    }
    public static int longestSubstring(String s){
        int left = 0;
        int maxLength = 0;
    
        int[] hash = new int[256];
    
        for (int right = 0; right < s.length(); right++) {
    
            char current = s.charAt(right);
    
            left = Math.max(left, hash[current]);
    
            hash[current] = right + 1;
    
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
