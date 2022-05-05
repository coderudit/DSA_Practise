package com.dsa.app.final450.LinkedList;

public class LinkedListDS {
    private Node head;
    private Node tail;
    private int size;

    public LinkedListDS() {
        size = 0;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
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

    /*
    * Time complexity: O(n)
    * Space complexity: O(1)*/
    public Node reverseLinkedListByPointer(Node node) {
        Node previous = null;
        Node current = head;
        Node currentNext = null;
        while (current != null) {
            currentNext = current.getNext();
            current.setNext(previous);
            previous = current;
            current = currentNext;
        }
        node = previous;
        return node;
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

    private void oddEven() {
        LinkedListDS odd = new LinkedListDS();
        LinkedListDS even = new LinkedListDS();

        while (getSize() > 0) {
            int value = this.getFirst();
            this.removeFirst();

            if (value % 2 == 0)
                even.addLast(value);
            else
                odd.addLast(value);
        }

        if (odd.getSize() > 0 && even.getSize() > 0) {
            odd.getTail().setNext(even.getHead());
            this.head = odd.getHead();
            this.tail = even.getTail();
            this.size = odd.getSize() + even.getSize();
        } else if (odd.getSize() > 0) {
            this.head = odd.getHead();
            this.tail = odd.getTail();
            this.size = odd.getSize();
        }else if (even.getSize() > 0) {
            this.head = even.getHead();
            this.tail = even.getTail();
            this.size = even.getSize();
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
