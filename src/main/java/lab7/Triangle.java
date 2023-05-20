/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab7;

import com.github.cliftonlabs.json_simple.JsonObject;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.math.BigDecimal;

/**
 *
 * @author Mariam Mohamed
 */
public class Triangle extends AbstractShape{
    
    private Point p1;
    private Point p2;
    private int dx1 , dy1 , dx2 ,dy2 ,dx3 ,dy3 ;
    private int currentCorner;                   // a3tkd mlhosh lzma hbwa ashelo hwa w set w get bto3o
//    private Rectangle smallRectangle[];
//    boolean isResizable;
    private Rectangle[] rio ;
//    private Point smallRePoint; 
//
//    public Rectangle[] getRio() {
//        return rio;
//    }
//    
   
    public Triangle(Point p1, Point p2,Point p3) {
        super(p3);
        this.p1 = p1;
        this.p2 = p2;
//        d=new dots[3];
        rio=new Rectangle[3];
//     smallRectangle=new Rectangle[3];
//     isResizable=false;
    }

//    public Point getSmallRePoint() {
//        return smallRePoint;
//    }
//
//    public void setSmallRePoint(Point smallRePoint) {
//        this.smallRePoint = smallRePoint;
//    }

    public void deletedots(Graphics canvas)
    {
        for(Rectangle r: rio)
            {
            r.setFillColor(Color.white);
            r.setColor(Color.WHITE);
            }
    }
    
    public Rectangle[] getRio() {
        return rio;
    }

    public int getCurrentCorner() {
        return currentCorner;
    }

    public void setCurrentCorner(int currentCorner) {
        this.currentCorner = currentCorner;
    }
    
    
    
    public void setDots ()
    {
     Point oo1 = new Point(getPosition().x-4, getPosition().y-4);
     Point oo2 = new Point(p1.x-4, p1.y-4);
     Point oo3 = new Point(p2.x-4, p2.y-4);

    Rectangle r1= new Rectangle(8, 8, oo1);
    Rectangle r2= new Rectangle(8, 8, oo2);
    Rectangle r3= new Rectangle(8, 8, oo3);
    
//    r1.setDraggingPoint(smallRePoint);
//    r3.setDraggingPoint(smallRePoint);
//    r3.setDraggingPoint(smallRePoint);
//   System.out.println(rio[0].getPosition().x);
//        System.out.println(getPosition().x);

    rio[0]=r1;
    rio[1]=r2;
    rio[2]=r3;
   

//    smallRectangle[1]=new Rectangle(14, 14, p2);
//    smallRectangle[2]=new Rectangle(14, 14, p1);
    
    }
        
 
    
    public void drawdots(Graphics canvas)
    {
     Point oo1 = new Point(getPosition().x-4, getPosition().y-4);
     Point oo2 = new Point(p1.x-4, p1.y-4);
     Point oo3 = new Point(p2.x-4, p2.y-4);     
    rio[0].setPosition(oo1);
    rio[1].setPosition(oo2);
    rio[2].setPosition(oo3);
     
     for(Rectangle r: rio)
     {
     r.draw(canvas);
     }
    }
     public void drawdotsWhileDragging(Graphics canvas,int k, Point currentCorPoint)
    {
        if(k==0)
        {
            setPosition(currentCorPoint);
        }
        else if(k==1)
                    {
                     p1=currentCorPoint;   
                    }
        else if(k==2)
                    {
                    p2=currentCorPoint;
                    
                    }
              
      rio[k].setPosition(currentCorPoint);
      System.out.println(k+"index in Triangle");
//        rio[k].draw(canvas);
//            for(Rectangle r: rio)
//            {
//            r.draw(canvas);
//            }
    }
//
//    public Rectangle[] getSmallRectangle() {
//        return smallRectangle;
//    }
//    
//    public void setSmallRectangles(Graphics canvas)
//    {
////        Point p = new Point(getPosition().x-7, getPosition().y-7);
////        Point p1 = new Point(p.x-7, getPosition().y-7);
////        Point p2 = new Point(getPosition().x-7, getPosition().y-7);
//
//    smallRectangle[0]=new Rectangle(14, 14, getPosition());
//    smallRectangle[1]=new Rectangle(14, 14, p2);
//    smallRectangle[2]=new Rectangle(14, 14, p1);
//    for(Rectangle r: smallRectangle)
//    {
//    r.draw(canvas);
//    }
//    }
//    
//    
//    public void resize (Point b)
//    {
//     for(Rectangle r: smallRectangle)
//    {
//      if(r.contains(b))
//      {
//      isResizable=true; 
//      r.getPosition().translate((b.x-r.getDraggingPoint().x), (b.y-getDraggingPoint().y));
//      }
//      
//    }
//    
//    }
//
//    public boolean isIsResizable() {
//        return isResizable;
//    }
//
//    public void setIsResizable(boolean isResizable) {
//        this.isResizable = isResizable;
//    }
//    
    
    
    
    
    public void setP1(Point position) {
        this.p1 = position;
    }
    public void setP2(Point position) {
        this.p2 = position;
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }
    
    
      
