package Models;

public class Grid {
	private double [][] grid;
	private double originLat, originLng, nodesPerDeg;
	
	public Grid(int resolution, double originLat, double originLng, double nodesPerDeg){
		grid = new double[resolution][resolution];
		this.originLat=originLat;
		this.originLng=originLng;
		this.nodesPerDeg=nodesPerDeg;
	}
	
	public void register(Event event){
		int xCoord=latToX(event.getLat()), yCoord=lngToY(event.getLng());
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
}
