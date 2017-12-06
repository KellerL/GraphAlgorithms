package figures;

import action.Distance;

public class Node {

    private long id;
    private double lat;
    private double lon;

    public Node(){ 
    	
    }


    public Node(long id, double lat, double lon){
        this.id = id;
        this.lat = lat;
        this.lon = lon;
    }

    public double getLat() { 
    	return lat; 
    }
    public double getLon() { 
    	return lon; 
    }
    public long getId() { 
    	return id; 
    }
    public void setId(long id) { 
    	this.id = id; 
    }
    public void setLat(double lat) { 
    	this.lat = lat; 
    }
    public void setLon(double lon) { 
    	this.lon = lon; 
    }

    public double getDistance(Node other){
        return Distance.calcDistance(lat,lon,other.getLat(),other.getLon());
    }
    
    public String toString(){
    	return "id:" + id ;
    }
}
