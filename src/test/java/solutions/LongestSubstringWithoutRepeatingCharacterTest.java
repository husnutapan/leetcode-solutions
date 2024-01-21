package solutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringWithoutRepeatingCharacterTest {

    @Test
    public void testAllCharsDistinct() {
        int result = LongestSubstringWithoutRepeatingCharacter.lengthOfLongestSubstring("abcdefgh");
        assertEquals(result, 7);
    }

    @Test
    public void testCharsNotDistinct() {
        int result = LongestSubstringWithoutRepeatingCharacter.lengthOfLongestSubstring("aabbccdde");
        assertEquals(result, 2);
    }
}
