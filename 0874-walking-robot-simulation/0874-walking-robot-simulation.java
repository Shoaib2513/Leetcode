class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<>();
        for (int[] o : obstacles) {
            set.add(o[0] + "," + o[1]);
        }

        int x = 0, y = 0;
        int dir = 0;
        int[][] d = {{0,1},{1,0},{0,-1},{-1,0}};
        int max = 0;

        for (int cmd : commands) {
            if (cmd == -1) {
                dir = (dir + 1) % 4;
            } else if (cmd == -2) {
                dir = (dir + 3) % 4;
            } else {
                for (int i = 0; i < cmd; i++) {
                    int nx = x + d[dir][0];
                    int ny = y + d[dir][1];
                    if (set.contains(nx + "," + ny)) break;
                    x = nx;
                    y = ny;
                    max = Math.max(max, x * x + y * y);
                }
            }
        }

        return max;
    }
}