package avp;

public class Engine {
	static boolean alienNext;	
	Predator predator;
	Alien alien; 
	Info pInfo; //predator's info
	Info aInfo; //alien's info
	int aCounter; //specifies alien's number of turns remaining until last move is completed
	int pCounter;//specifies predator's number of turns remaining until last move is completed
	
	public static void main(String[] args) {
		Ship ship= new Ship();
		init();
		while (predator is not in control room and alien is not in predators node){
			if (alienNext){
				alien.nextMove(aInfo);
				update aInfo
					if predator has scanner update myship to actual
					Update state of any edges
					Check whether alien can now sense predator
				alienNext= false
			}
			else{
				predator.nextMove(pInfo)
				update pInfo
					if predator has scanner update myship to actual
					Update state of any edges
					Check whether predator can now sense alien
				alienNext= true
				
			}
		}
		if (predator is in control room) print "predator wins"
		if (alien is in predator node) print "alien wins"
	}

	
	public static void init(){
		predator= new Predator();
		alien= new Alien();
		predator.init(ship);
		alien.init(ship);
	}

}
