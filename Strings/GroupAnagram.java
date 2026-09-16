// Input: strs = ["eat","tea","tan","ate","nat","bat"]
// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram{

    // BRUTE FORCE -->
    // TC: O(n^2 * k) — n strings, each comparison costs O(k)
    // SC: O(n * k)
    // public static void main(String args[]){
    //     //if input we want as List of string
    //     // List<String> strs = List.of("eat","tea","tan","ate","nat","bat");
    //     String[] strs = {"eat","tea","tan","ate","nat","bat"};
    //     List<List<String>> result = groupAnagram(strs);

    //     for(int i=0; i<result.size(); i++){
    //         List<String> resultList = result.get(i);
    //         System.out.print(resultList+" ");
    //     }
    // }
    // public static List<List<String>> groupAnagram(String[] strs){
    //     List<List<String>> result = new ArrayList<>();
    //     boolean[] used = new boolean[strs.length];

    //     for(int i=0; i<strs.length; i++){
    //         if(used[i]){
    //             continue;
    //         }
    //         List<String> group = new ArrayList<>();
    //         group.add(strs[i]);
    //         used[i] = true;
    //         for(int j=i+1; j<strs.length; j++){
    //             if(!used[j] && isAnagram(strs[i],strs[j])){
    //                 group.add(strs[j]);
    //                 used[j] = true;
    //             }
    //         }
    //         result.add(group);
    //     }
    //     return result;
    // }
    // public static boolean isAnagram(String s, String t){
    //     if(s.length() != t.length()){
    //         return false;
    //     }
    //     int[] count = new int[256];
    //     for(int i=0; i<s.length(); i++){
    //         count[s.charAt(i)]++;
    //         count[t.charAt(i)]--;
    //     }
    //     for(int c: count){
    //         if(c != 0){
    //             return false;
    //         }
    //     }
    //     return true;
    // }


    // BETTER -->
    // TC: O(n * k log k)
    // SC: O(n * k)
    // public static void main(String args[]){
    //     String[] strs = {"eat","tea","tan","ate","nat","bat"};
    //     List<List<String>> result = groupAnagram(strs);

    //     for(int i=0; i<result.size(); i++){
    //         List<String> resultList = result.get(i);
    //         System.out.print(resultList+" ");
    //     }
    // }
    // public static List<List<String>> groupAnagram(String[] strs){
    //     // Map: key = sorted version of a word, value = list of all original words 
    //     // that produce that same sorted key (i.e., all anagrams of each other)
    //     Map<String, List<String>> anagramGroups = new HashMap<>();

    //     // Go through every word in the input array
    //     for (String word : strs) {

    //         // Convert the word into a char array so we can sort its letters
    //         char[] letters = word.toCharArray();
    //         Arrays.sort(letters);

    //         // Rebuild a string from the sorted letters.
    //         // Anagrams will always produce the SAME sorted string.
    //         // e.g. "eat" -> "aet", "tea" -> "aet", "ate" -> "aet"
    //         String sortedKey = new String(letters);

    //         // If we've never seen this sorted key before, 
    //         // create a new empty list for it
    //         if (!anagramGroups.containsKey(sortedKey)) {
    //             anagramGroups.put(sortedKey, new ArrayList<>());
    //         }

    //         // Add the original word into its corresponding group
    //         anagramGroups.get(sortedKey).add(word);
    //     }

    //     // The map's values are exactly the groups we need — 
    //     // just wrap them in a new List and return
    //     return new ArrayList<>(anagramGroups.values());
    // }


    // OPTIMAL -->
    // TC: O(n * k)
    // SC: O(n * k)
    public static void main(String args[]){
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = groupAnagram(strs);

        for(int i=0; i<result.size(); i++){
            List<String> resultList = result.get(i);
            System.out.print(resultList+" ");
        }
    }
    public static List<List<String>> groupAnagram(String[] strs){
        // Map: key = a "fingerprint" built from character counts,
        // value = list of all original words that share that fingerprint
        Map<String, List<String>> anagramGroups = new HashMap<>();

        // Go through every word in the input array
        for (String word : strs) {

            // Count how many times each letter (a-z) appears in this word.
            // Since constraints usually say lowercase English letters only,
            // a fixed-size array of 26 is enough.
            int[] letterCounts = new int[26];
            for (char c : word.toCharArray()) {
                letterCounts[c - 'a']++;
            }

            // Build a unique string key from the counts, e.g.
            // "eat" -> counts: a=1,e=1,t=1 -> key = "1#0#0#0#1#0#0#...#1#0..."
            // Anagrams will always produce the IDENTICAL key, 
            // because they have the exact same letter counts.
            StringBuilder keyBuilder = new StringBuilder();
            for (int count : letterCounts) {
                keyBuilder.append(count).append('#');
            }
            String key = keyBuilder.toString();

            // If we've never seen this fingerprint before,
            // create a new empty list for it
            if (!anagramGroups.containsKey(key)) {
                anagramGroups.put(key, new ArrayList<>());
            }

            // Add the original word into its corresponding group
            anagramGroups.get(key).add(word);
        }

        // The map's values are exactly the groups we need —
        // just wrap them in a new List and return
        return new ArrayList<>(anagramGroups.values());
    }
}