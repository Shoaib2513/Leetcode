
class UnionFind {

    int[] parent;

    UnionFind(int[] base) {
        parent = base.clone();
    }

    int root(int x) {
        if (parent[x] != x) {
            parent[x] = root(parent[x]);
        }
        return parent[x];
    }

    void connect(int a, int b) {
        int pa = root(a);
        int pb = root(b);
        parent[pa] = pb;
    }
}

class Solution {

    private static final int LIMIT = 200000;

    public int maxStability(int n, int[][] edges, int k) {

        if (edges.length < n - 1) return -1;

        List<int[]> required = new ArrayList<>();
        List<int[]> optional = new ArrayList<>();

        for (int[] e : edges) {
            if (e[3] == 1) required.add(e);
            else optional.add(e);
        }

        if (required.size() > n - 1) return -1;

        optional.sort((a, b) -> b[2] - a[2]);

        int[] baseParent = new int[n];
        for (int i = 0; i < n; i++) baseParent[i] = i;

        UnionFind baseUF = new UnionFind(baseParent);

        int usedEdges = 0;
        int minRequiredStrength = LIMIT;

        for (int[] e : required) {

            int u = e[0];
            int v = e[1];
            int s = e[2];

            if (baseUF.root(u) == baseUF.root(v) || usedEdges == n - 1)
                return -1;

            baseUF.connect(u, v);
            usedEdges++;

            minRequiredStrength = Math.min(minRequiredStrength, s);
        }

        int left = 0;
        int right = minRequiredStrength;
        int answer = -1;

        while (left <= right) {

            int target = left + (right - left) / 2;

            UnionFind uf = new UnionFind(baseUF.parent);

            int count = usedEdges;
            int upgrades = 0;

            for (int[] e : optional) {

                int u = e[0];
                int v = e[1];
                int strength = e[2];

                if (uf.root(u) == uf.root(v)) continue;

                if (strength >= target) {
                    uf.connect(u, v);
                    count++;
                }
                else if (upgrades < k && strength * 2 >= target) {
                    upgrades++;
                    uf.connect(u, v);
                    count++;
                }
                else {
                    break;
                }

                if (count == n - 1) break;
            }

            if (count == n - 1) {
                answer = target;
                left = target + 1;
            } else {
                right = target - 1;
            }
        }

        return answer;
    }
}