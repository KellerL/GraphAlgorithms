package action;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import figures.Edge;
import figures.Node;
import figures.Way;


public class WaysIntoEdges {

    public static LinkedList<Edge> splitAllWaysIntoEdges(Map<Long, Way> ways){
        LinkedList<Edge> edges = new LinkedList<>();
        for (Way actualWay : ways.values()){
            List<Node> nodes = actualWay.getNodes();
            for(int i = 1;i< nodes.size();i++){
                edges.add(new Edge(
                        actualWay.getId(),
                        nodes.get(i-1),
                        nodes.get(i),
                        actualWay.getName(),
                        actualWay.getHighway(),
                        actualWay.getMaxSpeed()));
            }
        }
        return edges;
    }
}
