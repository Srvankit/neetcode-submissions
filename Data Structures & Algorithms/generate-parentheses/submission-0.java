class Solution {

    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(StringBuilder path, int open, int close, int n) {

        if(path.length() == 2 * n) {
            ans.add(path.toString());
            return;
        }

        if(open < n) {

            path.append('(');

            backtrack(path, open + 1, close, n);

            path.deleteCharAt(path.length() - 1);
        }

        if(close < open) {

            path.append(')');

            backtrack(path, open, close + 1, n);

            path.deleteCharAt(path.length() - 1);
        }
    }
}