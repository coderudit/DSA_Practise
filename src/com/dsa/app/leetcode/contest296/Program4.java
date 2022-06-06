package com.dsa.app.leetcode.contest296;

public class Program4 {

    StringBuilder tempText;
    int cursor = 0;

    public static void main(String[] args) {
        Program4 problem = new Program4();
        problem.addText("leetcode");
    }

    public Program4() {
        tempText = new StringBuilder("|");
    }

    public void addText(String text) {
        tempText.insert(cursor, text);
        cursor += text.length();
    }

    public int deleteText(int k) {
        int startIndex = Math.max(0, cursor - k);
        tempText.delete(startIndex, cursor);
        int elementsDeleted = cursor - startIndex;
        cursor = Math.max(0, startIndex);
        return elementsDeleted;
    }

    public String cursorLeft(int k) {
        cursor = Math.max(0, cursor - k);
        return tempText.substring(Math.max(0, cursor - 10), cursor);
    }

    public String cursorRight(int k) {
        cursor = Math.min(cursor + k, tempText.length());
        return tempText.substring(Math.max(0, cursor - 10), cursor);
    }

}
