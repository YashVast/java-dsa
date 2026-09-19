// if no 3rd unique no.present in array return the maximum number

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class ThridMaxNumber {
    // TC: O(n)+O(n log 3)
    // SC: O(d)+O(3)
    // public static void main(String[] args){
    //     int[] arr = {3,2,1};
    //     System.out.println(thirdMax(arr));
    // }
    // public static int thirdMax(int[] arr){
    //     Set<Integer> set = new HashSet<>();

    //     for(int x: arr){
    //         set.add(x);
    //     }
    //     if(set.size()<3){
    //         return Collections.max(set);
    //     }
    //     PriorityQueue<Integer> queue = new PriorityQueue<>();

    //     for(int x: set){
    //         queue.offer(x);
    //         if(queue.size()>3){
    //             queue.poll();
    //         }
    //     }
    //     return queue.peek();
    // }

    // TC: O(n log d)
    // SC: O(d)
    public static void main(String[] args){
        int[] arr = {3,2,1};
        System.out.println(thirdMax(arr));
    }
    public static int thirdMax(int[] arr){
        TreeSet<Integer> set = new TreeSet<>();

        for(int x: arr){
            set.add(x);
        }
        if(set.size()<3){
            return set.last();
        }
        Iterator<Integer> iterator = set.descendingIterator();
        int count = 0;

        while(iterator.hasNext()){
            int num = iterator.next();
            count++;
            if(count == 3){
                return num;
            }
        }
        throw new IllegalArgumentException("unknown error");
    }
}
