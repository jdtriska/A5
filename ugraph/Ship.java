//****/
package avp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ugraph.UGraph;

import edu.cornell.cs.cs2110.RandomBag;


public class Ship implements UGraph<Node, Edge>, GameConstants {
	Map<Node, Node> nodes;
	RandomBag<Edge> edgegrid;
	Map<Edge, Edge> edges;

	Ship() {
		nodes = new HashMap<Node, Node>();
		edgegrid = new RandomBag<Edge>();
		edges = new HashMap<Edge, Edge>();
		int WIDTH = GameConstants.WIDTH;
		int HEIGHT = GameConstants.HEIGHT;
		int mult = WIDTH * HEIGHT;
		for(int y = 0; y < HEIGHT; y++)
			for(int x = 0; x < WIDTH; x++) {
				Node current = new Node(x, y);
				addNode(current);
				edgegrid.insert(new Edge(current, new Node((x+1)%WIDTH, y%HEIGHT)));
				edgegrid.insert(new Edge(current, new Node((x-1)%WIDTH, y%HEIGHT)));
				edgegrid.insert(new Edge(current, new Node(x%WIDTH, (y+1)%HEIGHT)));
				edgegrid.insert(new Edge(current, new Node(x%WIDTH, (y-1)%HEIGHT)));
			}
		spanningTree();
		for(int x = 0; x < Math.sqrt(mult); x++) {
			Edge e = edgegrid.extract();
			if(edges.containsKey(e)==false)
				addEdge(e);
		}
	}

	Ship(Map<Node, Node> nm, Map<Edge, Edge> em) {
		nodes = nm;
		edges = em;
	}
	
	public void addNode(Node node) {
		nodes.put(node, node);
	}
	public void removeNode(Node node) {
		nodes.remove(node);
		for(Edge e : edges.keySet()) {
			Set<avp.Node> adj = e.getAdjacent();
			if(adj.contains(node))
				removeEdge(e);
		}
	}
	public void addEdge(Edge edge) {
		edges.put(edge, edge);
	}
	public void removeEdge(Edge edge) {
		edges.remove(edge);
	}
	public UGraph<Node, Edge> clone() {
		HashMap<Node, Node> newnm = new HashMap<Node, Node>();
		HashMap<Edge, Edge> newem = new HashMap<Edge, Edge>();
		
		for(Node n : nodes.keySet()) {
			Node tempnode = new Node(n.getX(), n.getY());
			tempnode.setValue(n.getValue());
			newnm.put(tempnode,  tempnode);

		}
		for(Node n : nodes.keySet()) {
			Set<Edge> tempedges = n.getAdjacent();
			HashMap<Edge, Edge> newadjedges = new HashMap<Edge, Edge>();
			Iterator<Edge> iter = tempedges.iterator();
			while(iter.hasNext()) {
				Edge tempedge = (Edge)(iter.next());
				Set<Node> tempnodes = tempedge.getAdjacent();
				Node start = (Node)(tempnodes.iterator().next());
				Node end = (Node)(tempnodes.iterator().next());
				
				Node newStart = newnm.get(start);
				Node newEnd = newnm.get(end);
				
				Edge newEdge = new Edge(newStart, newEnd);
				newem.put(newEdge,  newEdge);
				
				newadjedges.put(newEdge, newEdge);
			}
			newnm.get(n).setAdjacent(newadjedges);			
		}
		UGraph<Node, Edge> news = new Ship(newnm, newem);
		return news;
	}
	public Set<Node> getNodes() {
		return nodes.keySet();
	}
	public Set<Edge> getEdges() {
		return edges.keySet();
	}
	public UGraph<Node, Edge> spanningTree() {
		UGraph<Node, Edge> news = new Ship();
		for(int y = 0; y < HEIGHT; y++)
			for(int x = 0; x < WIDTH; x++)
				news.addNode(new Node(x, y));
		while(edgegrid.size()>0) {
			Edge e = edgegrid.extract();
			Set<Node> es = e.getAdjacent();
			
			Node start = (Node)(es.iterator().next());
			Node end = (Node)(es.iterator().next());
			
			if(getPath(start, end) == null)
				news.addEdge(e);
		}
		return news;
	}
	public List<Edge> getPath(Node start, Node end) { /*********TO BE FIXED ************/
		Map<Node, Integer> dist = new HashMap<Node, Integer>();
		Map<Node, Node> prev = new HashMap<Node, Node>();
		
		/*
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

*/

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
		/*Node x = end;
		while(prev[x] != null) {
			seq.insert(seq);
			x = prev[x];
		}*/
		return seq;
	}
}