class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] onPath = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {

            if (!visited[i] && hasCycle(graph, visited, onPath, i)) {
                return false;
            }
        }

        return true;
    }

    public boolean hasCycle(
        List<List<Integer>> graph,
        boolean[] visited,
        boolean[] onPath,
        int i
    ) {

        if (onPath[i]) {
            return true;
        }

        if (visited[i]) {
            return false;
        }

        visited[i] = true;
        onPath[i] = true;

        for (int neighbour : graph.get(i)) {

            if (hasCycle(graph, visited, onPath, neighbour)) {
                return true;
            }
        }

        onPath[i] = false;

        return false;
    }
}