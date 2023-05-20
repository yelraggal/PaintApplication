package lab7;

import com.github.cliftonlabs.json_simple.JsonObject;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.math.BigDecimal;
import java.util.Map;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author zedan.net
 */
public class Rectangle extends AbstractShape {
private int length , width ;
   private Rectangle[] rio ;
      private int currentCorner; 
    private  Point   point2 , point3 , point4; 

    public Rectangle(Point point2, Point point3, Point point4, Point position) {
        super(position);
        this.point2 = point2;
        this.point3 = point3;
        this.point4 = point4;
    }
    
    
      
@Override
      public Rectangle[] getRio() {
        return rio;
    }

    public int getCurrentCorner() {
        return currentCorner;
    }

    public void setCurrentCorner(int currentCorner) {
        this.currentCorner = currentCorner;
    }

    public Rectangle(int length, int width, Point position) {
        super(position);
        this.length = length;
        this.width = width;
         rio = new Rectangle[4];
       
      }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    public Point getPoint3() {
        return point3;
    }

    public void setPoint3(Point point3) {
        this.point3 = point3;
    }

    public Point getPoint4() {
        return point4;
    }

    public void setPoint4(Point point4) {
        this.point4 = point4;
    }

 

    
    
    @Override
    public String toString() {
        return "Rectangle"; 
    }
  
    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }


    @Override
    public void draw(Graphics canvas) {
//        canvas.setColor(getColor());
//        canvas.drawRect(getPosition().x, getPosition().y, width, length);
//        canvas.setColor(getFillColor());
//        canvas.fillRect(getPosition().x, getPosition().y, width, length);
         this.point2 = new Point(getPosition().x+this.width , getPosition().y);
         this.point4 = new Point (getPosition().x,getPosition().y+this.length);
          this.point3 = new Point (getPosition().x+this.width,getPosition().y+this.length);
       
       canvas.setColor(getColor());
       canvas.drawPolygon(new int[]{getPosition().x,getPoint2().x,getPoint3().x,getPoint4().x},new int[] {getPosition().y,getPoint2().y,getPoint3().y,getPoint4().y}, 4);
       canvas.setColor(getFillColor());
       canvas.fillPolygon(new int[]{getPosition().x,getPoint2().x,getPoint3().x,getPoint4().x},new int[] {getPosition().y,getPoint2().y,getPoint3().y,getPoint4().y}, 4);
       
     //   canvas.setColor(getColor());
//        canvas.fillOval(getPosition().x-radius, getPosition().y-radius, (int) (2*radius), (int) (2*radius));
        //canvas.fillOval(getPosition().x,getPosition().y, getPoint3().x-getPosition().x,getPoint3().y-getPosition().y);
//canvas.fillOval(getPosition().x,getPosition().y, this.width,this.length);
       
       
      }
        
   

