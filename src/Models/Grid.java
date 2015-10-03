package Models;

import java.util.ArrayList;
import java.util.List;

public class Grid {
	private double [][] grid;
	private double originLat, originLng, nodesPerDeg;
	private int resolution;
	
	public Grid(int resolution, double originLat, double originLng, double nodesPerDeg){
		grid = new double[resolution][resolution];
		this.resolution=resolution;
		this.originLat=originLat;
		this.originLng=originLng;
		this.nodesPerDeg=nodesPerDeg;
	}
	
	public void register(Event event){
		int xCoord=latToX(event.getLat()), yCoord=lngToY(event.getLng());
		System.out.println(xCoord+" "+yCoord);
		grid[xCoord][yCoord]+=(event.getEventType().score())
				*java.lang.Math.log10((double)(event.getPeople()));
	}
	
	public double getScore(double lat, double lng){
		return grid[latToX(lat)][lngToY(lng)];
	}
	
	private int latToX(double lat){
		return (int)((lat-originLat)*nodesPerDeg);
	}
	
	private int lngToY(double lng){
		return (int)((lng-originLng)*nodesPerDeg);
	}
	
	private double xToLat(int x){
		return originLat+((double)x)/nodesPerDeg;
	}
	
	private double yToLng(int y){
		return originLng+((double)y)/nodesPerDeg;
	}

	public List<MapNode> getNodes() {
		List<MapNode> list = new ArrayList<MapNode>();
		for(int x=0;x<resolution;x++)
			for(int y=0;y<resolution;y++){
				MapNode node = new MapNode();
				node.setLat(xToLat(x));
				node.setLng(yToLng(y));
				node.setScore(grid[x][y]);
				list.add(node);
			}
		return list;
	}
}
