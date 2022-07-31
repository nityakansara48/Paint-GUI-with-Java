public class ShapeGUI {
    public static void main(String[] args) {        
        try {        
            ShapeGUIController GUIController = new ShapeGUIController();
            GUIController.setFrameTitle("SDP - HW 1 - GUI");
            GUIController.createController();
        }
        
        catch (Exception e) {
            System.out.println(e.getMessage());
        }       
    }    
}
