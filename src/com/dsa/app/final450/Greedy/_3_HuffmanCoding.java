package com.dsa.app.final450.Greedy;

import java.util.*;

public class _3_HuffmanCoding {
    public static void main(String[] args) {
        _3_HuffmanCoding program = new _3_HuffmanCoding();
        String distinctChars = "abcdef";
        int[] frequency = {5, 9, 12, 13, 16, 45};
        program.createHuffmanCoding(distinctChars, frequency);
    }

    private void createHuffmanCoding(String distinctChars, int[] frequency) {
        PriorityQueue<Node> nodes = new PriorityQueue<>(new NodeComparator());
        for (int index = 0; index < frequency.length; index++) {
            nodes.add(new Node(distinctChars.substring(index, index + 1), frequency[index]));
        }

        while (nodes.size() > 1) {
            Node firstNode = nodes.poll();
            Node secondNode = nodes.poll();

            Node newNode = new Node(firstNode.getStr() + secondNode.getStr(), firstNode.getFrequency() + secondNode.getFrequency());
            newNode.setLChild(firstNode);
            newNode.setRChild(secondNode);
            nodes.add(newNode);
        }
        printEncoding(nodes.poll(), "");
        System.out.println();
    }

    private void printEncoding(Node node, String psf) {
        if (node.getLChild() == null && node.getRChild() == null) {
            System.out.println(node.getStr() + " -> " + psf);
        }

        if (node.getLChild() != null)
            printEncoding(node.getLChild(), psf + "0");
        if (node.getRChild() != null)
            printEncoding(node.getRChild(), psf + "1");
    }


}

class Node {
    private String str;
    private int frequency;
    private Node lChild;
    private Node rChild;

    public Node(String str, int frequency) {
        this.str = str;
        this.frequency = frequency;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public Node getLChild() {
        return lChild;
    }

    public void setLChild(Node lChild) {
        this.lChild = lChild;
    }

    public Node getRChild() {
        return rChild;
    }

    public void setRChild(Node rChild) {
        this.rChild = rChild;
    }
}

class NodeComparator implements Comparator<Node> {

    @Override
    public int compare(Node o1, Node o2) {
        if (o1.getFrequency() >= o2.getFrequency())
            return 1;
        else
            return -1;
    }
}
