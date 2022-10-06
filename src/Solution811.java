import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> ans = new ArrayList<>();
        Map<String, Integer> counts = new HashMap<>();
        for (String cpdomain : cpdomains) {
            int space = cpdomain.indexOf(' ');
            int count = Integer.parseInt(cpdomain.substring(0, space));
            String domain = cpdomain.substring(space + 1);
            counts.put(domain, counts.getOrDefault(domain, 0) + count);
            for (int i = 0; i < domain.length(); i++) {
                if (domain.charAt(i) == '.') {
                    String subdomain = domain.substring(i + 1);
                    counts.put(subdomain, counts.getOrDefault(subdomain, 0) + count);
                }
            }
        }
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            String subdomain = entry.getKey();
            int count = entry.getValue();
            ans.add(count + " " + subdomain);
        }
        return ans;
    }
}
