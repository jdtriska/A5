package avp;

import java.util.Iterator;
import java.util.Random;

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
	int aCounter = 0; //specifies alien's number of turns remaining until last move is completed
	int pCounter = 0;//specifies predator's number of turns remaining until last move is completed
	final int SPEED_RATIO = 2;
	private boolean burning;
	private boolean opening;
	private boolean closing;
	private boolean aMoving;
	private boolean pMoving;
	private Edge aEdge;
	private Edge pEdge;
	private int scanHold;
	
	private final int ALIEN = 0;
	private final int PREDATOR = 1;
	private final int SCANNER = 2;
	private final int CONTROL = 3;
	private final int OPEN_TIME = 1;
	private final int CLOSE_TIME = 1;
	private final int BURN_TIME = 2;
	private final int MOVE_TIME = 1;
	private final int PRED_SENSE = 5;
	private final int ALIEN_SENSE = 10;
	
	public Engine() {
		System.out.println("here");
		ship = new Ship();
		predator = new Predator();
		alien = new Alien();
		predator.init(ship);
		alien.init(ship);
		cNode = getNode(CONTROL);
		sNode = getNode(SCANNER);
		aNode = getNode(ALIEN);
		pNode = getNode(PREDATOR);
		System.out.println(aNode.toString());
		System.out.println(pNode.toString());
		avpGUI = new GUI(ship);
		avpGUI.setVisible(true);
		play();
	}
	
	private Node getNode(int type) {/************IN PROGRESS*************/
		//get initial node for alien, predator, scanner, and control room
		
		//right now, this simply places them in a random location
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
	//main running loop
	public void play() {/************IN PROGRESS*************/
		int aMoves = SPEED_RATIO;
		while (win() == 0){
			//update GUI
			avpGUI.repaint();
			//update the Info objects for alien and predator
			pInfo = updateInfo(pInfo, PREDATOR);
			aInfo = updateInfo(aInfo, ALIEN);
			Move move = new Move();
			//Alien move code
			if (alienNext){ //checks if it's the alien's turn
				//checks if the alien is currently performing an action
				if (aCounter == 0) {
					//get next move
					move = alien.nextMove(aInfo);
					//store working edge
					aEdge = move.edge;
					//checks if the edge exists
					if (ship.edges.containsKey(aEdge)) {
						//move through door
						if (move.move && aEdge.isOpen()) {
							aMoving = true;
							aCounter = MOVE_TIME;
						}
						//burn door
						if(move.changeState && !aEdge.isOpen()) {
							burning = true;
							aCounter = BURN_TIME;
						}
					}
					//add edge and burn
					else if(move.changeState) {
						ship.addEdge(aEdge);
						burning = true;
						aCounter = BURN_TIME;
					}
				}
				aMoves--; //decrement number of moves alien has left
				if(aMoves == 0); { //if the alien is out of moves, set alienNext flag to false and reset number of moves
					alienNext = false;
					aMoves = SPEED_RATIO;
				}
				//decrement time remaing on current action
				if (aCounter > 0) {
					aCounter--;
				}
				//burn door (it is done here so burning is done after turns elapse. this is true for all other actions
				if (burning && aCounter == 0) {
					aEdge.setBurned(true);
					burning = false;
				}
				//move agent
				if (aMoving && aCounter == 0) {
					aNode.setValue(0);
					Iterator<Node> iter = aEdge.getAdjacent().iterator();
					while(iter.hasNext()) {
						Node temp = iter.next();
						if (aNode.compareTo(temp) != 0) {
							aNode = temp;
							aNode.setValue(-1);
						}
					}
					aMoving = false;
				}

			}
			//Predator move code
			else {
				//checks if current action is finished
				if (pCounter == 0) {
					//get move
					move = predator.nextMove(pInfo);
					//store working edge
					pEdge = move.edge;
					//
					if (move.move && pEdge.isOpen()) {
					//move through door
						pMoving = true;
						//close door behind
						if (move.changeState && !pEdge.isBurned())
						{
							opening = true;
						}
						pCounter = MOVE_TIME;
					}
						//open adjacent door
						if(move.changeState && !pEdge.isOpen()) {
							opening = true;
							pCounter = OPEN_TIME;
						}
						//close adjacent door
						if(!move.move && move.changeState && pEdge.isOpen() && !pEdge.isBurned()) {
							closing = true;
							pCounter = CLOSE_TIME;
						}
				}
				//decrement time remaining on current action
				if (pCounter > 0) {
					pCounter--;
				}
				//open door
				if (closing && pCounter == 0) {
					pEdge.setOpen(false);
					opening = false;
				}
				//close door
				if (opening && pCounter == 0) {
					pEdge.setOpen(true);
					opening = false;
				}
				//move agent
				if (pMoving && pCounter == 0) {
					pNode.setValue(0);
					Iterator<Node> iter = move.edge.getAdjacent().iterator();
					while(iter.hasNext()) {
						Node temp = iter.next();
						if (pNode.compareTo(temp) != 0) {
							pNode = temp;
							pNode.setValue(1);
						}
					}
					pMoving = false;
				}
			}
		}
		//Who won?
		if(win() == 1) {
			System.out.println("Predator wins!");
		}
		else if(win() == 2) {
			System.out.println("Alien wins!");
		}

	}
//updates info for Alien and Predator
	public Info updateInfo(Info i, int t) {/************IN PROGRESS*************/
		switch(t) {
		case ALIEN:
			i.adjacentEdges = aNode.getAdjacent();
			i.atControlRoom = false;
			if (aNode.compareTo(sNode) == 0) {
				scanHold = ALIEN;
				sNode = null;
			}
			if (scanHold == ALIEN)
				i.ship = ship;
			else
				i.ship = null;
			//to do: adversaryPresent, adversaryDirection, adversaryThroughWall
			break;
		case PREDATOR:
			i.adjacentEdges = pNode.getAdjacent();
			if (pNode.compareTo(cNode) == 0)
				i.atControlRoom = true;
			else
				i.atControlRoom = false;
			if (pNode.compareTo(sNode) == 0) {
				scanHold = PREDATOR;
				sNode = null;
			}
			if (scanHold == PREDATOR)
				i.ship = ship;
			else
				i.ship = null;
			//to do: adversaryPresent, adversaryDirection, adversaryThroughWall
			break;
		}
			
		return i;
	}
	//get a random node from the graph
	public Node getRandomNode(Ship s) {
		Node rNode = new Node();
		Random gen = new Random();
		int r = gen.nextInt(s.getNodes().size());
		Iterator<Node> iter = s.getNodes().iterator();
		for(int i = 0; i < r; i++) {
			rNode = iter.next();
		}
		return rNode;
	}
	//checks for winning conditions
	public int win() {
		Iterator<Edge> iter = pNode.getAdjacent().iterator();
		boolean closed = true;
		//checks if the predator has sealed himself in a node
		while(iter.hasNext()) {
			if (iter.next().isOpen()) {
				closed = false;
			}
		}
		//checks if the predator has sealed himself in the control room
		if(pNode.compareTo(cNode) == 0 && closed) {
			return 1;
		}
		//checks if the alien has found the predator
		else if(aNode.compareTo(pNode) == 0) {
			return 2;
		}
		//keep playing!
		else
			return 0;
	}
}
