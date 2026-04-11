class Solution {
    private Map<Integer, List<Integer>> preMap = new HashMap<>();
    private Set<Integer> visiting = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //detect cycle in a graph - dfs - if a node that has been visted get visited again
        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }
        for (int[] prereq: prerequisites) {
            preMap.get(prereq[0]).add(prereq[1]);
        }
        for (int c = 0; c < numCourses; c++) {
            if (!dfs(c)) {
                return false;
            }
        }
        return true;
    }
    private boolean dfs(int num) {
        if (visiting.contains(num)) {
            return false;
        }
        // null case
        if (preMap.get(num).isEmpty()) {
            return true;
        }
        visiting.add(num);
        for (int pre: preMap.get(num)) {
            if (!dfs(pre)) {
                return false;
            }
        }
        visiting.remove(num);
        preMap.put(num, new ArrayList<>()); //avoid repetition
        return true;
    }
}
