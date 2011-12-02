package avp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ugraph.Edge;
import ugraph.Node;
import ugraph.Ship;

public class GUI extends JFrame implements Runnable {
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
	
   /*Random random = new Random();
   
   Rubik rubik;
   State state;
   GUI gui;
   */
   final JPanel canvas = new JPanel() {
      public void paint(Graphics g) {
         synchronized (image) {
            g.drawImage(image, 0, 0, this);
         }
      }
   };
   /*
   final int WINDOW_SIZE = 500;
   final int ORIGIN = WINDOW_SIZE/2;
   final Color menuColor = Color.LIGHT_GRAY;
   
   boolean fill = true;
   Image image;
   Image backgroundImage;
   Graphics2D buffer;
   TwoDPoint dragOrigin = null;
   JLabel msgline;*/

   GUI() {
      super("CS2110 Alien vs Predator!");
/*      this.rubik = rubik;
      this.state = state;
      gui = this;
  */
      }
   
   /*
    * This method initializes the gui.  We must
    * create the menu bar and menus, create the message area, initialize
    * the event handlers, and initialize the display.  Inform the animator
    * when we are done.
    */
   public void run() {
      /*
       * Initialize the display
       */
      
      // set main window parameters
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setResizable(false);
      setLocationRelativeTo(null); // center on screen
      //setLocation(getLocation().x - ORIGIN, getLocation().y - ORIGIN);
      // where we draw stuff
      //canvas.setPreferredSize(new Dimension(WINDOW_SIZE, WINDOW_SIZE));
      //add(canvas, BorderLayout.CENTER);

      
/*      msgline = new JLabel("");
      msgline.setPreferredSize(new Dimension(20, 20));
      add(msgline, BorderLayout.NORTH);
*/
      pack();
      setVisible(true);
      /*
      // off-screen buffer
      image = createImage(WINDOW_SIZE, WINDOW_SIZE);
      buffer = (Graphics2D)image.getGraphics();
      buffer.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      buffer.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
      buffer.translate(ORIGIN, ORIGIN);
      
      backgroundImage = createImage(WINDOW_SIZE, WINDOW_SIZE);
      Graphics bg = backgroundImage.getGraphics();
      boolean daytime = (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) + 6) % 24 >= 12;
      String fileName = daytime? "resources/images/clouds.jpg" : "resources/images/stars.jpg";
      try {
         backgroundImage = ImageIO.read(ClassLoader.getSystemResourceAsStream(fileName));
      } catch (IOException e1) {}
      bg.translate(ORIGIN, ORIGIN);
      
      // inform animator we are ready to roll      
      synchronized (rubik) {
         rubik.notify();
      }*/
   }
   
   
   /*
    * These methods are called from the animator to display the image
    */
   /*
   private TwoDPoint mousePosition(MouseEvent e) {
      return new TwoDPoint(e.getX() - ORIGIN, e.getY() - ORIGIN);
   }
   
   void render(Square s) {
      // check whether we have anything to render
      Polygon pBack = s.project(state, false);
      Polygon pFront = s.project(state, true);
      if (pBack.npoints <= 2 || pFront.npoints <= 2) return;      
      
      // light intensity is cosine of angle of obliqueness of light source on surface
      // set color gradients accordingly
      ThreeDPoint lightSource = state.rotating(s.cube)?
               state.rMatrix.mult(state.orientation.mult(State.BASE_LIGHT_SOURCE)) :
               state.orientation.mult(State.BASE_LIGHT_SOURCE);
               
      // get color from home position of cube
      Color color = s.cube.position.apply(s).color; 
      float intensity = fill? (float)((lightSource.cos(s.normal) + 1) / 2) : 1;
      float r = intensity * color.getRed() / 256;
      float g = intensity * color.getGreen() / 256;
      float b = intensity * color.getBlue() / 256;      
      if (fill) {
         buffer.setColor(Color.BLACK);
         buffer.fillPolygon(pBack);
         buffer.setColor(new Color(r, g, b));
         buffer.fillPolygon(pFront);        
      } else {
         buffer.setColor(new Color(r, g, b));
         buffer.drawPolygon(pBack);
      }
   }*/
   


   
   void display() {
	   Set<Node> ns = Ship.getNodes();
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
		   if (es.contains(new Edge((x+1)%WIDTH, y%HEIGHT)))
		       graphics.setColor(controlColor);
		   else
		       graphics.setColor(backColor);
     	   graphics.fillRect(x+OFFSET,y,V_CELL_SIZE,V_THICKNESS);
		   if (es.contains(new Edge((x-1)%WIDTH, y%HEIGHT)))
		       graphics.setColor(controlColor);
		   else
		       graphics.setColor(backColor);
     	   graphics.fillRect(x-OFFSET,y,V_CELL_SIZE,V_THICKNESS);
		   if (es.contains(new Edge(x%WIDTH, (y+1)%HEIGHT)))
			   graphics.setColor(controlColor);
		   else
		       graphics.setColor(backColor);
     	   graphics.fillRect(x,y+OFFSET,H_CELL_SIZE,H_THICKNESS);
		   if (es.contains(new Edge(x%WIDTH, (y-1)%HEIGHT)))
			   graphics.setColor(controlColor);
		   else
		       graphics.setColor(backColor);
     	   graphics.fillRect(x,y-OFFSET,H_CELL_SIZE,H_THICKNESS);
	}
   }
}
