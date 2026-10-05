class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for( int n : nums){
            pq.offer(n);
        }
        int ans =0;
        int i =0;
        while( i<k){
             ans = pq.poll();
             i++;
        }
        return ans;
    }
}
