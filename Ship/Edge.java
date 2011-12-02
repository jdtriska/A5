package ugraph;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Edge implements UGraphComponent<Node> {
	Set<Node> endpoints;

	Edge() {}
	Edge(Node n1, Node n2) {
		endpoints = new HashSet<Node>();
		endpoints.add(n1);
		endpoints.add(n2);
	}
	Edge(Set<Node> ns) {
		Iterator<Node> i = ns.iterator();
		while(i.hasNext()) {
			endpoints.add((Node) i.next());
		}
	}
	
	public Set<Node> getAdjacent() {
		return endpoints;
	}
}
