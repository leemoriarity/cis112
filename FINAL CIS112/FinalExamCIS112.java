/********************************************
     Author: Lee Moriarity
     Date: 12/14/2022
     Purpose: CIS112 Final Exam - Fall 2022
********************************************/

import java.util.Iterator;
import java.util.Scanner;

public class FinalExamCIS112
{
  
  public static void main(String[] args)
  {
     // 110 points available - could get extra credit!!
     // This file is what you will submit after you write the code for the following
     // 7 exercises!
     // You can place all of your code in this file; comment out any code that is not
     // complete so that the file still compiles; all of the necessary author files will
     // be provided in this test folder so you don't have to go looking for files or do any
     // imports if they are all in the same folder with the final exam java file.

     // ----------------------------------------------------------------------------------------
     // #1  (use LINKED LIST ADT - 15 pts)  (Chapter 6)
     //   author files: CollectionInterface, ListInterface, LLNode, LBList
     //   INPUT: Prompt the user to type in their FIVE most favorite holidays of the year
     //   (for example, Christmas, New Years,…). Place their answers into a LINKED LIST.
     //   OUTPUT: Contents of the Linked List - should be unordered.
     // ----------------------------------------------------------------------------------------
     int i = 0;
     int o = 0;
     int p = 0;
     Scanner scan = new Scanner(System.in);

     ListInterface<String> holidays = new LBList<>();
     System.out.println("Enter FIVE most favorite holidays of the year: ");
     while(i<5){
			holidays.add(scan.nextLine());
			i++;
		}
      Iterator<String> iter = holidays.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}

     // ----------------------------------------------------------------------------------------------
     // #2 (use PRIORITY QUEUE ADT (HEAP) - 15 pts) (Chapter 9)
     //   author files: HeapPriQ, PriQOverflowException, PriQUnderflowException, PriQueueInterface
     //   INPUT: TAKE from the LIST you created in #1 and put items into a HEAP implementation of a Priority
     //   Queue (this will give you a "maximum" heap).
     //   OUTPUT: Resulting heap - should be in REVERSE order.
     // ----------------------------------------------------------------------------------------------
      PriQueueInterface<String> pq = new HeapPriQ<>(5);
      Iterator<String> ll = holidays.iterator();
      while(ll.hasNext()) {
          pq.enqueue(ll.next());
      }
      System.out.println(pq);
     // -------------------------------------------------------------------------------------------------
     // #3  (use STACK ADT - 15 pts) (Chapter 2)
     //   author files: ArrayBoundedStack, StackInterface, StackOverflowException, StackUnderflowException
     //   INPUT: Take the reverse sorted HEAP in #2 and copy the items into a STACK
     //   (as usual, you MUST use the author’s STACK code).
     //   OUTPUT: Contents of the stack as you take each element off the stack
     //   so that what gets printed out is now in alphabetical order.
     // -------------------------------------------------------------------------------------------------
      StackInterface<String> stack = new ArrayBoundedStack<String>();
      while (!pq.isEmpty())
          stack.push(pq.dequeue());
      // -------------------------------------------------------------------------------------------
     // #4  (use SORTED LIST ADT - 15 pts)  (Chapter 6)
     //   author files: SortedABList, ListInterface
     //   INPUT: Take from the STACK in #3 and place the items into a SORTED LIST.
     //   OUTPUT: Using an Iterator, PRINT the contents of the list -- should remain sorted    
     // --------------------------------------------------------------------------------------
      ListInterface<String> list = new SortedABList();
      while (!stack.isEmpty()) {
          list.add(stack.top());
          stack.pop();
      }
      Iterator<String> it = list.iterator();
      while(it.hasNext()) {
          System.out.println(it.next());
      }

     // -----------------------------------------------------------------------------------------------------
     // #5  (use QUEUE ADT - 20 pts) (Chapter 4)
     //   author files: ArrayBoundedQueue, QueueInterface, QueueOverflowException, QueueUnderflowException
     //   INPUT: Take from the sorted list you created in #4 (so it will be alphabetical) and present it to the user; 
     //   ask user to identify the order of the list in most favorite to least favorite.
     //   Save the "favorability" order by enqueueing the NAME(not index) of each item    
     //   into a QUEUE in the given order (of course, you MUST use the author's QUEUE code).
     //   OUTPUT: PRINT the contents of the queue as you dequeue each element 
     //   so that what gets printed out are the items in the order the user favors them most.
     // ------------------------------------------------------------------------------------------------------
      QueueInterface<String> qi = new ArrayBoundedQueue<>(5);
      QueueInterface<String> qi2 = new ArrayBoundedQueue<>(5);
      QueueInterface<String> qi3 = new ArrayBoundedQueue<>(5);
      System.out.println("Rank your FIVE most favorite holidays by name from most to least: ");
      Iterator<String> itera = list.iterator();
      while(itera.hasNext()) {
          System.out.println(itera.next());
      }
      while(o<5){
          String temp = scan.nextLine();
          qi.enqueue(temp);
          qi2.enqueue(temp);
          o++;
      }
      while(!qi2.isEmpty()){
          System.out.println(qi2.dequeue());
      }
      // --------------------------------------------------------------------------------------------------
     // #6 (use BINARY SEARCH TREE ADT - 15 pts) (Chapter 7)
     //   author files: BSTInterface, BSTNode, CollectionInterface, LinkedStack, LinkedQueue, 
     //                BinarySearchTree  
     //   INPUT: Take from the QUEUE in #5 and put it into a BST structure so that
     //   you can quickly search for an item; ask the user to enter a holiday  
     //   so you can check if it is a "favorite" by using the BST to search for it. 
     //   OUTPUT: Tell user if you found it or not
     // ------------------------------------------------------------------------------------------- --------   
      BSTInterface<String> bst = new BinarySearchTree();
      while(!qi2.isEmpty()){
          bst.add(qi2.dequeue());
      }
      Iterator<String> iter2 = bst.getIterator(BSTInterface.Traversal.Inorder);
      System.out.println("Enter your favorite holiday: ");
      String fav = scan.nextLine();
      if (bst.contains(fav)) // ran out of time
          System.out.println("string found");
      else
          System.out.println("string not found");

      // -----------------------------------------------------------------------------------------------
     // #7 (use MAP ADT - 15 pts) (Chapter 8)
     //   author files: HMap, MapInterface, MapEntry
     //   INPUT: Take from the QUEUE in #5 and put it into a HASH MAP structure so that 
     //   you can quickly search for an item; ask the user to type in a holiday  
     //   so you can check if it is a "favorite" and use the Hash Map to search for it. 
     //   OUTPUT: Tell user if you found it or not
     // ------------------------------------------------------------------------------------------------
     MapInterface<Integer, String> map = new HMap<>();
      Iterator<MapEntry<Integer, String>> m = map.iterator();
      while(!qi3.isEmpty()){
          map.put(p,qi3.dequeue());
          p++;
      }
      System.out.println("Enter your favorite holiday again: ");
      String fav2 = scan.nextLine();
      if (bst.contains(fav2)) // ran out of time
              System.out.println("String found");
      else
              System.out.println("String not found");
          }
     
     //HINTS:
     // --Good sample code for creating some of these ADTs (go to "apps" folder for
     //   whichever chapter you are looking for): 
     //   LBListDriver, HMapDriver, BSTExample, CollectionDriver, UseHeap )
     // --You may need to make copies of different lists throughout the coding since you
     // may have lost your list after you printed contents.
  }
}