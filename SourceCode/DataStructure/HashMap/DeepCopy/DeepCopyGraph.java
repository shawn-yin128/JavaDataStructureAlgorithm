package DataStructure.HashMap.DeepCopy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Make a deep copy of an undirected graph, there could be cycles in the original graph.
 */
public class DeepCopyGraph {
    class GraphNode {
        public int key;
        public List<GraphNode> neighbors;
        public GraphNode(int key) {
            this.key = key;
            this.neighbors = new ArrayList<GraphNode>();
        }
    }

    public List<GraphNode> copy(List<GraphNode> graph) {
        if (graph == null) {
            return null;
        }
        Map<GraphNode, GraphNode> map = new HashMap<>();
        for (GraphNode node : graph) {
            if (!map.containsKey(node)) {
                map.put(node, new GraphNode(node.key));
                DFS(node, map);
            }
        }
        return new ArrayList<GraphNode>(map.values());
    }

    private void DFS(GraphNode node, Map<GraphNode, GraphNode> map) {
        GraphNode copy = map.get(node);
        for (GraphNode nei : node.neighbors) {
            if (!map.containsKey(nei)) {
                map.put(nei, new GraphNode(nei.key));
                DFS(nei, map);
            }
            copy.neighbors.add(map.get(nei));
        }
    }
}

/**
 * time complexity: O(V + E)
 * space complexity: O(V + E)
 */