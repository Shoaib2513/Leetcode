class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        int len = n + m - 1;
        char[] res = new char[len];
        for (int i = 0; i < len; i++) res[i] = '?';

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    if (res[i + j] == '?' || res[i + j] == str2.charAt(j)) {
                        res[i + j] = str2.charAt(j);
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
                        for (char c = 'a'; c <= 'z'; c++) {
                            if (c != str2.charAt(j)) {
                                char old = res[idx];
                                res[idx] = c;

                                boolean ok = true;
                                for (int k = Math.max(0, idx - m + 1); k <= Math.min(n - 1, idx); k++) {
                                    if (str1.charAt(k) == 'T') {
                                        for (int x = 0; x < m; x++) {
                                            if (res[k + x] != str2.charAt(x)) {
                                                ok = false;
                                                break;
                                            }
                                        }
                                        if (!ok) break;
                                    }
                                }

                                if (ok) {
                                    changed = true;
                                    break;
                                }
                                res[idx] = old;
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