package avp;

/**
 * Compile time game constants. Subject to change! Implement this interface to
 * use these constants.
 */
public interface GameConstants {

   /**
    * Width of the ship.
    */
   int WIDTH = 36;

   /**
    * Height of the ship.
    */
   int HEIGHT = 24;

   /**
    * Number of extra time units it takes the Predator to open a closed door.
    */
   int OPEN_TIME = 1;

   /**
    * Distance through open space the Predator can sense the presence of the
    * Alien.
    */
   int PRED_SENSE = 5;

   /**
    * Distance through open space the Alien can sense the Predator.
    */
   int ALIEN_SENSE = 10;

   /**
    * Number of time units the Alien can use per turn. The Predator may only use
    * one time unit per turn.
    */
   int SPEED_RATIO = 3;

   /**
    * Number of extra time units required for the Alien to burn through a wall
    * or door.
    */
   int BURN_TIME = 2;

}
