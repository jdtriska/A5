package avp;

import java.util.Iterator;

public class Engine {
	static boolean alienNext = false;
	private Ship ship;
	private Predator predator;
	private Alien alien;
	private Node pNode; //predator's location
	private Node aNode; // alien's location
	private Node sNode; //scanner's location
	private Node cNode; //control room's location
	private Info pInfo; //predator's info
	private Info aInfo; //alien's info
	private GUI avpGUI;
	int aCounter; //specifies alien's number of turns remaining until last move is completed
	int pCounter;//specifies predator's number of turns remaining until last move is completed
	final int SPEED_RATIO = 2;
	
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
		cNode = getNode(CONTROL);
		sNode = getNode(SCANNER);
		aNode = getNode(ALIEN);
		pNode = getNode(PREDATOR);
		avpGUI = new GUI(ship);
		avpGUI.setVisible(true);
		play();
	}
	
	private Node getNode(int type) {/************IN PROGRESS*************/
		//get initial node for alien, predator, scanner, and control room
		boolean flag = true;
		Node n = new Node();
		switch(type) {
		case ALIEN:
			while(flag) {
				n = getRandomNode(ship);
				if(n.getValue() == 0) {
					n.setValue(-1);
					flag = false;
				}
				}
			return n;
		case PREDATOR:
			while(flag) {
				n = getRandomNode(ship);
				if(n.getValue() == 0) {
					n.setValue(1);
					flag = false;
				}
			}
			return n;
		case SCANNER:
			while(flag) {
				n = getRandomNode(ship);
				if(n.getValue() == 0) {
					n.setValue(-2);
					flag = false;
				}
			}
			return n;
		case CONTROL:
			while(flag) {
				n = getRandomNode(ship);
				if(n.getValue() == 0) {
					n.setValue(2);
					flag = false;
				}
			}
			return n;
		default:
			return null;
		}
	}

	public static void main(String[] args) {
		new Engine();
	}
	
	public void play() {/************IN PROGRESS*************/
		int aMoves = SPEED_RATIO;
		while (!pInfo.atControlRoom && aNode.compareTo(pNode) != 0){
			avpGUI.repaint();
			pInfo = updateInfo(pInfo, PREDATOR);
			aInfo = updateInfo(aInfo, ALIEN);
			Move move = new Move();
			if (alienNext){
				
				move = alien.nextMove(aInfo);
				if (move.move = true && move.edge != null) {
					
				}
				
					/*DEPRECATED: if Alien has scanner update myship to actual
					Update state of any edges
					Check whether alien can now sense predator*/
				if(aMoves == 0);
					alienNext = false;
				aMoves--;
			}
			else{
				predator.nextMove(pInfo);
				alienNext = true;
					/*DEPRECATED: if predator has scanner update myship to actual
					Update state of any edges
					Check whether predator can now sense alien*/
			}
		}
		//Who won?
		if(pNode.compareTo(aNode) == 0) {
			System.out.println("Alien wins!");
		}
		else if(pInfo.atControlRoom) {
			System.out.println("Predator wins!");
		}
	}
//updates info for Alien and Predator
	public Info updateInfo(Info i, int t) {/************IN PROGRESS*************/
		switch(t) {
		case ALIEN:
			break;
		case PREDATOR:
			break;
		}
		return i;
	}
	public Node getRandomNode(Ship s) {
		Node rNode = new Node();
		int shipSize = s.getNodes().size();
		Iterator iter = s.getNodes().iterator();
		for(int i = 0; i < (shipSize - 1); i++) {
			rNode = (Node) iter.next();
		}
		return rNode;
	}
}
