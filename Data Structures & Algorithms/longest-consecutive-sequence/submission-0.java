class Solution {
    public int longestConsecutive(int[] nums) {
        int cn = 0;
        int cs =0;
        int ls =0;
        Set<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);

        for(int num : set){
            if(!set.contains(num-1)){
                cn = num;
                cs =1;
            }
            while(set.contains(cn+1)){
                cn +=1;
                cs +=1;
            }
            ls = Math.max(ls, cs);
        }
    return ls;
}
}
