package solutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestCommonPrefixTest {

    @Test
    public void testCommonPrefixes() {
        String[] stringArray = {"apple", "application", "appetite"};
        LongestCommonPrefix instance = new LongestCommonPrefix();
        String prefix = instance.longestCommonPrefix(stringArray);
        assertEquals("app", prefix);
    }

    @Test
    public void testNonCommonPrefixes() {
        String[] stringArray = {"apple", "baggage", "captivate"};
        LongestCommonPrefix instance = new LongestCommonPrefix();
        String prefix = instance.longestCommonPrefix(stringArray);
        assertEquals("", prefix);
    }
}
