package solutions;

import java.util.HashSet;

//question -> https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class LongestSubstringWithoutRepeatingCharacter {

    public static int lengthOfLongestSubstring(String text) {
        int result = 0;
        for (int i = 0; i < text.length(); i++) {
            for (int j = i; j < text.length(); j++) {
                if (isDistinctBetweenTwoPointer(i, j, text)) {
                    int currentDistinct = j - i;
                    if (currentDistinct > result) result = currentDistinct;
                }
            }
        }
        return result;
    }

    private static boolean isDistinctBetweenTwoPointer(int start, int end, String text) {
        HashSet<Character> distinct = new HashSet<>();
        for (int i = start; i < end; i++) {
            if (distinct.contains(text.charAt(i))) return false;
            else distinct.add(text.charAt(i));
        }
        return true;
    }
}
