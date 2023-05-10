import java.util.HashMap;
import java.util.Map;

public class Solution1376 {
    int headID;  // 公司总负责人 ID
    int[] manager;  // manager[i] 表示第 i 名员工的直属负责人
    int[] informTime;  // informTime[i] 表示第 i 名员工通知直属下属所需时间
    Map<Integer, Integer> memo = new HashMap<>();  // 记忆化搜索缓存

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        this.headID = headID;
        this.manager = manager;
        this.informTime = informTime;
        int res = 0;  // 记录最长时间
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dfs(i));  // 对每个员工遍历，更新最长时间
        }
        return res;
    }

    public int dfs(int cur) {
        if (cur == headID) {  // 当前节点为根节点
            return 0;
        }
        if (!memo.containsKey(cur)) {  // 检查缓存中是否已经存在当前节点的时间
            int res = dfs(manager[cur]) + informTime[manager[cur]];  // 递归遍历当前节点的直属上级节点，返回时间和
            memo.put(cur, res);  // 将当前节点到根节点的时间加入缓存中
        }
        return memo.get(cur);  // 返回当前节点到根节点的时间
    }
}
