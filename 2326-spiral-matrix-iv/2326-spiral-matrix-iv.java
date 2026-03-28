class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = -1;
            }
        }

        int rs = 0, cs = 0, re = m - 1, ce = n - 1;
        ListNode temp = head;

        while (temp != null && rs <= re && cs <= ce) {
            for (int j = cs; j <= ce && temp != null; j++) {
                arr[rs][j] = temp.val;
                temp = temp.next;
            }
            rs++;
            for (int i = rs; i <= re && temp != null; i++) {
                arr[i][ce] = temp.val;
                temp = temp.next;
            }
            ce--;
            for (int j = ce; j >= cs && temp != null; j--) {
                arr[re][j] = temp.val;
                temp = temp.next;
            }
            re--;
            for (int i = re; i >= rs && temp != null; i--) {
                arr[i][cs] = temp.val;
                temp = temp.next;
            }
            cs++;
        }
        return arr;
    }
}