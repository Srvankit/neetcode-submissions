class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, target, 0, new ArrayList<>(), result);
        return result;
    }
    public void backtrack(int[]nums, int remtarget, int start,List<Integer>currcom,     List<List<Integer>>res){
        if(remtarget == 0){
            res.add(new ArrayList<>(currcom));
            return;
        }
        if(remtarget<0){
            return;
        }

        for(int i = start; i<nums.length; i++){
            currcom.add(nums[i]);
            backtrack(nums, remtarget-nums[i], i, currcom, res);
            currcom.remove(currcom.size()-1);
        }
    }
}
