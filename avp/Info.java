package avp;
import ugraph.*;
import java.util.Set;

/**
 * Information passed to the agents when requesting their desired next move.
 */
public class Info {

   /**
    * The set of all edges adjacent to the node currently occupied by the agent.
    */
   Set<Edge> adjacentEdges;

   /**
    * Is the agent currently in the control room? Always false for the Alien.
    */
   boolean atControlRoom;

   /**
    * Is the agent currently occupying the same node as the scanner?
    */
   boolean atScanner;

   /**
    * A map of the ship in its true state. Provided to the agent who has found
    * the scanner, {@code null} otherwise.
    */
   Ship ship;

   /**
    * Is the adversary within the sensing distance of the agent?
    */
   boolean adversaryPresent;

   /**
    * Direction to travel to get to the adversary along open corridors if
    * adversaryPresent is true; otherwise null
    */
   Edge adversaryDirection;

   /**
    * Edge the Alien can burn through to get to the Predator if the Predator is
    * directly on the other side of the wall. The Alien's {@code nextMove}
    * method should return this edge to signal the desire to burn through the
    * wall. The edge will be added to the graph in the burned state.
    * 
    * Always null for the Predator.
    */
   Edge adversaryThruWall;  

}
