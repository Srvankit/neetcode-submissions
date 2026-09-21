class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    public void backtrack(int[] nums, int remsum, int start, List<Integer>currsum, List<List<Integer>>res){

        if(remsum == 0){
            res.add(new ArrayList<>(currsum));
            return;
        }
        if(remsum<0){
            return;
        }
        for(int i = start; i<nums.length; i++){
            if(i>start && nums[i]==nums[i-1]){
                continue;
            }
            currsum.add(nums[i]);

            backtrack(nums, remsum - nums[i], i+1, currsum, res);

            currsum.remove(currsum.size()-1);
    }
}   
}