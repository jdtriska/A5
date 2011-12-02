package ugraph;

import java.util.HashSet;
import java.util.Set;

public class Node implements UGraphComponent<Edge> {
	Set<Edge> edges;
	int x, y, value;
//	§  -1 for Alien, 1 for Predator, 0 for empty node
//	§  -2 for Scanner, 2 for Control Room

	Node() {}
	Node(int xc, int yc) {
		x = xc;
		y = yc;
		edges = new HashSet<Edge>();
	}
	Node(int xc, int yc, Edge e1) {
		x = xc;
		y = yc;
		edges = new HashSet<Edge>();
		edges.add(e1);
	}
	Node(int xc, int yc, Set<Edge> es) {
		x = xc;
		y = yc;
		edges = new HashSet<Edge>();
		edges.addAll(es);
	}
	public int getValue() {
		return value;
	}
	public void setValue(int z) {
		value = z;
	}
	public Set<Edge> getAdjacent() {
		return edges;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
