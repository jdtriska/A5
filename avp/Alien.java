//hello world

package avp;

import Ship.*;

public class Alien implements Agent {

	//represents alien's perception of the ship
	private Ship myShip;
	
	/**
	    * Called to initialize the agent. The parameter ship gives the agent's
	    * initial view of the ship. It is {@code null} for the Alien and reality for
	    * the Predator.
	    * 
	    * @param ship
	    *           the initial state of the ship for the Predator and {@code null}
	    *           for the Alien.
	    */
	   public void init(Ship ship) {
		   this.myShip = ship;
	   }

	   /**
	    * Called by the game engine to get the agent's desired next move.
	    * 
	    * @param info
	    *           the information about the current state supplied to the agent.
	    * @return the agent's desired next move.
	    */
	   public Move nextMove(Info info) {
		   Move m = new Move();
		   if (info.adversaryPresent) {
			   m.edge = info.adversaryDirection;
			   m.move = true;
			   m.changeState = false;
		   }
		   else {
			   
		   }
		   
		   //Edge move= myShip.getPath(aNode, pNode).get(0);
		   //else if ( move to random node along unburnt edge
		   //else burn a door and move to a random node
		   
	     
		   
		   return null;
	   }
	}
