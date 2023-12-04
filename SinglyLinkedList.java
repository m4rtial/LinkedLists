package xyz.urbanaugust;

public class SinglyLinkedList
{
    // node class
    public static class Node
    {
        Node(String d, Node n){
            data = d;
            next = n;
        }
        String data;
        Node next;
    }

    // linked list head
    Node head;
    // linked list constructor
    SinglyLinkedList(Node r){
        head = r;
    }


    // insert an element into a specific index
    public static SinglyLinkedList insertNodeAtIndex(String data, int index, SinglyLinkedList linkedList){
        if(index == 0){
            linkedList.head = linkedList.head.next;
        }

        Node previousNode  = linkedList.head;

        for(int element = 1; element < index - 1; element++){
            previousNode = linkedList.head.next;
        }

        Node followingNode  = previousNode.next.next;
        Node newNode = new Node(data, followingNode);
        previousNode.next = newNode;

        return linkedList;
    }

    // delete a node at a specific index
    public static SinglyLinkedList deleteNodeByIndex(int index, SinglyLinkedList linkedList){
        if(index == 0){
            linkedList.head = linkedList.head.next;
        }

        Node previousNode = linkedList.head;

        for(int element = 1; element < index - 1; element++){
            previousNode = linkedList.head.next;
        }

        previousNode.next = previousNode.next.next;

        return linkedList;
    }

    // append an element to the end of the linked list
    public static SinglyLinkedList appendNode(String data, SinglyLinkedList linkedList)
    {
        Node currentNode = null;

        // create and add to head if it does not already exist
        if(linkedList.head == null){
            linkedList.head = new Node(data, null);
            System.out.println("Head created and data added.");
            return linkedList;
        }
        else{
            currentNode = linkedList.head;
        }

        // traverse list until the end is found and append node there
        while(currentNode.next != null){
            currentNode = currentNode.next;
        }

        // append new node to end of linked list
        currentNode.next = new Node(data, null);
        return linkedList;
    }

    // get node by data (key) - returns -1 on fail
    public static int getKeyIndex(SinglyLinkedList linkedList, String key)
    {
        Node currentNode = linkedList.head;
        int count = 0;
        try {
            do {
                if (currentNode.data == null) {
                    return -1;
                }
                if (currentNode.data.equals(key)) {
                    return count;
                }
                currentNode = currentNode.next;
                count++;

            } while (!currentNode.data.equals(key));
            return count;
        }
        catch(NullPointerException npe){
            return -1;
        }
    }

    // iterate over and print all elements in the linked list
    public static void printList(SinglyLinkedList linkedList){
        Node currentNode = linkedList.head;
        while(currentNode != null){
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }
}
