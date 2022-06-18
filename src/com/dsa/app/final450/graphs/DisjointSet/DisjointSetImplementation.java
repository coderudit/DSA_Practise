package com.dsa.app.final450.graphs.DisjointSet;

public class DisjointSetImplementation {
    public static void main(String[] args) {
        QuickFind uf = new QuickFind(10);
        // 1-2-5-6-7 3-8-9 4
        uf.union(1, 2);
        uf.union(2, 5);
        uf.union(5, 6);
        uf.union(6, 7);
        uf.union(3, 8);
        uf.union(8, 9);
        System.out.println(uf.connected(1, 5)); // true
        System.out.println(uf.connected(5, 7)); // true
        System.out.println(uf.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        uf.union(9, 4);
        System.out.println(uf.connected(4, 9)); // true
    }
}

class QuickFind {
    private int[] root;

    /*
     * When initializing a union-find constructor, we need to create an array of
     * size NN with the values equal to the corresponding array indices; this
     * requires linear time.
     * */
    public QuickFind(int size) {
        root = new int[size];

        //Initialize root array with their corresponding indexes, as at starting
        //each node is parent to itself.
        for (int index = 0; index < size; index++) {
            root[index] = index;
        }
    }

    /**
     * Each call to find will require O(1)time since we are just accessing an
     * element of the array at the given index.
     */
    public int find(int x) {
        return root[x];
    }

    /**
     * Each call to union will require O(N) time because we need to traverse
     * through the entire array and update the root vertices for all the vertices
     * of the set that is going to be merged into another set.
     *
     * @param x
     * @param y
     */
    public void union(int x, int y) {
        //Find the root of x and y.
        int rootX = find(x);
        int rootY = find(y);

        //If the roots are not equal then only perform the union.
        if (rootX != rootY) {
            for (int index = 0; index < root.length; index++) {
                //All the nodes where root y is the parent, put root x as there,
                //new parent.
                if (root[index] == rootY) {
                    root[index] = rootX;
                }
            }
        }
    }

    /**
     * The connected operation takes O(1) time since it involves the two find
     * calls and the equality check operation.
     *
     * @param x
     * @param y
     * @return
     */
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

}

class QuickUnion {
    private int[] root;

    public QuickUnion(int size) {
        root = new int[size];

        //Initialize root array with their corresponding indexes, as at starting
        //each node is parent to itself.
        for (int index = 0; index < size; index++) {
            root[index] = index;
        }
    }

    /**
     * For the find operation, in the worst-case scenario, we need to traverse
     * every vertex to find the root for the input vertex. The maximum number of
     * operations to get the root vertex would be no more than the tree's height,
     * so it will take O(N) time.
     */
    public int find(int x) {
        while (x != root[x])
            x = root[x];
        return x;
    }

    /*
     * The union operation consists of two find operations which
     * (only in the worst-case) will take O(N) time, and two constant time
     * operations, including the equality check and updating the array value at a
     * given index. Therefore, the union operation also costs O(N) in the
     * worst-case.*/
    public void union(int x, int y) {
        //Find the root of x and y.
        int rootX = find(x);
        int rootY = find(y);

        //If the roots are not equal then only perform the union.
        if (rootX != rootY) {
            root[rootY] = rootX;
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

}

class UnionByRank{
    private int[] root;
    private int[] rank;

    public UnionByRank(int size){
        root = new int[size];
        rank = new int[size];

        for(int index = 0; index < size; index++){
            root[index] = index;
            rank[index] = 1;
        }
    }

    public int find(int x){
        while(x != root[x]){
            x = root[x];
        }
        return x;
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if(rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootY] > rank[rootX]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}

class PathCompression {
    private int[] root;

    public PathCompression(int size) {
        root = new int[size];

        //Initialize root array with their corresponding indexes, as at starting
        //each node is parent to itself.
        for (int index = 0; index < size; index++) {
            root[index] = index;
        }
    }

    /**
     * For the find operation, in the worst-case scenario, we need to traverse
     * every vertex to find the root for the input vertex. The maximum number of
     * operations to get the root vertex would be no more than the tree's height,
     * so it will take O(N) time.
     */
    public int find(int x) {
       if(x == root[x]){
           return x;
       }
       return root[x] = find(root[x]);
    }

    /*
     * The union operation consists of two find operations which
     * (only in the worst-case) will take O(N) time, and two constant time
     * operations, including the equality check and updating the array value at a
     * given index. Therefore, the union operation also costs O(N) in the
     * worst-case.*/
    public void union(int x, int y) {
        //Find the root of x and y.
        int rootX = find(x);
        int rootY = find(y);

        //If the roots are not equal then only perform the union.
        if (rootX != rootY) {
            root[rootY] = rootX;
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

}

/*
* Optimized disjoint set with Union by Rank and Path Compression.*/
class OptimizedDisjointSet{
    private int[] root;
    private int[] rank;

    public OptimizedDisjointSet(int size){
        root = new int[size];
        rank = new int[size];

        for(int index = 0; index < size; index++){
            root[index] = index;
            rank[index] = 1;
        }
    }

    public int find(int x){
        if(x == root[x])
            return x;
        return root[x] = find(root[x]);
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if(rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootY] > rank[rootX]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}