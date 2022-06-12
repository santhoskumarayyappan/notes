* Time Complexity O(log*n)
```java
class DSU {
        int[] parent;
        int[] rank;
        int count; // componentsCount
        DSU(int n) {
            parent = new int[n];
            size = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }
        public int find(int i) {
            while (i != parent[i]) {
                i = parent[i] = parent[parent[i]]; // PathCompression
            }
            return i;
        }

        public void union(int i, int j) {
            int parentI = find(i);
            int parentJ = find(j);
            if (parentI != parentJ) {
                if (rank[parentI] > rank[parentJ]) { // UnionByRank
                    parent[parentJ] = parentI;
                } else if (rank[parentI] < rank[parentJ]) {
                    parent[parentI] = parentJ;
                } else {
                    parent[parentJ] = parentI;
                    rank[parentI]++;
                }
                count--;
            }
        }

        public boolean isConnected(int i, int j) {
            return getParent(i) == getParent(j);
        }
    }
```

