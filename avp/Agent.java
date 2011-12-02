package avp;

/**
 * Describes the functionality of an agent, either the Alien or the Predator.
 * Implementing classes must have a parameterless constructor.
 */
public interface Agent {

   /**
    * Called to initialize the agent. The parameter ship gives the agent's
    * initial view of the ship. It is {@code null} for the Alien and reality for
    * the Predator.
    * 
    * @param ship
    *           the initial state of the ship for the Predator and {@code null}
    *           for the Alien.
    */
   public void init(Ship ship);

   /**
    * Called by the game engine to get the agent's desired next move.
    * 
    * @param info
    *           the information about the current state supplied to the agent.
    * @return the agent's desired next move.
    */
   public Move nextMove(Info info);

}
