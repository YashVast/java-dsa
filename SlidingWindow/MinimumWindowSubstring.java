import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    // BRUTE FORCE -->
    // TC: O(n* (n+m)) = O(n*2)
    // SC: O(m)
    // public static void main(String args[]){
    //     String s = "ddaaabbca";
    //     String t = "abc";
    //     System.out.println(minimumWindowSubstring(s,t));
    // }
    // public static String minimumWindowSubstring(String s, String t){
    //     int n = s.length();
    //     int m = t.length();
    //     int minLength = Integer.MAX_VALUE;
    //     int sIndex = -1;
    //     Map<Character,Integer> map = new HashMap<>();
        
    //     for(int i=0; i<n; i++){
    //         map.clear();
    //         int count = 0;
    //         for(int k=0; k<m; k++){
    //             if(map.containsKey(t.charAt(k))){
    //                 map.put(t.charAt(k),map.get(t.charAt(k))+1);
    //             }
    //             else{
    //                 map.put(t.charAt(k),1);
    //             }
    //         }
    //         for(int j=i; j<n; j++){
    //             if(map.containsKey(s.charAt(j)) && map.get(s.charAt(j))>0){
    //                map.put(s.charAt(j),map.get(s.charAt(j))-1);
    //                count++;
    //             }
    //             if(count == m){
    //                 if(j-i+1 <minLength){
    //                     minLength = j-i+1;
    //                     sIndex = i;
    //                 }
    //                 break;
    //             }
    //         }
    //     }
    //     if(sIndex == -1){
    //         return "";
    //     }
    //     return s.substring(sIndex, sIndex+minLength);
    // }

    // OPTIMAL -->
    // TC: O(n+m)+O(m) = O(n+2m)
    // SC: O(m)
    public static void main(String args[]){
        String s = "ddaaabbca";
        String t = "abc";
        System.out.println(minimumWindowSubstring(s,t));
    }
    public static String minimumWindowSubstring(String s, String t){
        int left = 0;
        int right = 0;
        Map<Character,Integer> map = new HashMap<>();
        int count = 0;
        int minLength = Integer.MAX_VALUE;
        int sIndex = -1;

        for(int i=0; i<t.length(); i++){
            if(map.containsKey(t.charAt(i))){
                map.put(t.charAt(i),map.get(t.charAt(i))+1);
            }
            else{
                map.put(t.charAt(i),1);
            }
        }

        while(right<s.length()){
            if(map.containsKey(s.charAt(right))){
                map.put(s.charAt(right),map.get(s.charAt(right))-1);
                if(map.get(s.charAt(right)) >= 0){
                count++;
                }
            }
            while(count == t.length()){
                if(right-left+1 < minLength){
                    minLength = right-left+1;
                    sIndex = left;
                }
                if(map.containsKey(s.charAt(left))){
                    map.put(s.charAt(left),map.get(s.charAt(left))+1);
                    if(map.get(s.charAt(left))>0){
                        count--;
                    }
                }
                left++;
            }
            right++;
        }
        if(sIndex == -1){
            return "";
        }
        return s.substring(sIndex, sIndex+minLength);
    }
}