    @Override
    public void draw(Graphics canvas) {  
        
        int x[]={getPosition().x,p1.x,p2.x};
        int y[]={getPosition().y,p1.y,p2.y};

        canvas.setColor(getColor());
        canvas.drawPolygon(x,y,3);      
        canvas.setColor(getFillColor());
        canvas.fillPolygon(x, y, 3);
    }
        
    
    
    @Override
     public void setDraggingPoint(Point draggingPoint)
     {
     super.setDraggingPoint(draggingPoint);
     
     dx1=(draggingPoint.x)-(getPosition().x);
     dx2=(draggingPoint.x)-(p1.x);
     dx3=(draggingPoint.x)-(p2.x);
     
     dy1=(draggingPoint.y)-(getPosition().y);
     dy2=(draggingPoint.y)-(p1.y);
     dy3=(draggingPoint.y)-(p2.y);
    
    
     }
    
     
     static double area(int x1, int y1, int x2, int y2,
                                        int x3, int y3)
    {
       return Math.abs((x1*(y2-y3) + x2*(y3-y1)+
                                    x3*(y1-y2))/2.0);
    }
     
    @Override
    public boolean contains(Point b) {
    
        double A = area (getPosition().x,getPosition().y,p1.x,p1.y,p2.x,p2.y);
      
       /* Calculate area of triangle PBC */ 
        double A1 = area (b.x, b.y, getPosition().x,getPosition().y,p1.x, p1.y);
      
       /* Calculate area of triangle PAC */ 
        double A2 = area (b.x, b.y, getPosition().x,getPosition().y,p2.x, p2.y);
      
       /* Calculate area of triangle PAB */  
        double A3 = area (b.x, b.y, p1.x, p1.y, p2.x, p2.y);
        
       /* Check if sum of A1, A2 and A3 is same as A */
        return (A == A1 + A2 + A3);
        
        
    }
     
    @Override
    public void moveTo(Point b) {
 
        Point k =new Point((b.x-dx1),(b.y-dy1));       
        super.setPosition(k);

        Point k2 =new Point((b.x-dx2),(b.y-dy2));
        p1=k2;
        
        Point k3 =new Point((b.x-dx3),(b.y-dy3));
        p2=k3;
    }

    @Override
    public void setRio(Rectangle[] rio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
             public JsonObject tojsonObject(){
    
   JsonObject jo= new JsonObject();
        jo.put("Type", "Triangle");
        jo.put("Point1x", getPosition().x);
        jo.put("Point1y", getPosition().y);
        jo.put("Point2x", this.getP1().x);
        jo.put("Point2y", this.getP1().y);
        jo.put("Point3x", this.getP2().x);
        jo.put("Point3y", this.getP2().y);
//        jo.put("Point1", getPosition());
//        jo.put("Point2", point2 );
//        jo.put("Point3", point3);
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
    int Point1x=((BigDecimal) jo.get("Point1x")).intValue();
        int Point1y=((BigDecimal) jo.get("Point1y")).intValue();
        Point x = new Point(Point1x, Point1y);
        
        int Point2x=((BigDecimal) jo.get("Point2x")).intValue();
        int Point2y=((BigDecimal) jo.get("Point2y")).intValue();
        Point y=new Point(Point2x, Point2y);
        
        int Point3x=((BigDecimal) jo.get("Point3x")).intValue();
        int Point3y=((BigDecimal) jo.get("Point3y")).intValue();
        Point z=new Point(Point3x, Point3y);
        
        int redf=((BigDecimal) jo.get("redf")).intValue();
        int greenf=((BigDecimal) jo.get("greenf")).intValue();
        int bluef=((BigDecimal) jo.get("bluef")).intValue();
        Color fill=new Color(redf, greenf, bluef);
        
        int redb=((BigDecimal) jo.get("redb")).intValue();
        int greenb=((BigDecimal) jo.get("greenb")).intValue();
        int blueb=((BigDecimal) jo.get("blueb")).intValue(); 
        Color boarder =new Color(redb, greenb, blueb);
        
                
        
       

          
//       Point x=(Point) jo.get("Point2");
//       Point y=(Point) jo.get("Point3");
               
       setP1(y);
        setP2(z);
       setPosition(x);
       setColor(boarder);
       setFillColor(fill);
    }
       
    
    
}
