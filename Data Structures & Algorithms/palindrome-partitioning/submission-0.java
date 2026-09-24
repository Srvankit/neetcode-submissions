class Solution {

    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtrack(s, 0, new ArrayList<>());
        return ans;
    }

    public void backtrack(String s, int start, List<String> path) {

        if(start == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i = start; i < s.length(); i++) {

            String substr = s.substring(start, i + 1);

            if(!isPalindrome(substr)) {
                continue;
            }

            path.add(substr);

            backtrack(s, i + 1, path);

            path.remove(path.size() - 1);
        }
    }

    public boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while(left < right) {

            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}