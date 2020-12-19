package net.torrypubrepo.DataStructures.Queue;

import java.util.ArrayDeque;
import java.util.LinkedList;

public class QueuePalinDrome
{
    public static void main(String[] args)
    {
        // should return true
        System.out.println(checkForPalindrome("abccba"));
        // should return true
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
        // should return true
        System.out.println(checkForPalindrome("I did, did I?"));
        // should return false
        System.out.println(checkForPalindrome("hello"));
        // should return true
        System.out.println(checkForPalindrome("Don't nod"));
    }

    public static boolean checkForPalindrome(String string)
    {
        LinkedList<Character> stackValues = new LinkedList<>(); // For Stacking
       ArrayDeque<Character> characterArrayDeque = new ArrayDeque<>(); // For Queuing

        // Coverts to Lower case
        String lowerCaseString = string.toLowerCase();
        // loop for character
        for (int i = 0; i < lowerCaseString.length(); i++)
        {
            char c = lowerCaseString.charAt(i);
            // Check if it's between a-z
            if (c >= 'a' && c <= 'z') {
                characterArrayDeque.add(c);
                stackValues.push(c);
            }
        }
        // Compare each character in the stack and queue
        while (!stackValues.isEmpty())
        {
            if (!stackValues.pop().equals(characterArrayDeque.remove()))
                return false;
        }
        return true;
    }
}
