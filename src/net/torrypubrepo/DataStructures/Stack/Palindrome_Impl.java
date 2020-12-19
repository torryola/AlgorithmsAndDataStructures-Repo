package net.torrypubrepo.DataStructures.Stack;

import java.util.LinkedList;
import java.util.Stack;

/*
 Created by Toriola
 */
public class Palindrome_Impl
{
    Stack<String> stack = new Stack<>();
    LinkedList<Character> stackLinked = new LinkedList<>();

    public static void main(String[] args)
    {
        System.out.println(new Palindrome_Impl().isPalindrome("ADA?"));

        System.out.println(new Palindrome_Impl().isPalinDrome("ADA?"));
    }

    public boolean isPalindrome(String val)
    {
        // Get the String value character from the back
        StringBuilder palindrome = new StringBuilder(val.length());
        String[] arrVal = val.split("");
        for (int i = val.length() - 1; i >= 0 ; i--)
        {
            // Push to stack
            stack.push(arrVal[i]);
        }

        System.out.println(stack.toString());

        for (String s : stack)
            palindrome.append(s);

        System.out.println(palindrome.toString());
        return palindrome.toString().equals(val);
    }

    public boolean isPalinDrome(String val)
    {
        // Convert arg to lowercase
        String valLowercase = val.toLowerCase();
        // Builder for Strings without Punctuation marks
        StringBuilder noPunctuation = new StringBuilder(val.length());
        // extract each character from the val
        for (int i = 0; i < val.length(); i++) {
            char character = valLowercase.charAt(i);
            // Check if the character is between a-z
            if (character >= 'a' && character <= 'z')
            {
                noPunctuation.append(character);
                stackLinked.push(character);
            }
        }

        // Create String from the stack
        StringBuilder reversedString = new StringBuilder(stackLinked.size());
       while (!stackLinked.isEmpty())
           reversedString.append(stackLinked.pop());

       return reversedString.toString().equals(noPunctuation.toString());
    }

}
