import GraphViz.CreateGraph;

import java.util.LinkedList;
import java.util.Map;

import dijkstra.DijkstraAlgorithm;
import dijkstra.Graph;
import action.OsmParser;
import action.WaysIntoEdges;
import figures.Edge;
import figures.Node;
import figures.Way;


public class Main {

    private static Map<Long, Node> allNodes;
    private static Map<Long, Way> allWays;
    private static LinkedList<Edge> allEdges;
    
 
    public static void main(String[] args){
    	
    	
    	// parse OSM
        OsmParser osm = new OsmParser();
        osm.parsingOsmFile();
        allNodes = osm.getNodes();
        allWays = osm.getWays();
        allEdges = WaysIntoEdges.splitAllWaysIntoEdges(allWays);
        System.out.println("Size of all Nodes: " + allNodes.size());
        System.out.println("Size of all Ways: " + allWays.size());
        System.out.println("Size of all Edges: " + allEdges.size());
       // Way actual= allWays.get((long)(4474982));
        //System.out.println(actual.getDistance());
        
        System.out.println("-----------------------");
        
        
        // make graph with Graphviz
        drawGraph();
        
        
        System.out.println("-----------------------");
        
        
        Graph fhwsGraph = new Graph(allNodes, allEdges);
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(fhwsGraph);
        
        
        // path form node 2302466225 to 2302466223
        dijkstra.execute(allNodes.get(2302466225L));
        LinkedList<Node> path = dijkstra.getPath(allNodes.get(2302466223L));
        
        for (Node node : path) {
            System.out.println(node);
          }
        
        System.out.println();
    }
    
    private static void drawGraph(){
    	
    	CreateGraph graph = new CreateGraph();
        graph.start(allEdges);
    }

}
