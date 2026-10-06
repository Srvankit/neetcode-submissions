class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for( char t : tasks){
            freq[t-'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for( int f : freq){
            if(f>0){
                pq.offer(f);
            }
        }

        int totaltime = 0;
        
        while(!pq.isEmpty()){

            List<Integer> lst = new ArrayList<>();
            int slots = n+1;

            while( slots >0 && !pq.isEmpty()){
                int current = pq.poll();
                current--;

                if( current>0){
                    lst.add(current);
                }
                totaltime++;
                slots--;
            }

            for(int f : lst){
                pq.offer(f);
            }
            if(!pq.isEmpty()){
                totaltime+=slots;
            }
        }
        return totaltime;
    }
}
