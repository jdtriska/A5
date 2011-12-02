package ugraph;

import java.util.Set;

/**
 * Describes a component of an undirected graph, either a node or an edge.
 * 
 * @param <C>
 *           the type of the other component
 */
public interface UGraphComponent<C> {

   /**
    * Gets the set of components adjacent to this component. For an edge,
    * returns the two endpoints. For a node, returns the set of all adjacent
    * edges.
    * 
    * @return the set of adjacent components -- endpoints for edges, adjacent
    *         edges for nodes.
    */
   public Set<C> getAdjacent();

}
