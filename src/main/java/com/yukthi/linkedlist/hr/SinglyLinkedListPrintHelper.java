package com.yukthi.linkedlist.hr;

import java.io.BufferedWriter;
import java.io.IOException;

public class SinglyLinkedListPrintHelper {
    public static void printList(SinglyLinkedListNode node, String separator, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));
            node = node.next;
            if (node != null) {
                bufferedWriter.write(separator);
            }
        }
    }
}
