package avp;

import java.util.Set;
import avp.EdgeState;

public class Edge implements UGraphComponent<Node> {
	Set<Node> endpoints;
	EdgeState state;

	Edge() {}
	Edge(Node n1, Node n2) {
		endpoints.add(n1);
		endpoints.add(n2);
	}

	public Set<Node> getAdjacent() {
		return endpoints;
	}
}
