package avp;

import java.util.Set;

public class Node implements UGraphComponent<Edge> {
	Set<Edge> edges;
	int value;
//	§  -1 for Alien, 1 for Predator, 0 for empty node
//	§  -2 for Scanner, 2 for Control Room

	Node() {}
	Node(Edge e1) {
		edges.add(e1);
	}
	Node(Set<Edge> es) {
		edges.addAll(es);
	}

	public int getValue() {
		return value;
	}
	public void setValue(int x) {
		value = x;
	}
	public Set<Edge> getAdjacent() {
		return edges;
	}
}
