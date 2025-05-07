package com.yukthi.linkedlist.hr;

import java.io.*;
import java.util.stream.IntStream;

/**
 * Given a linked list of integers, return a linked list containing only nodes having odd integers in their node->data field.
 * <p>
 * <p>
 * <p>
 * Example
 * <p>
 * n = 3
 * <p>
 * listHead = 1 → 4 → 7
 * <p>
 * <p>
 * <p>
 * The linked list containing only nodes having odd integers is 1 → 7.
 * <p>
 * <p>
 * <p>
 * Function Description
 * <p>
 * Complete the function deleteEven in the editor below.
 * <p>
 * <p>
 * <p>
 * deleteEven has the following parameter(s):
 * <p>
 * list listHead:  a reference to the head of the input linked list
 * <p>
 * Returns:
 * <p>
 * list: a reference to the head of the resulting linked list.
 * <p>
 * <p>
 * <p>
 * Constraints
 * <p>
 * 1 ≤ n ≤ 105
 * 1 ≤ node->data ≤ 105
 */
public class DeleteEvenIntegerNodes {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        SinglyLinkedList listHead = new SinglyLinkedList();

        int listHeadCount = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, listHeadCount).forEach(i -> {
            try {
                int listHeadItem = Integer.parseInt(bufferedReader.readLine().trim());

                listHead.insertNode(listHeadItem);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        SinglyLinkedListNode result = deleteEven(listHead.head);

        SinglyLinkedListPrintHelper.printList(result, "\n", bufferedWriter);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    private static SinglyLinkedListNode deleteEven(SinglyLinkedListNode listHead) {
        SinglyLinkedListNode current = listHead;

        if (current == null) {
            return current;
        }
        SinglyLinkedListNode pre = new SinglyLinkedListNode(-1, null);
        SinglyLinkedListNode result = pre;

        pre.next = current; // pre -> curr -> next -> .....

        while (current != null) {
            if (current.data % 2 == 0) {
                pre.next = current.next; // pre -> next; curr -> next
                current.next = null;
                current = pre.next;

            } else {
                pre = current;
                current = current.next;
            }

        }

        return result.next;
    }

}