@Override
 public boolean contains(Point b)
 {
     
     Polygon p = new Polygon(new int[]{getPosition().x,getPoint2().x,getPoint3().x,getPoint4().x},new int[] {getPosition().y,getPoint2().y,getPoint3().y,getPoint4().y}, 4);
     return p.contains(b);
   
    
 }

    @Override
    public void moveTo(Point nextpoint) {
       Point p = getPosition();
      p.translate((int)(nextpoint.x - getDraggingPoint().x ),
              (int)(nextpoint.y - getDraggingPoint().y)  );
      
    }

    @Override
    public void drawdots(Graphics canvas) {
        Point oo1 = new Point(getPosition().x-4, getPosition().y-4);
    Point oo2 = new Point(getPosition().x-4, getPosition().y+length-4); // left corner (ltht)
    Point oo3 = new Point(getPosition().x-4+width, getPosition().y-4);// Top Right corner
    Point oo4 = new Point(getPosition().x+width-4,getPosition().y+length-4);// right corner
     

    rio[0].setPosition(oo1);
    rio[1].setPosition(oo2);
    rio[2].setPosition(oo3);
    rio[3].setPosition(oo4);

     for(Rectangle r: rio)
     {
     r.draw(canvas);
     } 
    }

    @Override
    public void setDots() {
        
        
      Point oo1 = new Point(getPosition().x-4, getPosition().y-4);
    Point oo2 = new Point(getPosition().x-4, getPosition().y-4+length); // left corner (ltht)
    Point oo3 = new Point(getPosition().x-4+width, getPosition().y-4);// Top Right corner
    Point oo4 = new Point(getPosition().x+width-4,getPosition().y+length-4);// right corner


    Rectangle r1= new Rectangle(8, 8, oo1);
    Rectangle r2= new Rectangle(8, 8, oo2);
    Rectangle r3= new Rectangle(8, 8, oo3);
    Rectangle r4= new Rectangle(8, 8, oo4);
    
    rio[0]=r1;
    rio[1]=r2;
    rio[2]=r3;
    rio[3]=r4;

    }

    @Override
    public void drawdotsWhileDragging(Graphics canvas, int k, Point currentCorPoint) {
 
         if(k==0)
        {
            
            System.out.println("Ana gowa point0 dlw2tyyy");
            //setPosition(currentCorPoint);
            if(currentCorPoint.x != getPosition().x)
            {
                System.out.println("COndition 1  nowww");
                int xshift = currentCorPoint.x-getPosition().x;
               
                width = width -xshift ;
                Point p1 = new Point (getPosition().x+xshift,getPoint4().y);
                rio[1].setPosition(p1);}
            
            if(currentCorPoint.y != getPosition().y)
            {
                System.out.println("COndition 2");
                 int yshift =currentCorPoint.y-getPosition().y;
                
                    
                length = length - yshift ;
                 Point p2 = new Point (getPoint2().x,getPosition().y+yshift);
                rio[2].setPosition(p2);
            }
            
            setPosition(currentCorPoint);
            
            
            
        }
        else if(k==1)
                    {
                     
                        
               System.out.println("Ana gowa point4 dlw2tyyy");
          
            if(currentCorPoint.x != getPoint4().x)
            {
                System.out.println("COndition 1  nowww");
                int xshift = currentCorPoint.x-getPoint4().x;
                
                width = width - xshift ;
                Point p3 = new Point (getPosition().x+xshift,getPosition().y);
                rio[0].setPosition(p3);
               
                setPosition(p3);
            }
            
          if(currentCorPoint.y != getPoint4().y)
            {
                System.out.println("COndition 2");
                 int yshift =currentCorPoint.y-getPoint4().y;
             
                length = length + yshift ;
                 Point p4 = new Point (getPoint3().x,getPoint3().y+yshift);
                rio[3].setPosition(p4);
                
                    setPoint3(p4);
            }
            
                  setPoint4(currentCorPoint) ;
          
                     }
        else if(k==2)
                    {
                    
              System.out.println("Ana gowa point2 dlw2tyyy");
          
            if(currentCorPoint.x != getPoint2().x)
            {
                System.out.println("COndition 1  nowww");
                int xshift = currentCorPoint.x-getPoint2().x;
               
                width = width + xshift ;
                Point p5 = new Point (getPoint2().x+xshift,getPoint3().y);
                rio[3].setPosition(p5);
                 setPoint3(p5);
            }
            
            if(currentCorPoint.y != getPoint2().y)
            {
                System.out.println("COndition 2");
                 int yshift =currentCorPoint.y-getPoint2().y;
                
                    
                length = length - yshift ;
                 Point p6 = new Point (getPosition().x,getPoint2().y+yshift);
                rio[0].setPosition(p6);
                setPosition(p6);
            }
            
                        setPoint2(currentCorPoint);
              }
        else if(k==3)
            
        {
            
            
                 
              System.out.println("Ana gowa point3 dlw2tyyy");
          
            if(currentCorPoint.x != getPoint3().x)
            {
                System.out.println("COndition 1  nowww");
                int xshift = currentCorPoint.x-getPoint3().x;
               
                width = width + xshift ;
                Point p7 = new Point (getPoint3().x+xshift,getPoint2().y);
                rio[3].setPosition(p7);
                 setPoint2(p7);
            }
            
            if(currentCorPoint.y != getPoint3().y)
            {
                System.out.println("COndition 2");
                 int yshift =currentCorPoint.y-getPoint3().y;
                
                    
                length = length + yshift ;
                 Point p8 = new Point (getPoint4().x,getPoint3().y+yshift);
                rio[1].setPosition(p8);
                setPoint4(p8);
            }
            
            setPoint3(currentCorPoint);
              }  
            
            
     
        
        rio[k].setPosition(currentCorPoint);
        //System.out.println(k+"index in Triangle");
    /* for(Rectangle r: rio)
     {
     r.draw(canvas);
     }*/
    }
    
    
    
    
    
    

    public void deletedots(Graphics canvas)
    {
        for(Rectangle r: rio)
            {
            r.setFillColor(Color.white);
            r.setColor(Color.WHITE);
            }
    }
    
    
      
       public JsonObject tojsonObject(){
    
 JsonObject jo=new JsonObject();
        jo.put("Type", "Rectangle");
        jo.put("Pointx",getPosition().x) ;
        jo.put("Pointy",getPosition().y) ;
        jo.put("Length", length);
        jo.put("Width", width);
        
        jo.put("redb", getColor().getRed());
        jo.put("greenb", getColor().getGreen());
        jo.put("blueb",getColor().getBlue());

        jo.put("redf", getFillColor().getRed());
        jo.put("greenf", getFillColor().getGreen());
        jo.put("bluef", getFillColor().getBlue());

        return jo;
   
    }  

    @Override
    public void fromjsonObject(JsonObject jo) {
       int Pointx=((BigDecimal) jo.get("Pointx")).intValue();
        int Pointy=((BigDecimal) jo.get("Pointy")).intValue();
        Point point=new Point(Pointx, Pointy);
        int l=((BigDecimal) jo.get("Length")).intValue();
        int w=((BigDecimal) jo.get("Width")).intValue();
        
        int redf=((BigDecimal) jo.get("redf")).intValue();
        int greenf=((BigDecimal) jo.get("greenf")).intValue();
        int bluef=((BigDecimal) jo.get("bluef")).intValue();
        Color fill=new Color(redf, greenf, bluef);
        
        int redb=((BigDecimal) jo.get("redb")).intValue();
        int greenb=((BigDecimal) jo.get("greenb")).intValue();
        int blueb=((BigDecimal) jo.get("blueb")).intValue(); 
        Color boarder =new Color(redb, greenb, blueb);
        
        setPosition(point);
        length=l;
        width=w;
        setColor(boarder);
        setFillColor(fill);
    }

    @Override
    public void setRio(Rectangle[] rio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
    
    
    
    
}
