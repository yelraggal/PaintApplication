
package lab7;
import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.Jsoner;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class MyPanel extends JPanel implements DrawingEngine {

    private ArrayList<Shape> shapes;
    private Shape selectedShape;
    private javax.swing.JComboBox<String> combBox;
    private boolean mouseReleased;
    private int caseCorner=-1;
    private ArrayList<Rectangle> smallrectdots ;
    private int currentCorner;
    private boolean canDrag;
//    private boolean comeFromDragingsoLeaveCorners;
    public MyPanel(javax.swing.JComboBox<String> combBox) 
    {
//                combBox.addItem("helo co");
        this.combBox=combBox;
        shapes = new ArrayList<>();
        
        ClickListner clickListner=new ClickListner();
        this.addMouseListener(clickListner);
        
        DragListner dragListner=new DragListner();
        this.addMouseMotionListener(dragListner);     
        mouseReleased=false;
        selectedShape=null;
//        smallrectdots=new ArrayList<>();
        
    }
    

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Shape s : shapes) {
            s.draw(g);
        }
 
        
    }

    @Override
    public void addShape(Shape shape) {
        
        shapes.add(shape);

    }
    public ArrayList<Shape> getter()
 {
     return  shapes ;
 }
    

    @Override
    public void removeShape(Shape shape) {
        shapes.remove(shape);
    }

    @Override
    public Shape[] getShapes() {
        return shapes.toArray(Shape[]::new);
    }

    

    @Override
    public void refresh(Graphics canvas) {
        this.repaint();
    }
    
    
     public void save(Path path) 
    {
        try {
            JsonArray ja = new JsonArray();
            for (Shape s : shapes) {
                ja.add(s.tojsonObject());
            }
            String jsonText = Jsoner.serialize(ja);
            Files.write(path, jsonText.getBytes(), StandardOpenOption.CREATE);
        } catch (IOException ex) {
            Logger.getLogger(MyPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

    
    private class ClickListner extends MouseAdapter // inner classe
    {        
        @Override
        public void mousePressed (MouseEvent evt)// work on previous point
        {            

            int i=0;
            int caseOF=0;
            if(selectedShape!=null)
           {                    
               if(checkIfSelected(evt.getPoint())) // htrg3 true lw ana msh3amel select 3la haga
               {
                  System.out.println("shel dots");
                  mouseReleased=true;
                  canDrag=false;//l2n mfesh Shape selected
                  ((Resize)selectedShape).deletedots(getGraphics()); // b8yr lonha l abyd
                  ((Resize)selectedShape).drawdots(getGraphics());
                  caseOF=1; // mshlazm str da kda kda el 2 for loop l tht msh hyd5ol 
                  
                   selectedShape=null;
                   repaint();     
               }    
               
               if (caseOF==0) // kda ana m5trtsh  hga fdya ana m5tar shape
               {
                Rectangle t[]=((Resize)selectedShape).getRio();
               
                
                   for(Shape s: shapes)
                  {
                        if (((Moveable)s).contains(evt.getPoint()))
                        {
                            if(selectedShape!=s)
                            {
                            ((Resize)selectedShape).deletedots(getGraphics()); // b8yr lonha l abyd
                            ((Resize)selectedShape).drawdots(getGraphics()); // 3lshan lw hselect shape tany ams7 
                                                                             // dots mn shape adeem
                            repaint();     
                            System.out.println("shape");
                            ((Resize)s).setDots();
                            ((Resize)s).drawdots(getGraphics());
                            ((Moveable)s).setDraggingPoint(evt.getPoint());     
                            combBox.setSelectedIndex(i);
                            selectedShape=s;
                            ((Resize)selectedShape).setDots(); 
                            ((Resize)selectedShape).deletedots(getGraphics()); 
                            ((Resize)selectedShape).drawdots(getGraphics());
                            caseOF=1;
                            canDrag=true;
                            mouseReleased=false;
                             }
                            else
                            {
                             ((Moveable)s).setDraggingPoint(evt.getPoint());   // 3mlt select l nfs Shape 
                             // fh3mlo set b draging point l gdeda
                            ((Resize)selectedShape).setDots(); 
                            ((Resize)selectedShape).drawdots(getGraphics());   
                            combBox.setSelectedIndex(i);
                            }

                        }
                        i++; // counter for combox
        
                        
                  }
                             
                if(caseOF==0)
                {
                for (int j =0;j<t.length;j++)
                 {
                     if(t[j].contains(evt.getPoint()))
                      {
                        caseOF=1;   
                        System.out.println("corner");
                        System.out.println(j);
                        
                        t[j].setDraggingPoint(evt.getPoint());
     //                 ((Triangle)selectedShape).setCurrentCorner(j);     
//                      t[j].setDraggingPoint(evt.getPoint());
     //                 System.out.println(t[j].getDraggingPoint());
                        currentCorner=j;
                        caseCorner=1;
                        mouseReleased=false;
                        canDrag=true;
                      }
                 }  }
                }

             
                 
              // select no shape
              
//              if(caseOF==0)
//              {
//                  System.out.println("shel dots");
//                  mouseReleased=true;
//                  ((Resize)selectedShape).deletedots(getGraphics());
//                  ((Resize)selectedShape).drawdots(getGraphics());
//                   repaint();
//              }
//               
            }
            else
              {
                for (Shape s:shapes)
                {   
                    if (((Moveable)s).contains(evt.getPoint()))
                   {  
                       System.out.println("mkontsh 3amel select l wla shape w 3mlt");
                       selectedShape=s;
                       ((Resize)selectedShape).setDots();
                       ((Resize)selectedShape).drawdots(getGraphics());

                        ((Moveable)s).setDraggingPoint(evt.getPoint());     
                        combBox.setSelectedIndex(i);
                        mouseReleased=false;
                        canDrag=true;
                    }
                         i++;
                    
            
                }
              }
        }

      private boolean checkIfSelected(Point mousePoint)
      {
      Rectangle t[]=((Resize)selectedShape).getRio();
       for(Rectangle rectangle:t)
       {
           if(rectangle.contains(mousePoint))
               return false;
       }
       for (Shape s: shapes)
       {
           if(((Moveable)s).contains(mousePoint))
           {
               return false;
           }
       }
       return true; // kda ana selected wla hga
      }
        
        
        
        
        
        
        
       @Override
       public void mouseReleased ( MouseEvent evt)
       {
           
//           if(comeFromDragingsoLeaveCorners)
//           {
//             System.out.println("comefromdragging");
//             ((Resize)selectedShape).drawdots(getGraphics());
//              caseCorner=0; //3lshan lw gy mn corner
//           }
           
          
            if(mouseReleased==true)
            {
            System.out.println("shape b2a b null");
            caseCorner=0;
            selectedShape=null;
            }
                  
            
            
            
            
       }
       
    }
     private class DragListner extends MouseMotionAdapter // inner classe
    {
        
         @Override
         public void mouseDragged(MouseEvent evt)
         {
        if(selectedShape!=null)
             {
                 System.out.println(caseCorner);
                 if (caseCorner==1)
                 {
                      Rectangle t[]=((Resize)selectedShape).getRio();

                      ((Resize)selectedShape).drawdotsWhileDragging(getGraphics(),currentCorner,evt.getPoint());  
                      repaint();
                      mouseReleased=true;
                 }
               else
                 {
             ((Moveable)selectedShape).moveTo(evt.getPoint());  
              ((Moveable) selectedShape).setDraggingPoint(evt.getPoint());
             repaint();
             mouseReleased=true;
                 }
             
             }
         }
          
    }
}