import java.util.*;

public class Solution690 {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        int total = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);
        while (!queue.isEmpty()) {
            int curId = queue.poll();
            Employee employee = map.get(curId);
            total += employee.importance;
            List<Integer> subordinates = employee.subordinates;
            for (int subId : subordinates) {
                queue.offer(subId);
            }
        }
        return total;
    }

//    Map<Integer, Employee> map = new HashMap<>();
//
//    public int getImportance(List<Employee> employees, int id) {
//        for (Employee employee : employees) {
//            map.put(employee.id, employee);
//        }
//        return dfs(id);
//    }
//
//    public int dfs(int id) {
//        Employee employee = map.get(id);
//        int total = employee.importance;
//        List<Integer> subordinates = employee.subordinates;
//        for (int subId : subordinates) {
//            total += dfs(subId);
//        }
//        return total;
//    }

    // Definition for Employee.
    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
}
