import java.awt.*;

public class Box extends ShapeType {   
    
    public Box() {        
        System.out.println("Box Constructor.");
        shapeName = "Box";
    }
    
    public String getShapeName(){
        return shapeName;
    }
    
    public Point getStartPoint(){
        return startPoint;
    }
    
    public Point getEndPoint(){
        return endPoint;
    }
    
    public void setStartPoint(Point startPoint){
        this.startPoint = startPoint;
    }
    
    public void setEndPoint(Point endPoint){
        this.endPoint = endPoint;
    }    
}
