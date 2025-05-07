package com.yukthi.linkedlist.hr;

import java.io.*;
import java.util.stream.IntStream;

/**
 * There is a singly linked list of n nodes. Each node instance, a SinglyLinkedListNode, has an integer value, data, and a pointer to the next node, next. Perform the following operations to generate a new linked list.
 * <p>
 * Select all the nodes at odd positions.
 * Append these nodes to the new linked list keeping them in their original order.
 * Delete these nodes from the old linked list.
 * Repeat from step 1 until there are no nodes left in the old linked list.
 * <p>
 * <p>
 * Return a reference to the head of the final linked list.
 * <p>
 * <p>
 * <p>
 * Note: Extra memory other than creating some new nodes should not be used for the implementation.
 *
 * ex:
 * i/p: 1->5->2->7->8->3->null
 * o/p: 1->2->8->5->3->7->null
 */
public class LinkedListCreationOddNodes {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        System.out.println(System.getenv("OUTPUT_PATH"));

        SinglyLinkedList head = new SinglyLinkedList();

        int headCount = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, headCount).forEach(i -> {
            try {
                int headItem = Integer.parseInt(bufferedReader.readLine().trim());

                head.insertNode(headItem);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        SinglyLinkedListNode result = Result.createLinkedList(head.head);

        SinglyLinkedListPrintHelper.printList(result, "\n", bufferedWriter);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


class Result {

    /*
     * Complete the 'createLinkedList' function below.
     *
     * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
     * The function accepts INTEGER_SINGLY_LINKED_LIST head as parameter.
     */

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */

    public static SinglyLinkedListNode createLinkedList(SinglyLinkedListNode head) {
        // Write your code here
        if (head == null) {
            return null;
        }
        SinglyLinkedList oddList = new SinglyLinkedList();
        SinglyLinkedList evenList = new SinglyLinkedList();

        boolean odd = true;

        SinglyLinkedListNode node = head;

        while (node != null) {
            if (odd) {
                oddList.insertNode(node.data);
            } else {
                evenList.insertNode(node.data);
            }
            node = node.next;
            odd = !odd;
        }

        oddList.tail.next = createLinkedList(evenList.head);
        return oddList.head;

    }

}
