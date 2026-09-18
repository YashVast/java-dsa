

public class MinimumNumberOfStepsToMakeTwoStringsAnagram{

    // BRUTE FORCE -->
    // TC: O(s)+O(t)+O(s)
    // SC: O(s)+O(t)
    // public static void main(String[] args){
    //     String s = "leetcode";
    //     String t = "practice";

    //     System.out.println(minimumSteps(s,t));
    // }
    // public static int minimumSteps(String s, String t){
    //     Map<Character,Integer> sMap = new HashMap<>();
    //     Map<Character,Integer> tMap = new HashMap<>();

    //     for(char c : s.toCharArray()){
    //         if(sMap.containsKey(c)){
    //             sMap.put(c,sMap.get(c)+1);
    //         }
    //         else{
    //             sMap.put(c,1);
    //         }
    //     }
    //     for(char c: t.toCharArray()){
    //         if(tMap.containsKey(c)){
    //             tMap.put(c,tMap.get(c)+1);
    //         }
    //         else{
    //             tMap.put(c,1);
    //         }
    //     }
    //     int steps = 0;

    //     for(char key : sMap.keySet()){
    //         int needed = sMap.get(key) - tMap.getOrDefault(key, 0);
    //         if(needed > 0){
    //             steps += needed;
    //         }
    //     }
    //     return steps;
    // }

    // BETTER -->
    // TC: O(s)+O(t)+O(s+t)
    // SC: O(s)+O(t)
    // public static void main(String[] args){
    //     String s = "leetcode";
    //     String t = "practice";

    //     System.out.println(minimumSteps(s,t));
    // }
    // public static int minimumSteps(String s, String t){
    //     Map<Character,Integer> diff = new HashMap<>();

    //     for(char c: s.toCharArray()){
    //         diff.put(c,diff.getOrDefault(c, 0)+1);
    //     }
    //     for(char c: t.toCharArray()){
    //         diff.put(c,diff.getOrDefault(c, 0)-1);
    //     }

    //     int steps = 0;
    //     for(int count : diff.values()){
    //         if(count>0){
    //             steps += count;
    //         }
    //     }
    //     return steps;
    // }

    // OPTIMAL -->
    // TC: O(s+t)+O(s+t) = O(2n)  --> n=s+t
    // SC: O(26)+O(1)= O(1)
    public static void main(String[] args){
        String s = "leetcode";
        String t = "practice";

        System.out.println(minimumSteps(s,t));
    }
    public static int minimumSteps(String s,String t){
        int[] diff = new int[26];

        for(int i=0; i<s.length(); i++){
            diff[s.charAt(i) - 'a']++;
            diff[t.charAt(i) - 'a']--;
        }
        int steps = 0;
        for(int count : diff){
            if(count>0){
                steps += count;
            }
        }
        return steps;
    }
}