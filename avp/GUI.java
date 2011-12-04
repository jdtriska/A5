package avp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class GUI extends JFrame {
	int H_CELL_SIZE = 27;
	int V_THICKNESS = 27;
	int H_THICKNESS = 4;
	int V_CELL_SIZE = 4;
	int OFFSET = 10;
	Color alienColor = new Color(250, 0, 0);
	Color predatorColor = new Color(0, 250, 0);
	Color controlColor = new Color(0, 0, 0);
	Color scannerColor = new Color(250, 250, 250);
	Color backColor = new Color(0, 0, 250);

	Ship myShip;
	   
	GUI(Ship s) {
	   super("CS2110 Alien vs Predator!");
	   myShip = s;
	}


   final JPanel canvas = new JPanel() {
      public void paint(Graphics graphics) {
   	   Set<Node> ns = myShip.getNodes();
   	   for(Node n : ns) {
   		   int v = n.getValue();
   		   int x = n.getX();
   		   int y = n.getY();
   		   if(v == -1)
   		         graphics.setColor(alienColor);
              else if(v == 1)
   		         graphics.setColor(predatorColor);
              else if(v == -2)
   		         graphics.setColor(scannerColor);
   		   else if(v == 2)
   		         graphics.setColor(controlColor);
   		   else
   		         graphics.setColor(backColor);
   		   graphics.fillRect(x-5,y-5,10,10);
   		   Set<Edge> es = n.getAdjacent();
   		   if (es.contains(new Edge(n, new Node((x+1)%WIDTH, y%HEIGHT))))
   		       graphics.setColor(controlColor);
   		   else
   		       graphics.setColor(backColor);
           graphics.fillRect(x+OFFSET,y,V_CELL_SIZE,V_THICKNESS);
   		   if (es.contains(new Edge(n, new Node((x-1)%WIDTH, y%HEIGHT))))
   		       graphics.setColor(controlColor);
   		   else
   		       graphics.setColor(backColor);
           graphics.fillRect(x-OFFSET,y,V_CELL_SIZE,V_THICKNESS);
   		   if (es.contains(new Edge(n, new Node(x%WIDTH, (y+1)%HEIGHT))))
   			   graphics.setColor(controlColor);
   		   else
   		       graphics.setColor(backColor);
      	   graphics.fillRect(x,y+OFFSET,H_CELL_SIZE,H_THICKNESS);
   		   if (es.contains(new Edge(n, new Node(x%WIDTH, (y-1)%HEIGHT))))
   			   graphics.setColor(controlColor);
   		   else
   		       graphics.setColor(backColor);
       	   graphics.fillRect(x,y-OFFSET,H_CELL_SIZE,H_THICKNESS);
   			}
   	   }
   };
}
