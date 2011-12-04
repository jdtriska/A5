package avp;
import ugraph.*;

public class Engine {
	static boolean alienNext;
	private Ship ship;
	private Predator predator;
	private Alien alien; 
	private static Info pInfo; //predator's info
	private static Info aInfo; //alien's info
	int aCounter; //specifies alien's number of turns remaining until last move is completed
	int pCounter;//specifies predator's number of turns remaining until last move is completed
	
	public Engine() {
		ship = new Ship();
		predator = new Predator();
		alien = new Alien();
		predator.init(ship);
		alien.init(ship);
		pInfo = updateInfo(pInfo);
		aInfo = updateInfo(aInfo);
		play();
	}
	
	public static void main(String[] args) {
		new Engine();
	}
	
	public void play() {
		pInfo = updateInfo(pInfo);
		aInfo = updateInfo(aInfo);
		while (!pInfo.atControlRoom && ){
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

	public static Info updateInfo(Info i) {
		Info inf = new Info();
		return inf;
	}
}
