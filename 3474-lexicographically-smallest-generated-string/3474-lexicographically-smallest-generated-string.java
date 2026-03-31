class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        int len = n + m - 1;
        char[] res = new char[len];
        boolean[] fixed = new boolean[len];

        for (int i = 0; i < len; i++) res[i] = '?';

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    if (res[i + j] == '?' || res[i + j] == str2.charAt(j)) {
                        res[i + j] = str2.charAt(j);
                        fixed[i + j] = true;
                    } else {
                        return "";
                    }
                }
            }
        }

        for (int i = 0; i < len; i++) {
            if (res[i] == '?') res[i] = 'a';
        }

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {
                boolean match = true;
                for (int j = 0; j < m; j++) {
                    if (res[i + j] != str2.charAt(j)) {
                        match = false;
                        break;
                    }
                }

                if (match) {
                    boolean changed = false;
                    for (int j = m - 1; j >= 0; j--) {
                        int idx = i + j;
                        if (fixed[idx]) continue;

                        for (char c = 'a'; c <= 'z'; c++) {
                            if (c != str2.charAt(j)) {
                                res[idx] = c;
                                changed = true;
                                break;
                            }
                        }
                        if (changed) break;
                    }
                    if (!changed) return "";
                }
            }
        }

        return new String(res);
    }
}