import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {
    // BRUTE FORCE -->
    // TC: O(n*2)
    // SC: O(256)
    // public static void main(String args[]){
    //     String s = "aaabbccd";
    //     int k = 2;
    //     System.out.println(longestSubstring(s,k));
    // }
    // public static int longestSubstring(String s, int k){
    //     int n = s.length();
    //     int maxLength = 0;
    //     Map<Character,Integer> map = new HashMap<>();

    //     for(int i=0; i<n; i++){
    //         map.clear();
    //         for(int j=i; j<n; j++){
    //             if(map.containsKey(s.charAt(j))){
    //                 map.put(s.charAt(j),map.get(s.charAt(j))+1);
    //             }
    //             else{
    //                 map.put(s.charAt(j),1);
    //             }
    //             if(map.size()<=k){
    //                 maxLength = Math.max(maxLength,j-i+1);
    //             }
    //             else{
    //                 break;
    //             }
    //         }
    //     }
    //     return maxLength;
    // }

    // BETTER -->
    // TC: O(n)+O(n) = O(2n)
    // SC: O(n)
    // public static void main(String args[]){
    //     String s = "aaabbccd";
    //     int k = 2;
    //     System.out.println(longestSubstring(s,k));
    // }
    // public static int longestSubstring(String s, int k){
    //     int n = s.length();
    //     int maxLength = 0;
    //     int left = 0;
    //     int right = 0;
    //     Map<Character,Integer> map = new HashMap<>();

    //     while(right<n){
    //         if(map.containsKey(s.charAt(right))){
    //             map.put(s.charAt(right),map.get(s.charAt(right))+1);
    //         }
    //         else{
    //             map.put(s.charAt(right),1);
    //         }
    //         while(map.size()>k){
    //             if(map.containsKey(s.charAt(left))){
    //                 map.put(s.charAt(left),map.get(s.charAt(left))-1);
    //                 if(map.get(s.charAt(left)) == 0){
    //                     map.remove(s.charAt(left));
    //                 } 
    //             }
    //             left++;
    //         }
    //         maxLength = Math.max(maxLength,right-left+1);
    //         right++;
    //     }
    //     return maxLength;
    // }

    // OPTIMAL -->
    // TC: O(n)
    // SC: O(n)
    public static void main(String args[]){
        String s = "aaabbccd";
        int k = 2;
        System.out.println(longestSubstring(s,k));
    }
    public static int longestSubstring(String s, int k){
        int n = s.length();
        int maxLength = 0;
        int left = 0;
        int right = 0;
        Map<Character,Integer> map = new HashMap<>();

        while(right<n){
            if(map.containsKey(s.charAt(right))){
                map.put(s.charAt(right),map.get(s.charAt(right))+1);
            }
            else{
                map.put(s.charAt(right),1);
            }
            if(map.size()>k){
                if(map.containsKey(s.charAt(left))){
                    map.put(s.charAt(left),map.get(s.charAt(left))-1);
                    if(map.get(s.charAt(left)) == 0){
                        map.remove(s.charAt(left));
                    }
                }
                left++;
            }
            if(map.size()<=k){
                maxLength = Math.max(maxLength,right-left+1);
            }
            right++;
        }
        return maxLength;
    }
}
