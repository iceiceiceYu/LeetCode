public class Solution676 {
    static class MagicDictionary {
        private String[] words;

        public MagicDictionary() {

        }

        public void buildDict(String[] dictionary) {
            words = dictionary;
        }

        public boolean search(String searchWord) {
            for (String word : words) {
                if (word.length() != searchWord.length()) {
                    continue;
                }

                int diff = 0;
                for (int i = 0; i < word.length(); ++i) {
                    if (word.charAt(i) != searchWord.charAt(i)) {
                        diff++;
                        if (diff > 1) {
                            break;
                        }
                    }
                }
                if (diff == 1) {
                    return true;
                }
            }
            return false;
        }
    }
}
