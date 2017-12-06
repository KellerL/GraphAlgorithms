package figures;

import java.util.LinkedList;
import java.util.List;

import action.Distance;


public class Way {

    private long id;
    private List<Node> nodes;
    private String name;
    private String highway;
    private int maxSpeed;
    private double distance = -1;

    public Way() { 
    	
    }
    public Way(long id){
        this.id = id;
        this.nodes = new LinkedList<Node>();
    }

    public List<Node> getNodes(){ 
    	return nodes;
    }
    public long getId(){ 
    	return id; 
    }
    public void setId(long id){ 
    	this.id = id; 
    }
    public void addNodes(Node node){ 
    	this.nodes.add(node); 
    }
    public int getMaxSpeed(){ 
    	return maxSpeed; 
    }
    public String getHighway(){ 
    	return highway; 
    }
    public void setHighway(String highway){ 
    	this.highway = highway; 
    }
    public String getName(){ 
    	return name; 
    }
    public void setMaxSpeed(int maxSpeed){ 
    	this.maxSpeed = maxSpeed; 
    }
    public void setName(String name){
    	this.name = name; 
    }
    public double getDistance(){
        if(distance==-1) {
            double distance = 0.0;
            for (int i = 1; i < nodes.size(); i++) {
                Node first = nodes.get(i);
                Node second = nodes.get(i - 1);
                distance += Distance.calcDistance(first.getLat(), first.getLon(), second.getLat(), second.getLon());
            }
            this.distance= distance;
        }
        return this.distance;
    }
}
