package library.algorithm.Graph.ShortestPath;

// DO not initialize the array distances by Long.MAX_VALUE!
// Use values like 1 << 60 to avoid overflow.

// See https://en.wikipedia.org/wiki/Floyd%E2%80%93Warshall_algorithm#Path_reconstruction
class WarshallFloyd {
    long[][] distances;
    int numVertexes;
    int[][] successors;
    long INF = 1L << 60;

    WarshallFloyd(long[][] distances) {
        this.distances = distances;
        numVertexes = distances.length;
    }

    WarshallFloyd(long[][] distances, int[][] successors) {
        this.distances = distances;
        numVertexes = distances.length;
        this.successors = successors;
    }

    void shortestPath() {
        for (int k = 0; k < numVertexes; k++) {
            for (int i = 0; i < numVertexes; i++) {
                for (int j = 0; j < numVertexes; j++) {
                    distances[i][j] = Math.min(distances[i][j],
                            distances[i][k] + distances[k][j]);
                }
            }
        }
    }

    void shortestPathWithPath() {
        for (int k = 0; k < numVertexes; k++) {
            for (int i = 0; i < numVertexes; i++) {
                for (int j = 0; j < numVertexes; j++) {
                    long newDistance = distances[i][k] + distances[k][j];
                    if (distances[i][j] > newDistance) {
                        distances[i][j] = newDistance;
                        successors[i][j] = successors[i][k];
                    }
                }
            }
        }
    }
}
