import java.util.Arrays;

public class NumberOfSubstringsContainingAllThreeCharacters {
    // BRUTE FORCE --> 
    // TC: O(n*2)
    // SC: O(3)
    // 'a' - 'a' = 97 - 97 = 0
    // 'b' - 'a' = 98 - 97 = 1
    // 'c' - 'a' = 99 - 97 = 2
    //yeh 0,1,2 indexes hai jisme 1 value daali hai --> hash[s.charAt(j) - 'a'] = 1;
    // public static void main(String args[]){
    //     String s = "bbacba";
    //     System.out.println(numberOfSubstrings(s));
    // }
    // public static int numberOfSubstrings(String s){
    //     int n = s.length();
    //     int count = 0;

    //     for(int i=0; i<n; i++){
    //         int[] hash = new int[3];
    //         for(int j=i; j<n; j++){
    //             hash[s.charAt(j) - 'a'] = 1;
    //             if(hash[0]+hash[1]+hash[2] == 3){
    //                 count++;
    //             }
    //         }
    //     }
    //     return count;
    // }

    // BETTER -->
    // TC: O(n*2)
    // SC: O(3)
    // public static void main(String args[]){
    //     String s = "bbacba";
    //     System.out.println(numberOfSubstrings(s));
    // }
    // public static int numberOfSubstrings(String s){
    //     int n = s.length();
    //     int count = 0;

    //     for(int i=0; i<n; i++){
    //         int[] hash = new int[3];
    //         for(int j=i; j<n; j++){
    //             hash[s.charAt(j) - 'a'] = 1;
    //             if(hash[0]+hash[1]+hash[2] == 3){
    //                 count += n-j;
    //                 break;
    //             }
    //         }
    //     }
    //     return count;
    // }

    // OPTIMAL -->
    // TC: O(n)
    // SC: O(3)
    public static void main(String args[]){
        String s = "bbacba";
        System.out.println(numberOfSubstrings(s));
    }
    public static int numberOfSubstrings(String s){
        int n = s.length();
        int count = 0;
        int[] hash = new int[3];
        Arrays.fill(hash,-1);

        for(int i=0; i<n; i++){
            hash[s.charAt(i) - 'a'] = i;
            if(hash[0] != -1 && hash[1] != -1 && hash[2] != -1){
                count += 1 + Math.min(hash[0],Math.min(hash[1],hash[2])); 
            }
        }
        return count;
    }
}
