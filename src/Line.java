import java.awt.*;

public class Line extends ShapeType {
    
    public Line(){
        System.out.println("Line Constructor.");
        shapeName = "Line";
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
