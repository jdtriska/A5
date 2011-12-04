//****/
package ugraph;
import avp.*
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ugraph.UGraph;

import edu.cornell.cs.cs2110.RandomBag;


public class Ship implements UGraph<Node, Edge>, GameConstants {
	Set<Node> nodes;
	RandomBag<Edge> edgegrid;
	Set<Edge> edges;

	Ship() {
		nodes = new HashSet<Node>();
		edgegrid = new RandomBag<Edge>();
		edges = new HashSet<Edge>();
		int WIDTH = GameConstants.WIDTH;
		int HEIGHT = GameConstants.HEIGHT;
		int mult = WIDTH * HEIGHT;
		for(int y = 0; y < HEIGHT; y++)
			for(int x = 0; x < WIDTH; x++) {
				Node current = new Node(x, y);
				addNode(current);
				edgegrid.insert(new Edge((x+1)%WIDTH, y%HEIGHT)); /*********TO BE FIXED ************/
				edgegrid.insert(new Edge((x-1)%WIDTH, y%HEIGHT));
				edgegrid.insert(new Edge(x%WIDTH, (y+1)%HEIGHT));
				edgegrid.insert(new Edge(x%WIDTH, (y-1)%HEIGHT));
			}
		spanningTree();
		for(int x = 0; x < Math.sqrt(mult); x++) {
			Edge e = edgegrid.extract();
			if(edges.contains(e)==false)
				addEdge(e);
		}
	}

	public void addNode(Node node) {
		nodes.add(node);
	}
	public void removeNode(Node node) {
		nodes.remove(node);
		for(Edge e : edges) {
			Set<avp.Node> adj = e.getAdjacent();
			if(adj.contains(node))
				removeEdge(e);
		}
	}
	public void addEdge(Edge edge) {
		edges.add(edge);
	}
	public void removeEdge(Edge edge) {
		edges.remove(edge);
	}
	public UGraph<Node, Edge> clone() { /*********TO BE FIXED ************/
		UGraph<Node, Edge> news = new Ship();
		for(Node n : nodes) {
			Node newn = new Node(n.getX(), n.getY(), n.getAdjacent());	
			newn.setValue(n.getValue());
		}
		for(Edge e : edges) {
			Edge newe = new Edge(e.getAdjacent());		
		}
		return null;
	}
	public Set<Node> getNodes() {
		return nodes;
	}
	public Set<Edge> getEdges() {
		return edges;
	}
	public UGraph<Node, Edge> spanningTree() {
		UGraph<Node, Edge> news = new Ship();
		for(int y = 0; y < HEIGHT; y++)
			for(int x = 0; x < WIDTH; x++)
				news.addNode(new Node(x, y));
		while(edgegrid.size()>0)
			Edge e = edgegrid.extract();
			Set<Node> es = e.getAdjacent();
			if(getPath(es.
					pop(), es.pop()) == null)
				news.addEdge(e);
		return null;
	}
	public List<Edge> getPath(Node start, Node end) { /*********TO BE FIXED ************/
		Map<Node, Integer> dist = new HashMap<Node, Integer>();
		Map<Node, Node> prev = new HashMap<Node, Node>();
		
		
		Set<Edge> es = start.getAdjacent();
		for(Edge e : es) {
			visited.insert();
		}
		
		dist[start] = 0;
		nodes = all nodes in graph
		while(nodes != empty) {
			u = vertex in nodes with smallest distance in dist[]
			if(dist[u] == infinity)
				break;
			remove u from nodes
			if(u == target)
				
			for(neighvor v of u) {
				alt = dist[u] + dist_between(u,v);
				if(alt < dist[v]) {
					dist[v] = alt
					prev[v] = u
					decrease-key v in nodes
				}
			}
		}
		return null;

		/*
		dist = ( infinity )
		prev = ()
		settled = unsettled = ()

		add s to Q
		d(s) = 0

		while Q not empty
		{
		    find the smallest (as defined by d) vertex in Q
		    remove it from Q and return it as u
		     add u to S
		     for each vertex v adjacent to u, v not in S
		     {
		          if d(v) > d(u) + [u,v]    // a shorter distance exists
		          {
		               d(v) = d(u) + [u,v]
		               prev(v) = u
		               add v to Q
		          }
		     }
		}*/

		List<Edge> seq = new LinkedList<Edge>();
		Node x = end;
		while(prev[x] != null) {
			seq.insert(seq);
			x = prev[x];
		}
		return seq;
	}
}