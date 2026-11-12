public class Assignment01Q05 {
    public static int findShortestPath(int[][] m, int i, int j) {
        if (i == j) {
            return 0;
        }

        boolean[] visited = new boolean[m.length];
        return findShortestPath(m, i, j, visited, 0);
    }

    private static int findShortestPath(int[][] m, int i, int j, boolean[] visited, int steps) {
        if (i == j) {
            return steps;
        }

        visited[i] = true;
        int shortest = -1;

        for (int k = 0; k < m.length; k++) {
            if (m[i][k] == 1 && !visited[k]) {
                int candidate = findShortestPath(m, k, j, visited, steps + 1);
                if (candidate != -1 && (shortest == -1 || candidate < shortest)) {
                    shortest = candidate;
                }
            }
        }

        visited[i] = false;
        return shortest;
    }

    public static void main(String[] args) {
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 0, 1)); // -1
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 1, 1)); // 0
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,0}, {0,0,1,0}, {0,0,0,1}, {1,0,0,0}}, 0, 2)); // 2
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,1}, {0,0,0,1}, {0,0,0,0}, {0,0,1,0}}, 0, 2)); // 2
    }
}