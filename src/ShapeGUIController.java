import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;


public class ShapeGUIController extends Frame implements WindowListener, ActionListener, MouseListener, MouseMotionListener {
    
    String frameTitle;
    String DrawMode;
    Box box = new Box();
    Circle circle = new Circle();
    Label lblModeDisplay;
    List<ShapeList> shapeList = new ArrayList<>();
    

    public ShapeGUIController() { 
          frameTitle = "";
          DrawMode = "";
    }
    
    public String getFrameTitle(){
        return frameTitle;
    }
    
    public void setFrameTitle (String frameTitle) {
        this.frameTitle = frameTitle;
    }
    
    public void createController() {
        
        setTitle(frameTitle);        
        setSize(700,600);
        setLocation(550, 200);
        addWindowListener(this);
        setVisible(true);     
        
        Panel CommandPanel = new Panel(new GridLayout(6,1, 20, 20));
        CommandPanel.setBackground(new Color(240,240,240));
        
        Button btnBox = new Button(box.getShapeName());
        Button btnCircle = new Button(circle.getShapeName());

        
        Label lblMode = new Label("Clicked Button: ");
        lblModeDisplay = new Label("");
        Font f1 = new Font("Verdana", Font.PLAIN, 20);
        lblMode.setFont(f1);
        lblModeDisplay.setFont(f1);
        lblModeDisplay.setForeground(Color.BLUE); 
        
        btnBox.setActionCommand(box.getShapeName());
        btnBox.addActionListener(this);
        
        btnCircle.setActionCommand(circle.getShapeName());
        btnCircle.addActionListener(this);
        
        CommandPanel.add(btnBox);
        CommandPanel.add(btnCircle);
        CommandPanel.add(lblMode);
        CommandPanel.add(lblModeDisplay);
        
        CommandPanel.setSize(300, 100);
        
        this.add(BorderLayout.WEST ,CommandPanel);
        
        addMouseListener(this);         
    }
    
    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {
        this.dispose();
    }

    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}

    @Override
    public void actionPerformed(ActionEvent e) {        
        DrawMode = e.getActionCommand();
        lblModeDisplay.setText(DrawMode);        
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {        
        Point currPoint = new Point(e.getX(), e.getY());    
        if (DrawMode.equals(box.getShapeName()))
            box.setStartPoint(currPoint);  
        else if (DrawMode.equals(circle.getShapeName()))
            circle.setStartPoint(currPoint);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Point currPoint = new Point(e.getX(), e.getY());        
        
        if (DrawMode.equals(box.getShapeName())) {
            box.setEndPoint(currPoint);
            Point startPoint = box.getStartPoint();
            Point endPoint = box.getEndPoint();            
            if (startPoint.equals(endPoint)) return;            
            Point topLeft = getTopLeft(startPoint, endPoint);
            int w = Math.abs(endPoint.x - startPoint.x);
            int h = Math.abs(endPoint.y - startPoint.y); 
            shapeList.add(new ShapeList(box.getShapeName(), topLeft.x, topLeft.y, w, h));            
        }
        else if (DrawMode.equals(circle.getShapeName())) {
            circle.setEndPoint(currPoint);
            Point startPoint = circle.getStartPoint();
            Point endPoint = circle.getEndPoint();
            if (startPoint.equals(endPoint)) return;       
            shapeList.add(new ShapeList(circle.getShapeName(), startPoint.x, startPoint.y, endPoint.x, endPoint.y));
        }
        
        System.out.println(shapeList);
        repaint();
    }
    
    private Point getTopLeft(Point startPoint, Point endPoint) {
        Point topLeft = new Point();
        topLeft.x = Math.min(startPoint.x, endPoint.x);
        topLeft.y = Math.min(startPoint.y, endPoint.y);
        return topLeft;
    }
    
    public void paint (Graphics g) {
        
        for (ShapeList shape: shapeList){
            if(shape.getShapeName().equals("Box"))
                g.drawRect(shape.getx1(), shape.gety1(), shape.gety1(), shape.gety2());
            else if(shape.getShapeName().equals("Circle")) {
                Graphics2D ga = (Graphics2D)g;
                double d = Math.sqrt(Math.pow((shape.getx1()-shape.getx2()),2) + (Math.pow((shape.gety1()-shape.gety2()),2)));
                ga.drawOval(shape.getx1(), shape.gety1(),(int)d,(int)d);
            }               
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {}    
}


class ShapeList {
    String shapeName;
    int x1;
    int y1;
    int x2;
    int y2;

    public ShapeList(String shapeName, int x1, int y1, int x2, int y2) {
        this.shapeName = shapeName;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;   
    }
    
    public String getShapeName(){
        return shapeName;
    }
    
    public int getx1(){
        return x1;
    }
    
    public int gety1(){
        return y1;
    }
    
    public int getx2(){
        return x2;
    }
    
    public int gety2(){
        return y2;
    }
} 
