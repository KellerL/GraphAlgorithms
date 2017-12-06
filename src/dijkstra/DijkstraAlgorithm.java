package dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import figures.Node;
import figures.Edge;

public class DijkstraAlgorithm {

  private final Map<Long, Node> nodes;
  private final List<Edge> edges;
  private Set<Node> settledNodes;
  private Set<Node> unSettledNodes;
  private Map<Node, Node> predecessors;
  private Map<Node, Double> distance; //

  public DijkstraAlgorithm(Graph graph) {
    // create copies so we can operate on them
	  this.nodes = new HashMap<Long, Node>(graph.getNodes());
    this.edges = new ArrayList<Edge>(graph.getEdges());
  }

  public void execute(Node startNode) {
    settledNodes = new HashSet<Node>();
    unSettledNodes = new HashSet<Node>();
    distance = new HashMap<Node, Double>();
    predecessors = new HashMap<Node, Node>();
    distance.put(startNode, 0.0);
    unSettledNodes.add(startNode);
    while (unSettledNodes.size() > 0) {
      Node node = getMinimum(unSettledNodes);
      settledNodes.add(node);
      unSettledNodes.remove(node);
      findMinimalDistances(node);
    }
  }

  public void findMinimalDistances(Node node) {
    List<Node> adjacentNodes = getNeighbors(node);
    for (Node target : adjacentNodes) {
      if (getShortestDistance(target) > getShortestDistance(node)
          + getDistance(node, target)) {
        distance.put(target, getShortestDistance(node)
            + getDistance(node, target));
        predecessors.put(target, node);
        unSettledNodes.add(target);
      }
    }

  }

  private double getDistance(Node node, Node target) {
    for (Edge edge : edges) {
      if (edge.getStartNode().equals(node)
          && edge.getEndNode().equals(target)) {
        return edge.getLength();
      }
    }
    throw new RuntimeException("Something, somewhere went terribly wrong");
  }

  private List<Node> getNeighbors(Node node) {
    List<Node> neighbors = new ArrayList<Node>();
    for (Edge edge : edges) {
      if (edge.getStartNode().equals(node)
          && !isSettled(edge.getEndNode())) {
        neighbors.add(edge.getEndNode());
      }
    }
    return neighbors;
  }

  private Node getMinimum(Set<Node> nodes) {
    Node minimum = null;
    for (Node node : nodes) {
      if (minimum == null) {
        minimum = node;
      } else {
        if (getShortestDistance(node) < getShortestDistance(minimum)) {
          minimum = node;
        }
      }
    }
    System.out.println("Minimum: " + minimum);
    return minimum;
  }

  private boolean isSettled(Node node) {
    return settledNodes.contains(node);
  }

  private double getShortestDistance(Node destination) {
    Double d = distance.get(destination);
    if (d == null) {
      return Double.MAX_VALUE;
    } else {
    	System.out.println(d);
      return d;
    }
  }

  /*
   * This method returns the path from the source to the selected target and
   * NULL if no path exists
   */
  public LinkedList<Node> getPath(Node target) {
    LinkedList<Node> path = new LinkedList<Node>();
    Node step = target;
    // check if a path exists
    if (predecessors.get(step) == null) {
      return null;
    }
    path.add(step);
    while (predecessors.get(step) != null) {
      step = predecessors.get(step);
      path.add(step);
    }
    // Put it into the correct order
    Collections.reverse(path); // turn order => reverse order
    return path;
  }

} 


