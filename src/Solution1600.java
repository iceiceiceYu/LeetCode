import java.util.*;

public class Solution1600 {
    /**
     * Your ThroneInheritance object will be instantiated and called as such:
     * ThroneInheritance obj = new ThroneInheritance(kingName);
     * obj.birth(parentName,childName);
     * obj.death(name);
     * List<String> param_3 = obj.getInheritanceOrder();
     */
    static class ThroneInheritance {
        Map<String, List<String>> edges;
        Set<String> dead;
        String king;

        public ThroneInheritance(String kingName) {
            edges = new HashMap<>();
            dead = new HashSet<>();
            king = kingName;
        }

        public void birth(String parentName, String childName) {
            List<String> children = edges.getOrDefault(parentName, new ArrayList<String>());
            children.add(childName);
            edges.put(parentName, children);
        }

        public void death(String name) {
            dead.add(name);
        }

        public List<String> getInheritanceOrder() {
            List<String> ans = new ArrayList<String>();
            preorder(ans, king);
            return ans;
        }

        private void preorder(List<String> ans, String name) {
            if (!dead.contains(name)) {
                ans.add(name);
            }
            List<String> children = edges.getOrDefault(name, new ArrayList<String>());
            for (String childName : children) {
                preorder(ans, childName);
            }
        }
    }
}
