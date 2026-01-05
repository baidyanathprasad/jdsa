package com.practice.jdsa.strings;

/**
 * A valid palindrome is a string that reads the same backward as forward,
 * ignoring case, spaces, and punctuation.
 */
public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        String[] testCases = {
                "A man, a plan, a canal: Panama",
                "race a car",
                "1A@2!3 23!2@a1",
                "No 'x' in Nixon",
                "12321"
        };

        for (String test : testCases) {
            System.out.println("\tString: " + test);
            boolean result = isPalindrome(test);
            System.out.println("\n\tResult: " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
