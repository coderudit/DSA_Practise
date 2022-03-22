package com.dsa.app.leetcode.contest284;

import java.util.ArrayList;
import java.util.List;

public class Program2 {

    public static void main(String[] args) {
        Program2 obj = new Program2();
        int[][] artifacts = {{0, 0, 0, 0}, {0, 1, 1, 1}};
        int[][] dig = {{0, 0}, {0, 1}, {1, 1}};
        obj.digArtifacts(2, artifacts, dig);
    }

    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        List<Artifact> artifactsList = new ArrayList<>();
        for (int rowIndex = 0; rowIndex < artifacts.length; rowIndex++) {
            Artifact artifact = new Artifact(artifacts[rowIndex][0], artifacts[rowIndex][1], artifacts[rowIndex][2], artifacts[rowIndex][3]);
            artifactsList.add(artifact);
        }

        for (var artifact : artifactsList) {
            for (int rowIndex = 0; rowIndex < dig.length; rowIndex++) {
                if (artifact.getDigsRequired()[0][0] == dig[rowIndex][0] && artifact.getDigsRequired()[0][1] == dig[rowIndex][1])
                    artifact.setTopLeftDone(true);
                if (artifact.getDigsRequired()[1][0] == dig[rowIndex][0] && artifact.getDigsRequired()[1][1] == dig[rowIndex][1])
                    artifact.setBottomRightDone(true);
                if (artifact.isTopLeftDone() == true && artifact.isBottomRightDone() == true)
                    break;
            }
        }

        System.out.println(artifactsList.stream().filter(x -> x.isTopLeftDone() == true && x.isBottomRightDone() == true).count());
        return (int) artifactsList.stream().filter(x -> x.isTopLeftDone() == true && x.isBottomRightDone() == true).count();
    }


}

class Artifact {
    private int[][] digsRequired;
    private boolean topLeftDone;
    private boolean bottomRightDone;
    int topLeftRow;
    int topLeftColumn;
    int bottomRightRow;
    int bottomRightColum;

    public Artifact(int topLeftRow, int topLeftColumn, int bottomRightRow, int bottomRightColum) {
        digsRequired = new int[2][2];
        digsRequired[0][0] = this.topLeftRow = topLeftRow;
        digsRequired[0][1] = this.topLeftColumn = topLeftColumn;
        digsRequired[1][0] = this.bottomRightRow = bottomRightRow;
        digsRequired[1][1] = this.bottomRightColum = bottomRightColum;
    }

    public int[][] getDigsRequired() {
        return digsRequired;
    }

    public boolean isTopLeftDone() {
        return topLeftDone;
    }

    public void setTopLeftDone(boolean topLeftDone) {
        System.out.println("topLeftRow" + topLeftRow);
        System.out.println("topLeftColumn" + topLeftColumn);
        if (digsRequired[topLeftRow][topLeftColumn] == digsRequired[bottomRightRow][bottomRightColum])
            this.topLeftDone = true;
        else {
            if (topLeftRow < bottomRightRow-1)
                topLeftRow++;
            if (topLeftColumn < bottomRightColum-1)
                topLeftColumn++;
        }
    }

    public boolean isBottomRightDone() {
        return bottomRightDone;
    }

    public void setBottomRightDone(boolean bottomRightDone) {
        this.bottomRightDone = bottomRightDone;
        if (topLeftRow < bottomRightRow - 1 && topLeftColumn < bottomRightColum - 1)
            this.topLeftDone = true;
    }
}

