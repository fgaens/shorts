package be.codesolutions.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

    public static void main(String[] args) {
        assert (LongestSubstring.lengthOfLongestSubstring("abcabcbb")) == 3;
        assert (LongestSubstring.lengthOfLongestSubstring("bbbbb")) == 1;
        assert (LongestSubstring.lengthOfLongestSubstring("pwwkew")) == 3;
        assert (LongestSubstring.lengthOfLongestSubstring("")) == 0;
        assert (LongestSubstring.lengthOfLongestSubstring("a")) == 1;
        assert (LongestSubstring.lengthOfLongestSubstring("aa")) == 1;
        assert (LongestSubstring.lengthOfLongestSubstring("ab")) == 2;
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        }

        int cursor1 = 0;
        int cursor2 = 1;

        Set<Character> usedCharacters = new HashSet<>();
        usedCharacters.add(s.charAt(cursor1));

        int currentLength = 1;
        int maxLength = 1;

        while (cursor1 < s.length() && cursor2 < s.length()) {
            if (usedCharacters.contains(s.charAt(cursor2))) {
                usedCharacters.remove(s.charAt(cursor1++));
                --currentLength;
            } else {
                usedCharacters.add(s.charAt(cursor2++));
                ++currentLength;
            }
            maxLength = Math.max(currentLength, maxLength);
        }

        return maxLength;
    }
}

/*

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

 */