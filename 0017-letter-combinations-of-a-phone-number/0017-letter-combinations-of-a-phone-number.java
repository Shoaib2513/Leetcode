class Solution {
    public void solve(int idx, String digits, String[] map, String curr, List<String> ans) {
        if (idx == digits.length()) {
            ans.add(curr);
            return;
        }

        String letters = map[digits.charAt(idx) - '0'];

        for (int i = 0; i < letters.length(); i++) {
            solve(idx + 1, digits, map, curr + letters.charAt(i), ans);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if (digits.length() == 0) return ans;

        String[] map = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        solve(0, digits, map, "", ans);

        return ans;
    }
}