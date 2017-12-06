package figures;

import action.Distance;

public class Edge {

    private long wayId;
    private Node startNode;
    private Node endNode;
    private double length;
    private String name;
    private String highway;
    private int maxSpeed;

    public Edge() { 
    	
    }

    public Edge(long wayId,Node startNode,Node endNode,String name,String highway,int maxSpeed){
        this.wayId = wayId;
        this.startNode = startNode;
        this.endNode = endNode;
        this.name = name;
        this.highway = highway;
        this.maxSpeed = maxSpeed;
        this.length = Distance.calcDistance(startNode.getLat(),startNode.getLon(),endNode.getLat(),endNode.getLon());
    }

    public double getLength() { 
    	return length; 
    }

	public long getWayId() {
		return wayId;
	}

	public void setWayId(long wayId) {
		this.wayId = wayId;
	}

	public Node getStartNode() {
		return startNode;
	}

	public void setStartNode(Node startNode) {
		this.startNode = startNode;
	}

	public Node getEndNode() {
		return endNode;
	}

	public void setEndNode(Node endNode) {
		this.endNode = endNode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHighway() {
		return highway;
	}

	public void setHighway(String highway) {
		this.highway = highway;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public void setLength(double length) {
		this.length = length;
	}
    
    

}

