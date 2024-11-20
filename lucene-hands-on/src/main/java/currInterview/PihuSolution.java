package currInterview;

import java.nio.ByteBuffer;
import java.util.*;

class PihuSolution {
    static class CustomData{
        String lock;
        int dis;
        public CustomData( String lock, int dis){
            this.lock = lock;
            this.dis = dis;
        }
    }
    public int openLock(String[] deadends, String target) {

        String start = "0000";
        Set<String> deadSet = new HashSet<>();
        for( String str: deadends ){
            deadSet.add( str );
        }

        Queue<CustomData> queue = new LinkedList<>();
        queue.add( new CustomData( start, 0) );

        while( !queue.isEmpty() ){
            CustomData currCD = queue.poll();
            deadSet.add( currCD.lock);
            if( currCD.lock.equals( target) ){
                return currCD.dis;
            }

            populateQueueWithNeig( queue, currCD, deadSet, target );
        }
        return -1;

    }
    private void populateQueueWithNeig(  Queue<CustomData> queue , CustomData cd, Set<String> deadSet, String target ){
        String currentString = cd.lock;
        int nextDis = cd.dis +1;
        StringBuilder sb;
        char[] tempString = currentString.toCharArray();
        for( int i = 0;i<4 ;i++){
            for( int dir = -1 ;dir< 2 ;dir++){
                if( dir == 0){
                    continue;
                }
                char preCh = tempString[i];
                if( tempString[i] == '9' && dir == 1){
                    tempString[i] = '0';
                }else if( tempString[i] == '0' && dir == -1){
                    tempString[i] = '9';
                }else{
                    tempString[i] = (char) (tempString[i] + dir);
                }

                String tempStr = new String(tempString);
                if( !deadSet.contains( tempStr ) ){
                    queue.add( new CustomData( tempStr , nextDis) );
                    deadSet.add( tempStr );
                }
                tempString[i] = preCh;
            }

        }

    }

//    public static void main(String args[] ) throws Exception {
//
//        PihuSolution pihuSolution = new PihuSolution();
//
//        System.out.println( pihuSolution.openLock(new String[]{"0201","0101","0102","1212","2002"}, "0202"));
//
//    }

    public static String convertUUIDToBase64(UUID uuid) {
        // Convert UUID to a byte array
        ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[16]);
        byteBuffer.putLong(uuid.getMostSignificantBits());
        byteBuffer.putLong(uuid.getLeastSignificantBits());

        // Encode byte array to Base64 string
        String base64UUID = Base64.getUrlEncoder().withoutPadding().encodeToString(byteBuffer.array());
        return base64UUID;
    }

    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        String base64EncodedUUID = convertUUIDToBase64(uuid);
        System.out.println("Original UUID: " + uuid);
        System.out.println("Base64 Encoded UUID: " + base64EncodedUUID);
    }
}

