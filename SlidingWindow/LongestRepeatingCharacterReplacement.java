import java.util.Arrays;

public class LongestRepeatingCharacterReplacement{

    //BRUTE FORCE -->
    // TC: O(n*2)
    // SC: O(26)

    //Your hash array represents the frequency of each letter:
    // index:     0    1    2    3 ...
    // letter:    A    B    C    D ...
    // frequency: 2    1    0    0 ...
    // public static void main(String args[]){
    //     String s = "AABABBA";
    //     int k = 2;
    //     System.out.println(longestSubstring(s,k));
    // }
    // public static int longestSubstring(String s, int k){
    //     int n = s.length();
    //     int maxLength = 0;
    //     int[] hash = new int[26];
        
    //     for(int i=0; i<n; i++){
    //         Arrays.fill(hash,0);
    //         int maxFrequency = 0;
    //         int changes = 0;

    //         for(int j=i; j<n; j++){
    //             hash[s.charAt(j) - 'A']++;
    //             maxFrequency = Math.max(maxFrequency,hash[s.charAt(j)- 'A']);
    //             changes = (j-i+1) - maxFrequency;
    //             if(changes<=k){
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
    // SC: O(26)
    // public static void main(String args[]){
    //     String s = "AAABBCCD";
    //     int k =2;
    //     System.out.println(longestSubstring(s,k));
    // }
    // public static int longestSubstring(String s, int k){
    //     int n = s.length();
    //     int left = 0;
    //     int right = 0;
    //     int maxLength = 0;
    //     int maxFreq = 0;
    //     int[] hash = new int[26];

    //     while(right<n){
    //         hash[s.charAt(right) - 'A']++;
    //         maxFreq = Math.max(maxFreq, hash[s.charAt(right) - 'A']);

    //         while((right-left+1) - maxFreq > k){
    //             hash[s.charAt(left) - 'A']--;
    //             //thi for loop is unnecessary watch the video for any doubt
    //             // for(int i=0; i<26; i++){
    //             //     maxFreq = Math.max(maxFreq,hash[i]);
    //             // }
    //             left++;
    //         }
    //         if((right-left+1) - maxFreq <= k){
    //             maxLength = Math.max(maxLength,right-left+1);
    //         }
    //         right++;
    //     }
    //     return maxLength;
    // }

    // OPTIMAL --> 
    // TC: O(n)
    // SC: O(26)
    public static void main(String args[]){
        String s = "AAABBCCD";
        int k =2;
        System.out.println(longestSubstring(s,k));
    }
    public static int longestSubstring(String s, int k){
        int n = s.length();
        int left = 0;
        int right = 0;
        int maxLength = 0;
        int maxFreq = 0;
        int[] hash = new int[26];

        while(right<n){
            hash[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, hash[s.charAt(right) - 'A']);

            if((right-left+1) - maxFreq > k){
                hash[s.charAt(left) - 'A']--;
                //thi for loop is unnecessary watch the video for any doubt
                // for(int i=0; i<26; i++){
                //     maxFreq = Math.max(maxFreq,hash[i]);
                // }
                left++;
            }
            if((right-left+1) - maxFreq <= k){
                maxLength = Math.max(maxLength,right-left+1);
            }
            right++;
        }
        return maxLength;
    }
}