package solutions;

import java.util.Arrays;
import java.util.HashMap;

//question -> https://leetcode.com/problems/longest-common-prefix/description/
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        Trie trie = initTrie(strs);
        StringBuilder builder = new StringBuilder();

        Trie currNode = trie;
        while (currNode.store.size() == 1 && !currNode.isEndOf) {
            char currCommonChar = currNode.store.keySet().iterator().next();
            builder.append(currCommonChar);
            currNode = currNode.store.get(currCommonChar);
        }
        return builder.toString();
    }

    public Trie initTrie(String[] strs) {
        Trie trie = new Trie();
        Arrays.stream(strs).forEach(trie::insert);
        return trie;
    }
}

class Trie {
    boolean isEndOf;
    HashMap<Character, Trie> store;

    public Trie() {
        store = new HashMap<>();
        isEndOf = false;
    }

    public void insert(String str) {
        Trie temp = this;
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            if (!temp.store.containsKey(curr)) {
                temp.store.put(curr, new Trie());
            }
            temp = temp.store.get(curr);
        }
        temp.isEndOf = true;
    }
}
