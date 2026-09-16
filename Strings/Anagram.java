

public class Anagram{
    // BRUTE FORCE -->
    // TC: O(t)+O(s)+O(t+s)
    // SC: O(t+s)
    // public static void main(String args[]){
    //     String s = "car";
    //     String t = "rat";
    //     System.out.println(isAnagram(s,t));
    // }
    // public static boolean isAnagram(String s, String t){
    //     if(s.length() != t.length()){
    //         return false;
    //     }
    //     Map<Character,Integer> map = new HashMap<>();
        
    //     for(int i=0; i<s.length(); i++){
    //         if(map.containsKey(s.charAt(i))){
    //             map.put(s.charAt(i),map.get(s.charAt(i))+1);
    //         }
    //         else{
    //             map.put(s.charAt(i),1);
    //         }
    //     }
    //     for(int i=0; i<t.length(); i++){
    //         if(map.containsKey(s.charAt(i))){
    //             map.put(t.charAt(i),map.get(t.charAt(i))+1);
    //         }
    //         else{
    //            return false;
    //         }
    //     }
    //     for(char key: map.keySet()){
    //         if(map.get(key) != 0){
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    // OPTIMAL -->
    // TC: O(s)
    // SC: O(s)
    public static void main(String args[]){
        String s = "car";
        String t = "rac";
        System.out.println(isAnagram(s,t));
    }
    public static boolean isAnagram(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        int[] hash = new int[256];

        for(int i=0; i<s.length(); i++){
            hash[s.charAt(i)]++;
            hash[t.charAt(i)]--;
        }
        for(int x: hash){
            if(x != 0){
                return false;
            }
        }
        return true;
    }
}