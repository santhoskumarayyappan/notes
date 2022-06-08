```java
class DSU {
        int[] parent;
        int[] size;
        DSU(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        public int getParent(int i) {
            while (i != parent[i]) {
                i = parent[i] =  parent[parent[i]]; // PathCompression
            }
            return i;
        }

        public void union(int i, int j) {
            int parentI = getParent(i);
            int parentJ = getParent(j);
            if (size[parentI] > size[parentJ]) { // Weighted Union
                size[parentI] += size[parentJ];
                parent[parentJ] = parentI;
            } else {
                size[parentJ] += size[parentI];
                parent[parentI] = parent[parentJ];
            }
        }

        public boolean find(int i, int j) {
            return getParent(i) == getParent(j);
        }
    }
```
