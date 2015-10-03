package Models;

public class MapNode {
	private double lat,lng,score;
	public MapNode(double x, double y, double s){
		lat=x;
		lng=y;
		score=s;
	}
	
	public double lat(){
		return lat;
	}
	public double lng(){
		return lng;
	}
	public double score(){
		return score;
	}
}
