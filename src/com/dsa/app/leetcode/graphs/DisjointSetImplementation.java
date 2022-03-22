package com.dsa.app.leetcode.graphs;

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

    public QuickFind(int size) {
        root = new int[size];

        //Initialize root array with their corresponding indexes, as at starting
        //each node is parent to itself.
        for (int index = 0; index < size; index++) {
            root[index] = index;
        }
    }

    /**
     * Returns the root index of the element.
     */
    public int find(int x) {
        return root[x];
    }

    public void union(int x, int y) {
        //Find the root of x and y.
        int rootX = find(x);
        int rootY = find(y);

        //If the roots are not equal then only perform the union.
        if (rootX != rootY) {
            for (int index = 0; index < root.length; index++) {
                if (root[index] == rootY) {
                    root[index] = rootX;
                }
            }
        }
    }

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
     * Returns the root index of the element.
     * In Quick Union, root index is when index
     * and value at that index matches.
     */
    public int find(int x) {
        while (x != root[x])
            x = root[x];
        return x;
    }

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