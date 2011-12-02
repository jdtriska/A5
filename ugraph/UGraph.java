package ugraph;

import java.util.List;
import java.util.Set;

/**
 * A representation of an undirected graph. The graph consists of nodes and
 * edges. Each node has a set of zero or more adjacent edges and each edges has
 * a set of two adjacent nodes. Implementing classes must have a parameterless
 * constructor.
 * 
 * @param <N>
 *           The type of the nodes.
 * @param <E>
 *           The type of the edges.
 */
public interface UGraph<N extends UGraphComponent<E>, E extends UGraphComponent<N>> {

   /**
    * Adds a node to the graph.
    * 
    * @param node
    *           the node to add.
    */
   public void addNode(N node);

   /**
    * Removes a node from the graph. All adjacent edges should also be removed.
    * 
    * @param node
    *           the node to remove.
    */
   public void removeNode(N node);

   /**
    * Adds an edge to the graph.
    * 
    * @param edge
    *           the edge to remove.
    */
   public void addEdge(E edge);

   /**
    * Removes an edge from the graph.
    * 
    * @param edge
    *           the edge to remove.
    */
   public void removeEdge(E edge);

   /**
    * Make a deep copy of this graph.
    * 
    * @return a deep copy of the graph.
    */
   public UGraph<N, E> clone();

   /**
    * Gets the set of nodes of this graph.
    * 
    * @return the set of nodes of this graph.
    */
   public Set<N> getNodes();

   /**
    * Gets the set of edges of this graph.
    * 
    * @return the set of edges of this graph.
    */
   public Set<E> getEdges();

   /**
    * Gets a spanning forest of this graph, i.e. a subgraph of the original
    * graph with the same connected components but no cycles. If this graph is
    * connected, a spanning tree will be returned.
    * 
    * @return a spanning forest of this graph.
    */
   public UGraph<N, E> spanningTree();

   /**
    * Gets a path in this graph from the given start node to the given end node.
    * If there is no path, {@code null} is returned.
    * 
    * @return a path in the graph from the start node to the end node.
    * @return {@code null} if there is no such path.
    */
   public List<E> getPath(N start, N end);

}
