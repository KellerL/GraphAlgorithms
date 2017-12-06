package dijkstra;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import figures.Edge;
import figures.Node;


public class Graph {
  private final HashMap<Long,Node> nodes;
  private final List<Edge> edges;

  public Graph(Map<Long, Node> allNodes, List<Edge> edges) {
    this.nodes = (HashMap<Long, Node>) allNodes;
    this.edges = edges;
  }

  public HashMap<Long, Node> getNodes() {
    return nodes;
  }

  public List<Edge> getEdges() {
    return edges;
  }
  
  
  
} 

