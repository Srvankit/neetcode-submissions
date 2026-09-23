class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    public void backtrack( int nums[], List<Integer> path, boolean[] used){
        if(path.size()== nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i =0; i<nums.length; i++){
            if(used[i]){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;

            backtrack(nums, path, used);

            path.remove(path.size()-1);
            used[i] = false;
        }
    }
}
