class Solution {
    public void solve(int idx, String digits, String[] map, StringBuilder curr, List<String> ans) {
        if (idx == digits.length()) {
            ans.add(curr.toString());
            return;
        }

        String letters = map[digits.charAt(idx) - '0'];

        for (int i = 0; i < letters.length(); i++) {
            curr.append(letters.charAt(i));   
            solve(idx + 1, digits, map, curr, ans);
            curr.deleteCharAt(curr.length() - 1); 
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if (digits.length() == 0) return ans;

        String[] map = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        solve(0, digits, map, new StringBuilder(), ans);

        return ans;
    }
}