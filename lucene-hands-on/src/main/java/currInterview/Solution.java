package currInterview;

//public class Solution {
//    public static void main(String[] args) {
//        System.out.println( "Starting Solution");
//    }
//}

import java.util.*;

public class Solution {
    // 52 cards List<String> ;
    // 1, 2,3,5 ....52
    // _
    // postion = Random (0,52)
    // Random = Math.random( 0,52);

    public static int leastInterval(char[] input, int n) {
        Map<Character, Integer> freqMap = new HashMap<>(input.length);
        PriorityQueue<Map.Entry<Character, Integer>> queue1 = new PriorityQueue<>((a,b) ->{
            return b.getValue().compareTo( a.getValue());
        });
        PriorityQueue<Map.Entry<Character, Integer>> tempQueue;

        // Build frequency map
        for (char ch : input) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // Add entries to the priority queue
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            queue1.add(entry);
        }

        StringBuilder sb = new StringBuilder();

        while (true) {
            int size = queue1.size();
            tempQueue = new PriorityQueue<>((a,b) ->{
                return b.getValue().compareTo( a.getValue());
            });

            while (!queue1.isEmpty()) {
                Map.Entry<Character, Integer> currEntry = queue1.poll();
                char currCh = currEntry.getKey();
                int freqCh = currEntry.getValue();

                if (freqCh - 1 > 0) {
                    currEntry.setValue(freqCh - 1);
                    tempQueue.add(currEntry);
                }

                sb.append(currCh);
            }

            if (tempQueue.isEmpty()) {
                break;
            }

            while (size++ < n ) {
                sb.append('-');
            }

            queue1 = tempQueue;
        }

        return sb.length();
    }
    //
    public static void main(String args[] ) throws Exception {
//        int [] cards = new int [52];
//        Set<Integer> usedCards = new HashSet<>();
//        for( int i =0;i< 52;i++){
//            int curr = getRandomNumber();
//            while( usedCards.contains( curr ) ){
//                curr = getRandomNumber();
//            }
//            cards[i] = curr;
//            usedCards.add( curr );
//        }
//
//
//        for( int i =0;i< 52;i++){
//            System.out.println( i +" "+  cards[i] );
//        }
//        System.out.println( cards );println
//['B','C','D','A','A','A','A','G']
        System.out.println( leastInterval(new char[]{'B','C','D','A','A','A','A','G'}, 1));

    }

    private static int getRandomNumber( ){
        return ( (int)(Math.random()*100) )  % 52;
    }
}
