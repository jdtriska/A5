package avp;
import ugraph.*;

public class Predator implements Agent {

	//represents predator's perception of the ship
		private Ship myShip;
		public Predator() {
			myShip = null;
		}
	/**
	    * Called to initialize the agent. The parameter ship gives the agent's
	    * initial view of the ship. It is {@code null} for the Alien and reality for
	    * the Predator.
	    * 
	    * @param ship
	    *           the initial state of the ship for the Predator and {@code null}
	    *           for the Alien.
	    */
	   public void init(Ship ship){
		   myShip = ship;
		   //get the control room node 
		   //pick random nodes until you get to one that is a certain distance, place predator there
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
			   m.move = true;
			   m.edge = info.adversaryDirection;
			   m.changeState = false;
		   }
		   /*if (this.sensesAlien()) && (info.adversaryDirection != myShip.getPath(pNode, crnode).get(0)){
				   Move thisMove= new Move();
				   thisMove.edge= myShip.getPath(pNode, crnode).get(0);
				   thisMove.changeState= true;}
				else {
				Move thisMove= new Move();
				thisMove.edge= myShip.getPath(pNode, crnode).get(0);
				thisMove.changeState= false;
				}	
		    */
		   return null;
	   }
   }
