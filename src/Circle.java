import java.awt.*;

public class Circle extends ShapeType{
    public Circle(){
        System.out.println("Circle Constructor.");
        shapeName = "Circle";
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