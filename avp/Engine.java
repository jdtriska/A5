package avp;
import ugraph.*;

public class Engine {
	static boolean alienNext;
	private Ship ship;
	private Predator predator;
	private Alien alien;
	private Node pNode; //predator's location
	private Node aNode; // alien's location
	private Node sNode; //scanner's location
	private Node cNode; //control room's location
	private Info pInfo; //predator's info
	private Info aInfo; //alien's info
	int aCounter; //specifies alien's number of turns remaining until last move is completed
	int pCounter;//specifies predator's number of turns remaining until last move is completed
	
	private final int ALIEN = 0;
	private final int PREDATOR = 1;
	private final int SCANNER = 2;
	private final int CONTROL = 3;
	
	public Engine() {
		ship = new Ship();
		predator = new Predator();
		alien = new Alien();
		predator.init(ship);
		alien.init(ship);
		aNode = getNode(ALIEN);
		pNode = getNode(PREDATOR);
		sNode = getNode(SCANNER);
		cNode = getNode(CONTROL);
		play();
	}
	
	private Node getNode(int type) {
		//get initial node for alien (type 0) predator (type 1) scanner (type 2) and control room (type 3)
		switch(type) {
		case ALIEN:
			return null;
		case PREDATOR:
			return null;
		case SCANNER:
			return null;
		case CONTROL:
			return null;
		default:
			return null;
		}
	}

	public static void main(String[] args) {
		new Engine();
	}
	
	public void play() {
		while (!pInfo.atControlRoom && aNode.compareTo(pNode) != 0){
			pInfo = updateInfo(pInfo, PREDATOR);
			aInfo = updateInfo(aInfo, ALIEN);
			if (alienNext){
				alien.nextMove(aInfo);
				alienNext = false;
					/*DEPRECATED: if Alien has scanner update myship to actual
					Update state of any edges
					Check whether alien can now sense predator*/

			}
			else{
				predator.nextMove(pInfo);
				alienNext = true;
					/*DEPRECATED: if predator has scanner update myship to actual
					Update state of any edges
					Check whether predator can now sense alien*/
			}
		}
		
		//if (predator is in control room) print "predator wins"
		//if (alien is in predator node) print "alien wins"
	}

	public Info updateInfo(Info i, int t) {
		Info inf = new Info();
		switch(t) {
		case ALIEN:
			break;
		case PREDATOR:
			break;
		}
		return inf;
	}
}
