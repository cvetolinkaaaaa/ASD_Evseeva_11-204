public class UnionFind {
    private int[] parent;
    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    public int find(int index) {
        while (parent[index] != index) {
            index = parent[index];
        }
        return index;
    }
    public void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootA] = rootB;
        }
    }

}
