package com.dsa.app.level1.dynamicprogramming._3_IncludeExclude;

public class _13_ArrangeBuildings {
    public static void main(String[] args) {

    }

    private int arrangeBuildings(int n) {
        int oldSpace = 1;
        int oldBuilding = 1;

        for (int index = 2; index <= n; index++) {
            int newSpace = oldBuilding;
            int newBuilding = oldSpace + oldBuilding;

            oldSpace = newSpace;
            oldBuilding = newBuilding;
        }
        int total = oldSpace + oldBuilding;
        return total * total;
    }
}
