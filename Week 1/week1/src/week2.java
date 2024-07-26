import java.util.*;

public class week2 {
    public static void main(String[] args) throws EmptyStackException{
        Stack<Integer> s = new Stack<Integer>();
        int item1 = 1;
        int item2 = 0;
        int item3 = 4;         // Assign integer values to item 1, 2 and 3.
        s.push(item2); s.push(item1); s.push(item1 + item3);		// s = [0, 1, 5]
        item2 = s.lastElement();                                      			// item2 = 5
        s.push (item3*item3); s.push(item2); s.push(3);		// s = [0, 1, 5, 16, 5, 3]
        item1 = s.lastElement();						// item1 = 3
        s.pop();
        System.out.println(item1 + " " + item2 + " " + item3);		// print 3 5 4
        while (!s.isEmpty())
        {
            item1 = s.lastElement(); s.pop();
            System.out.println(item1);
        }

    }
    }
