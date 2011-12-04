package avp;
import ugraph.Edge;

public class Move {

   /**
    * Edge to move along or to set the EdgeState of.
    */
   Edge edge;

   /**
    * Indicates desire to move along the specified edge. {@code true} if the
    * agent wishes to move along the edge, {@code false} if the agent wishes to
    * just change the state of the edge but not move.
    */
   boolean move;

   /**
    * Indicates the desire to change the state of an edge. If {@code true}, for
    * the Predator, if the state is OPEN, the state will be change to CLOSED,
    * and vice versa. For the Alien, the state will change to BURNED. If the
    * edge is burned, any change of state specified by the Predator is ignored.
    * {@code false} if no state change is desired.
    */
   boolean changeState;

}
