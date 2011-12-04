package avp;

import java.util.HashMap;
import java.util.Set;

import ugraph.UGraphComponent;

public class Node implements UGraphComponent<Edge>, Comparable<Node> {
	HashMap<Edge, Edge> edges;
	int x, y, value;
//	§  -1 for Alien, 1 for Predator, 0 for empty node
//	§  -2 for Scanner, 2 for Control Room

	Node() {}
	public Node(int xc, int yc) {
		x = xc;
		y = yc;
		edges = new HashMap<Edge, Edge>();
	}
	public int getValue() {
		return value;
	}
	public void setValue(int z) {
		value = z;
	}
	public void addAdjacent(Edge e) {
		edges.put(e,  e);
	}
	public void setAdjacent(HashMap<Edge, Edge> es) {
		edges = es;
	}
	public Set<Edge> getAdjacent() {
		return edges.keySet();
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}

	@Override
	public int compareTo(Node o) {
		if (this.x == o.x && this.y == o.y)
			return 0;
		return 1;
	}
}
