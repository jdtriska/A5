package avp;

/**
 * The state of an edge. The Predator can change an edge from open to closed or
 * from closed to open. The Alien can change an edge from open/closed to burned
 * and can also add new burned edges.
 */
public enum EdgeState {
   OPEN, CLOSED, BURNED
}


