class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer>map = new HashMap<>();
        int left =0;
        int right = 0;
        int count =0;
        int ans =0;

        while(right < s.length()){

            char ch = s.charAt(right);

            if(map.containsKey(ch) && map.get(ch)>=left){
                left =  map.get(ch)+1;
            }
            map.put(ch, right);

            count = right-left+1;
            ans = Math.max(count, ans);

            right++;
        }
        return ans;
    }
}
