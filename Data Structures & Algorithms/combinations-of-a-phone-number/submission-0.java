class Solution {

    List<String> ans = new ArrayList<>();

    String[] map = {
        "", "", "abc", "def",
        "ghi", "jkl", "mno",
        "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {

        if(digits.length() == 0) {
            return ans;
        }

        backtrack(digits, 0, new StringBuilder());

        return ans;
    }

    public void backtrack(String digits, int index, StringBuilder path) {

        // Complete combination
        if(index == digits.length()) {
            ans.add(path.toString());
            return;
        }

        // Get letters for current digit
        String letters = map[digits.charAt(index) - '0'];

        for(int i = 0; i < letters.length(); i++) {

            // Choose
            path.append(letters.charAt(i));

            // Explore
            backtrack(digits, index + 1, path);

            // Undo
            path.deleteCharAt(path.length() - 1);
        }
    }
}