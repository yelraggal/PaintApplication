package lab7;

import com.github.cliftonlabs.json_simple.JsonObject;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.math.BigDecimal;


public class Circle extends AbstractShape{

    private int horizontalRadius,verticalRadius,xdiff,ydiff;
    private Rectangle[] rio ;
    private int xdiffrio1,ydiffrio2;
    private  Point   point2 , point3 , point4; 
int length;
    int width;
    
    public Circle(Point point,int horizontalRaduis, int verticalRadius ) {
        
        super(point);
//        this.horizontalRadius= horizontalRaduis;
//        this.verticalRadius=verticalRadius;
        rio=new Rectangle[4];
        this.length=verticalRadius*2;
        this.width=horizontalRaduis*2;
//        this.point2 = new Point(getPosition().x+this.width , getPosition().y);
//         this.point4 = new Point (getPosition().x,getPosition().y+this.length);
//          this.point3 = new Point (getPosition().x+this.width,getPosition().y+this.length);
//       
//this.point2.x=point.x+horizontalRadius*2;
//this.point2.y=point.y;
//
//this.point3.x=point.x+horizontalRadius*2;
//this.point3.y=point.y+verticalRadius*2;
//        
//this.point4.x=point.x;
//this.point4.y=point.y+verticalRadius*2;
    }  
    
     public Rectangle[] getRio() {
        return rio;
    }

    public void setRio(Rectangle[] rio) {
        this.rio = rio;
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
    public void deletedots(Graphics canvas)
    {
        for(Rectangle r: rio)
            {
            r.setFillColor(Color.white);
            r.setColor(Color.white);
            }
    }
    
    public void setDots ()
    {
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
   
    public void drawdots(Graphics canvas)
    {
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
    
    
    
    
    
    

    public int getHorizontalRadius() {
        return horizontalRadius;
    }

    public int getVerticalRadius() {
        return verticalRadius;
    }
    
   

    public void setHorizontalRadius(int horizontalRadius) {
        this.horizontalRadius = horizontalRadius;
    }

    public void setVerticalRadius(int verticalRadius) {
        this.verticalRadius = verticalRadius;
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
       
         this.point2 = new Point(getPosition().x+this.width , getPosition().y);
         this.point4 = new Point (getPosition().x,getPosition().y+this.length);
          this.point3 = new Point (getPosition().x+this.width,getPosition().y+this.length);
       
           
 Point arrayPoint[]={getPosition(),point2,point3,point4};
     Point min=getPosition();
     for(Point p : arrayPoint)
     {
         if(min.x>p.x)
         {
             min=p;
         }
         if(min.y>p.y)
         {
          min=p;
         }
     }
     Point newWidth = new Point();
     for (Point p: arrayPoint)
     {
         if(min.y==p.y&&min.x!=p.x)
         {
             newWidth=p;
         }
     }
         Point newHeight = new Point();
     for (Point p: arrayPoint)
     {
         if(min.x==p.x&&min.y!=p.y)
         {
             newHeight=p;
         }
     } 
    // this.setPosition(min);
    canvas.setColor(getFillColor());
 canvas.fillOval(min.x,min.y,newWidth.x-min.x,newHeight.y-min.y);
       canvas.setColor(getColor());
 canvas.drawOval(min.x,min.y,newWidth.x-min.x,newHeight.y-min.y);
       
       }
      
    
    @Override
     public void setDraggingPoint(Point draggingPoint) {
         
         super.setDraggingPoint(draggingPoint); // hhseb l relative diffrence lkol no2ta mohma fel shape
                                                // lma agi arsm l shkl tany hrsm blnsba l dragging point
         xdiff=(draggingPoint.x)-(getPosition().x);
         ydiff=(draggingPoint.y)-(getPosition().y);
         
     }
    
    
    @Override
    public boolean contains(Point b) {
  
//         Polygon p = new Polygon(new int[]{getPosition().x,getPoint2().x,getPoint3().x,getPoint4().x},new int[] {getPosition().y,getPoint2().y,getPoint3().y,getPoint4().y}, 4);
//     return p.contains(b);
        
          double p = ((double)Math.pow((b.x - (getPosition().x+width/2)), 2)
            / (double)Math.pow(width/2, 2))
           + ((double)Math.pow((b.y -(getPosition().y+length/2) ), 2)
              / (double)Math.pow(length/2, 2));
              if(p<=1)
              {
                  return true;
              }                      
              return false;
    
    }
    
    
    @Override
    public void moveTo(Point b) {
 
        Point k =new Point((b.x-xdiff),(b.y-ydiff));
        System.out.println(horizontalRadius);
        System.out.println(verticalRadius);
        setPosition(k);
    

    }
    
    
    @Override
    public JsonObject tojsonObject() {
        JsonObject jo=new JsonObject();
        jo.put("Type", "Oval");
        jo.put("Centerx", getPosition().x);
        jo.put("Centery", getPosition().y);
        jo.put("vradius", length);
        jo.put("hradius", width);
        
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
        
        int x=((BigDecimal) jo.get("Centerx")).intValue();
        int y=((BigDecimal) jo.get("Centery")).intValue();
        Point center=new Point(x,y);
        int vr=((BigDecimal) jo.get("vradius")).intValue();
        int hr=((BigDecimal) jo.get("hradius")).intValue();
        
        int redf=((BigDecimal) jo.get("redf")).intValue();
        int greenf=((BigDecimal) jo.get("greenf")).intValue();
        int bluef=((BigDecimal) jo.get("bluef")).intValue();
        Color fill=new Color(redf, greenf, bluef);
        
        int redb=((BigDecimal) jo.get("redb")).intValue();
        int greenb=((BigDecimal) jo.get("greenb")).intValue();
        int blueb=((BigDecimal) jo.get("blueb")).intValue(); 
        Color boarder =new Color(redb, greenb, blueb);
        
        setPosition(center);
        length=vr;
        width=hr;
        
        setColor(boarder);
        setFillColor(fill);
    }
    


}
