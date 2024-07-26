// Author: Lee Moriarity

import java.util.Scanner;

public class EditString {
    public static void main(String[] args) {

        ArrayBoundedStack<String> stack = new ArrayBoundedStack<String>();
        System.out.print("Enter a string: ");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        stack.push(input);
        System.out.print("\nUsage:\nU—make all letters uppercase\n" +
                "L—make all letters lowercase\n" +
                "R—reverse the string\n" +
                "C ch1 ch2—change all occurrences of ch1 to ch2\n" +
                "Z—undo the most recent change\n" +
                "X-end the application and print output\n\n");
        String cmd = "";
        while (!cmd.equals("X"))
        {
            System.out.print("Enter a command: ");
            cmd = scan.nextLine();
            if (cmd.startsWith("C ")) { // change all occurrences of string1 to string2
                String[] split = cmd.split(" ");
                stack.push(stack.top().replaceAll(split[1], split[2]));
            } else {
                switch (cmd) {
                    case "U": // make all letters uppercase
                        stack.push(stack.top().toUpperCase());
                        break;
                    case "L": // make all letters lowercase
                        stack.push(stack.top().toLowerCase());
                        break;
                    case "R": // reverse the string
                        String str = "";
                        for (int i = 0; i < stack.top().length(); i++)  {
                            char ch = stack.top().charAt(i);
                            str = ch + str;
                        }
                        stack.push(str);
                        break;
                    case "Z": // undo the most recent change
                        stack.pop();
                        break;
                    case "X": // end the application and print output
                        System.out.println("\n" + stack.top());
                        break;
                }
            }
        }
    }
}