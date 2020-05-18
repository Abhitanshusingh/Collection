package com.bridgelabz.list;

public class SinglyLinkedList {
    class Node {
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
        while (traverse.next != null) {
            traverse = traverse.next;
        }
        traverse.next = nodeReference;
        return true;
    }

    public boolean add(int index, Object data) {
        Node nodeReferance = new Node(data);
        if (index == 0) {
            nodeReferance.next = head;
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
        nodeReferance.next = traverse.next;
        traverse.next = nodeReferance;
        return true;
    }

    public boolean addFirst(Object data) {
        Node nodeReference = new Node(data);
        nodeReference.next = head;
        head = nodeReference;
        return true;
    }

    public boolean addLast(Object data) {
        Node nodeReference = new Node(data);
        Node traverse = head;
        while (traverse.next != null) {
            traverse = traverse.next;
        }
        traverse.next = nodeReference;
        return true;
    }

    public Object deleteFirst() {
        if (head == null)
            throw new NullPointerException("List is empty");
        Object data = head.next;
        head = head.next;
        return data;
    }

    public Object deleteLast() {
        if (head == null)
            throw new NullPointerException("List is empty");
        Node traverse = head, tempTraverse = head;
        while (traverse.next != null) {
            tempTraverse = traverse;
            traverse = traverse.next;
        }
        Object data = traverse.data;
        if (tempTraverse.next != null)
            tempTraverse.next = null;
        else
            head = null;
        return data;
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

    public boolean remove(Object data) {
        if (head == null)
            throw new NullPointerException("List is empty");
        Node traverse = head, tempTraverse = head;
        if (head.data.equals(data)) {
            head = head.next;
            return true;
        }
        while (traverse.next != null) {
            tempTraverse = traverse;
            traverse = traverse.next;
            if (traverse.data.equals(data)) {
                if (traverse.next != null)
                    tempTraverse.next = traverse.next;
                else
                    tempTraverse.next = null;
                break;
            }
        }
        return true;
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
        //Adding String in list
        SinglyLinkedList name = new SinglyLinkedList();
        name.add("Abhi");
        name.add("Singh");
        name.add("Baghel");
        name.addFirst("Abhitanshu");
        name.add("Himanshu");
        name.addLast("Shubham");
        name.addLast("Sagar");
        name.remove("Singh");
        name.remove("Sagar");
        name.remove("Abhi");
        name.add(0, "King");
        name.add(4, "Thakur");
        System.out.println(name.size());
        System.out.println(name);
        System.out.println(name.contains("Abhitanshu"));
        System.out.println(name.contains("Abhi"));
        System.out.println(name.contains("Shubham"));
        System.out.println(name.indexOf("Abhitanshu"));
        System.out.println(name.indexOf("Shubham"));
        System.out.println(name.indexOf("Ajay"));

        //Adding Integer in list
        SinglyLinkedList id = new SinglyLinkedList();
        id.add(1);
        id.add(2);
        id.addFirst(0);
        id.deleteFirst();
        id.addLast(3);
        id.addLast(4);
        id.add(5);
        id.add(6);
        id.deleteLast();
        System.out.println(id);
        System.out.println(id.lastIndexOf(5));
        System.out.println(id.lastIndexOf(6));
    }
}
