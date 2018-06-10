package WallmartLabs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TanksAndObjects {

	public static char[] getDirections(Point tanks[],Point objects []){
		char [] result = new char [tanks.length];
		Map<Integer,List<Point>> xMap = new HashMap<Integer,List<Point>>();
		Map<Integer,List<Point>> yMap = new HashMap<Integer,List<Point>>();
	
		createMap(xMap,objects, true);
		createMap(yMap,objects, false);
		createMap(xMap,tanks, true);
		createMap(yMap,tanks, false);
		
		int i=0;
		for(Point tank: tanks){
			boolean E=true,W=true,N=true,S=true;
			List<Point> xList = xMap.get(tank.x);
			for(Point p: xList){
				if(p.y==tank.y)
					continue;
				if(p.y<tank.y)
					S=false;
				if(p.y>tank.y)
					N=false;
			}
			
			List<Point> yList = yMap.get(tank.y);
			for(Point p: yList){
				if(p.x==tank.x)
					continue;
				if(p.x<tank.x)
					W=false;
				if(p.x>tank.x)
					E=false;
			}
			
			if(E)
				result[i]='E';
			else if(N)
				result[i]='N';
			else if(S)
				result[i]='S';
			else if(W)
				result[i]='W';
			else
				result[i]='X';
			i++;
		}
		
		return result;
	}
	
	public static void createMap(Map<Integer,List<Point>> map, Point [] points, boolean X){
		for(Point point: points){
			int coord = X?point.x:point.y;
			if(map.containsKey(coord)){
				List<Point> l=map.get(coord);
				l.add(point);
			} else {
				List<Point> l = new ArrayList<Point>();
				l.add(point);
				map.put(coord, l);
			}
		}
	}
	
	public static void main(String[] args) {
		Point [] tanks = {new Point(0,0),new Point(1,1)};
		Point [] objects = {new Point(0,2),new Point(0,-2),new Point(2,0)};
		System.out.println(Arrays.toString(getDirections(tanks,objects)));

	}

}

class Point{
	int x;
	int y;
	
	public Point(int x,int y){
		this.x=x;
		this.y=y;
	}
}
