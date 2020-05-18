package com.bridgelabz.list;

public class DoublyLinkedList {
    class Node {
        Node prev;
        Object data;
        Node next;

        Node(Object data) {
            this.data = data;
        }
    }

    Node head;

    public boolean add(Object data) {
        Node nodeReference = new Node(data);
        if (head == null) {
            head = nodeReference;
            return true;
        }
        Node traverse = head;
        while (traverse.next != null)
            traverse = traverse.next;

        traverse.next = nodeReference;
        nodeReference.prev = traverse;
        return true;
    }

    public boolean add(int index, Object data) {
        Node nodeReferance = new Node(data);
        if (index == 0) {
            nodeReferance.next = head.prev;
            head = nodeReferance;
            return true;
        }
        Node traverse = head;
        while (index > 1 && traverse != null) {
            traverse = traverse.next;
            index--;
        }
        if (traverse == null) {
            return false;
        }
        nodeReferance.prev = traverse.next;
        nodeReferance.next = traverse.next.next;
        traverse.next = nodeReferance;
        return true;
    }

    public boolean addFirst(Object data) {
        Node nodeReference = new Node(data);
        head.prev = nodeReference.next;
        nodeReference.next = head;
        head = nodeReference;
        return true;
    }

    public boolean addLast(Object data) {

        Node nodeReference = new Node(data);
        if (head == null) {
            head = nodeReference;
            return true;
        }
        Node traverse = head;
        while (traverse.next != null)
            traverse = traverse.next;
        traverse.next = nodeReference;
        nodeReference.prev = traverse;
        return true;
    }

    public Object deleteFirst() {
        if (head == null)
            throw new NullPointerException("List is empty");
        Object data = head.data;
        head = head.next;
        if (head != null)
            head.prev = null;
        return data;
    }

    public boolean remove(Object data) {
        if (head == null)
            throw new NullPointerException("List is empty");
        if (head.data.equals(data)) {
            head = head.next;
            return true;
        }
        Node traverse = head;
        while (traverse.next != null) {
            traverse = traverse.next;
            if (traverse.data.equals(data)) {
                if (traverse.next != null) {
                    traverse.prev.next = traverse.next;
                    return true;
                } else {
                    traverse.prev.next = null;
                    return true;
                }
            }
        }
        return false;
    }

    public Object deleteLast() {
        if (head == null)
            throw new NullPointerException("List is empty");
        Node traverse = head;
        while (traverse.next != null) {
            traverse = traverse.next;
        }
        Object data = traverse.data;
        if (traverse.prev != null)
            traverse.prev.next = null;
        else
            head = null;
        return data;
    }

    public int indexOf(Object data) {
        if (head == null)
            throw new NullPointerException("List is empty");
        int count = 0;
        if (head.data.equals(data))
            return count;
        Node traverse = head;
        while (traverse.next != null) {
            traverse = traverse.next;
            count++;
            if (traverse.data.equals(data)) {
                return count;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object data) {
        if (head == null)
            throw new NullPointerException("List is empty");
        int count = 0;
        Node traverse = head;
        while (traverse.next != null) {
            traverse = traverse.next;
            count++;
        }
        if (traverse.data.equals(data)) {
            return count;
        }
        return -1;
    }

    public boolean contains(Object data) {
        if (head == null)
            throw new NullPointerException("List is empty");
        Node traverse = head;
        if (head.data.equals(data))
            return true;
        while (traverse.next != null) {
            traverse = traverse.next;
            if (traverse.data.equals(data))
                return true;
        }
        return false;
    }

    public int size() {
        if (head == null)
            throw new NullPointerException("List is empty");
        int count = 1;
        Node traverse = head;
        while (traverse.next != null) {
            traverse = traverse.next;
            count++;
        }
        return count;
    }

    public String toString() {
        String print = "[";
        Node traverse = head;
        while (traverse != null) {
            print += traverse.data;
            if (traverse.next != null)
                print += ",";
            traverse = traverse.next;
        }
        return print + "]";
    }

    public static void main(String[] args) {
        DoublyLinkedList name = new DoublyLinkedList();
        name.add("Abhitanshu singh");
        name.addLast("Abhi singh");
        name.add("Himanshu singh");
        name.add("Bole nath");
        name.add("Dr Deepak");
        name.deleteLast();
        name.addFirst("Shubham singh");
        name.deleteFirst();
        name.remove("Bole nath");
        name.remove("Abhitanshu singh");
        name.add("Shubham singh");
        name.add(0, "King");
        name.add(4, "King");
        System.out.println(name);
        System.out.println(name.size());
        System.out.println(name.contains("Shubham singh"));
        System.out.println(name.contains("Abhi singh"));
        System.out.println(name.indexOf("Bole nath"));
        System.out.println(name.indexOf("Shubham singh"));
        System.out.println(name.lastIndexOf("Bole nath"));
        System.out.println(name.lastIndexOf("Abhitanshu singh"));
    }
}
