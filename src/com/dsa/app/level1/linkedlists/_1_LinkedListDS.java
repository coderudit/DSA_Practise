package com.dsa.app.level1.linkedlists;

public class LinkedListDS {
    private Node head;
    private Node tail;
    private int size;

    public LinkedListDS() {
        size = 0;
    }

    public void addLast(int value) {
        Node tempNode = new Node(value);
        if (size == 0) {
            head = tempNode;
        } else {
            tail.setNext(tempNode);
        }
        tail = tempNode;
        size++;
    }

    public int getSize() {
        return size;
    }

    public void display() {
        Node tempNode = head;
        while (tempNode != null) {
            System.out.println(tempNode.getData());
            tempNode = tempNode.getNext();
        }
    }

    public void removeFirst() {
        if (size == 0) {
            System.out.println("No element present.");
        } else if (size == 1) {
            System.out.println("Removed " + head.getData());
            head = tail = null;
            size = 0;
        } else {
            System.out.println("Removed " + head.getData());
            head = head.getNext();
            size--;
        }
    }

    public int getFirst() {
        if (size == 0)
            return -1;
        return head.getData();
    }

    public int getLast() {
        if (size == 0)
            return -1;
        return tail.getData();
    }

    public int getAt(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        Node tempNode = head;
        int currentIndex = 0;
        while (currentIndex < index) {
            tempNode = tempNode.getNext();
            currentIndex++;
        }
        return tempNode.getData();
    }

    public void addFirst(int value) {
        Node node = new Node(value);
        node.setNext(head);
        head = node;
        if (size == 0) {
            tail = node;
        }
        size++;
    }

    public void addAt(int index, int value) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index.");
        } else if (index == 0)
            addFirst(value);
        else if (index == size)
            addLast(value);
        else {
            Node node = new Node(value);
            int currentIndex = 0;
            Node tempNode = head;
            while (currentIndex < index - 1) {
                tempNode = tempNode.getNext();
                currentIndex++;
            }
            Node oldNext = tempNode.getNext();
            node.setNext(oldNext);
            tempNode.setNext(node);
            size++;
        }
    }

    public void removeLast() {
        if (size == 0) {
            System.out.println("List empty.");
        } else if (size == 1) {
            head = tail = null;
            size = 0;
        } else {
            Node tempNode = head;
            int currentIndex = 0;
            while (currentIndex < size - 2) {
                tempNode = tempNode.getNext();
                currentIndex++;
            }
            tail = tempNode;
            tempNode.setNext(null);
            size--;
        }

    }

    public Node getNodeAt(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node tempNode = head;
        int currentIndex = 0;
        while (currentIndex < index) {
            tempNode = tempNode.getNext();
            currentIndex++;
        }
        return tempNode;
    }

    /*
     *O(n * n)
     * */
    public void reverseLinkedListByData() {
        int leftIndex = 0;
        int rightIndex = size - 1;

        while (leftIndex < rightIndex) {
            Node leftNode = getNodeAt(leftIndex);
            Node rightNode = getNodeAt(rightIndex);
            int temp = leftNode.getData();
            leftNode.setData(rightNode.getData());
            rightNode.setData(temp);
            leftIndex++;
            rightIndex--;
        }
    }

    public void reverseLinkedListByPointer() {
        Node previous = null;
        Node current = head;
        while (current != null) {
            Node currentNext = current.getNext();
            current.setNext(previous);
            previous = current;
            current = currentNext;
        }
        Node temp = head;
        head = tail;
        tail = temp;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index.");
        } else if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            int currentIndex = index;
            Node tempNode = head;
            while (currentIndex < index - 1) {
                tempNode = tempNode.getNext();
                currentIndex++;
            }
            Node newNext = tempNode.getNext().getNext();
            tempNode.setNext(newNext);
            size--;
        }
    }
}

class Node {
    private int data;
    private Node next;

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
