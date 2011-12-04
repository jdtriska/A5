package avp;

import java.util.HashMap;
import java.util.Set;

import ugraph.UGraphComponent;

public class Edge implements UGraphComponent<Node>, Comparable<Edge> {
	HashMap<Node, Node> endpoints;
	private boolean open, burned;

	public Edge(Node n1, Node n2) {
		endpoints = new HashMap<Node, Node>();
		endpoints.put(n1, n1);
		endpoints.put(n2, n2);
		setOpen(true);
		setBurned(false);
	}
	public void setAdjacent(Node n1, Node n2) {
		endpoints.put(n1, n1);
		endpoints.put(n2, n2);
	}
	public Set<Node> getAdjacent() {
		return endpoints.keySet();
	}
	@Override
	public int compareTo(Edge arg0) {
		Set<Node> thisA = this.getAdjacent();
		Set<Node> argA = arg0.getAdjacent();
		if(thisA.containsAll(argA)) 
			return 0;
		return 1;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	public boolean isBurned() {
		return burned;
	}
	public void setBurned(boolean burned) {
		this.burned = burned;
	}
}
