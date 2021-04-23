public class Solution208 {
    static class Trie {
        private boolean isLeaf;
        private Trie[] children;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            this.isLeaf = false;
            this.children = new Trie[26];
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            Trie node = this;
            int len = word.length();
            for (int i = 0; i < len; i++) {
                char ch = word.charAt(i);
                if (node.children[ch - 'a'] == null) {
                    node.children[ch - 'a'] = new Trie();
                }
                node = node.children[ch - 'a'];
            }
            node.isLeaf = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Trie node = searchPrefix(word);
            return node != null && node.isLeaf;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        private Trie searchPrefix(String prefix) {
            Trie node = this;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                int index = ch - 'a';
                if (node.children[index] == null) {
                    return null;
                }
                node = node.children[index];
            }
            return node;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
