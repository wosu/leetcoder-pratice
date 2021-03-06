package com.joe007.practice;

import java.util.ArrayList;
import java.util.List;


/**
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 *
 * Start Time : 2013/10/08 16:00
 * End   Time : 2013/10/08 17:41
 */
public class AddTwoNumbers {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            if(next != null){
                return String.valueOf(val) + "->" + next;
            } else {
                return String.valueOf(val);
            }
        }
        
    }
    
    /**
     * second method
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int additionalValue = 0;
        ListNode parent = null;
        ListNode firstNode = null;
        
        while(l1 != null || l2 != null){
            int node1Value = 0;
            int node2Value = 0;
            if(l1 != null){
                node1Value = l1.val;
            }
            if(l2 != null){
                node2Value = l2.val;
            }
            int digit = node1Value + node2Value + additionalValue;
            if(digit > 9){
                additionalValue = 1;
            } else {
                additionalValue = 0;
            }
            digit = digit % 10;
            ListNode currentNode = new ListNode(digit);
            System.out.println("currentNode:" + currentNode);
            if(parent != null){
                parent.next = currentNode;
            }
            parent = currentNode;
            if(firstNode == null){
                firstNode = currentNode;
            }

            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        
        if(additionalValue > 0){
            ListNode currentNode = new ListNode(1);
            parent.next = currentNode;
        }

        return firstNode;
    }

    public static void main(String[] args) {
        AddTwoNumbers instance = new AddTwoNumbers();
        ListNode l1 = instance.new ListNode(2);
        ListNode l1_4 = instance.new ListNode(4);
        ListNode l1_3 = instance.new ListNode(3);
        l1.next = l1_4;
        l1_4.next = l1_3;
        System.out.println(l1);

        ListNode l2 = instance.new ListNode(5);
        ListNode l2_6 = instance.new ListNode(6);
        ListNode l2_4 = instance.new ListNode(4);
        l2.next = l2_6;
        l2_6.next = l2_4;
        System.out.println(l2);

        System.out.println(instance.addTwoNumbers(l1, l2));
        
        l1 = instance.new ListNode(5);
        System.out.println(l1);

        l2 = instance.new ListNode(5);
        System.out.println(l2);

        System.out.println(instance.addTwoNumbers(l1, l2));

    }

}
