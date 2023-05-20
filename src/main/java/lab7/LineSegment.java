package lab7;
import com.github.cliftonlabs.json_simple.JsonObject;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.math.BigDecimal;


public class LineSegment extends AbstractShape{

    private  Point b2;
    private int dx1,dy1,dx2,dy2;
    private Rectangle[]rio;
    public LineSegment(Point point,Point b2) {
    
        super(point);
        this.b2= b2;
        rio=new Rectangle[2];
    }

    public Rectangle[] getRio() {
        return rio;
    }

    public void setRio(Rectangle[] rio) {
        this.rio = rio;
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
     Point oo2 = new Point(b2.x-4, b2.y-4);
    Rectangle r1= new Rectangle(8, 8, oo1);
    Rectangle r2= new Rectangle(8, 8, oo2);
    rio[0]=r1;
    rio[1]=r2;
    }   
    
    public void drawdots(Graphics canvas)
    {
     Point oo1 = new Point(getPosition().x-4, getPosition().y-4);
     Point oo2 = new Point(b2.x-4, b2.y-4);
     rio[0].setPosition(oo1);
     rio[1].setPosition(oo2);
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
         b2=currentCorPoint;   
       }
           
        rio[k].setPosition(currentCorPoint);
        System.out.println(k+"index in LINE");
//     for(Rectangle r: rio)
//     {
//     r.draw(canvas);
//     }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    public void setSecondPoint(Point b2) {
        this.b2 = b2;
    }
    
    

    @Override
    public void draw(Graphics canvas) {

//        canvas.setColor(color);
//        canvas.drawRect(point.x, point.y, length, 1);
        canvas.setColor(getFillColor());
        canvas.drawLine(getPosition().x, getPosition().y, b2.x, b2.y);
       // canvas.fillRect(getPoint().x, getPoint().y, length ,1);
      
    }

    
    public Point getSecondPoint() {
        return b2;
    }

      @Override
     public void setDraggingPoint(Point draggingPoint) {
         
         super.setDraggingPoint(draggingPoint); 
         
            
     dx1=(draggingPoint.x)-(getPosition().x);
     dy1=(draggingPoint.y)-(getPosition().y);

     dx2=(draggingPoint.x)-(b2.x);
     dy2=(draggingPoint.y)-(b2.y);
         
     }
    
    
    
    @Override
    public boolean contains(Point b) {
        
//        double slope1 =(b.y-getPosition().y)/(b.x-getPosition().x);
//        double slope2=(b.y-b2.y)/(b.x-b2.x);
////        System.out.println(slope1);
////                System.out.println(slope1);
//
//        return slope1==slope2&&slope1!=0&&slope2!=0;
//try{
//        double slope1 =(b.y-getPosition().y)/(b.x-getPosition().x);
//        double slope2=(b.y-b2.y)/(b.x-b2.x);
//       
//         return slope1==slope2&&slope1!=0&&slope2!=0;
//}
//       catch (ArithmeticException e)
//       {
//          return true;
//       }
double x1=Math.pow(Math.abs(b.x-this.getPosition().x), 2);
        double y1=Math.pow(Math.abs(b.y-this.getPosition().y), 2);
        double min1=Math.sqrt(x1+y1);
        
        
        double x2=Math.pow(Math.abs(b.x-this.getSecondPoint().x), 2);
        double y2=Math.pow(Math.abs(b.y-this.getSecondPoint().y), 2);
        double min2=Math.sqrt(x2+y2);
        double fin =min1+min2;
        
        
        double x3=Math.pow(Math.abs(this.getPosition().x-this.getSecondPoint().x), 2);
        double y3=Math.pow(Math.abs(this.getPosition().y-this.getSecondPoint().y), 2);
        double min3=Math.sqrt(x3+y3);
        System.out.println(fin+" here"+min3);

        return (int)fin==(int)min3;
   

    }

    @Override
    public void moveTo(Point b) {
        
        Point k =new Point((b.x-dx1),(b.y-dy1));       
        super.setPosition(k);

        Point k2 =new Point((b.x-dx2),(b.y-dy2));
        b2=k2;

    }
     public JsonObject toJsonObject(){
    
     JsonObject jo = new JsonObject();
     jo.put("id ", 1);
     jo.put("postionx ", this.getPosition().x);
     jo.put("postiony ", this.getPosition().y);
     jo.put("secondpointx", this.getSecondPoint().x);
     jo.put("secondpointy", this.getSecondPoint().y);
     jo.put("fillcolor ", String.valueOf(this.getFillColor()));
     jo.put("color", String.valueOf(this.getColor()));
     
  
    return jo;
   
    }
    
     
    @Override
       public JsonObject tojsonObject() {
        JsonObject jo=new JsonObject();
        jo.put("Type", "Line");
        jo.put("Point1x", getPosition().x);
        jo.put("Point1y", getPosition().y);
        jo.put("Point2x", getSecondPoint().x);
        jo.put("Point2y", getSecondPoint().y);
        
        jo.put("redb", getColor().getRed());
        jo.put("greenb", getColor().getGreen());
        jo.put("blueb",getColor().getBlue());
        
        
        
        
        
        
        return jo;
    }
    @Override
    public void  fromjsonObject(JsonObject jo) {
        int Point1x=((BigDecimal) jo.get("Point1x")).intValue();
        int Point1y=((BigDecimal) jo.get("Point1y")).intValue();
        Point pos1 = new Point(Point1x, Point1y);
        
        int Point2x=((BigDecimal) jo.get("Point2x")).intValue();
        int Point2y=((BigDecimal) jo.get("Point2y")).intValue();
        Point pos2 = new Point(Point2x, Point2y);
        
        int redb=((BigDecimal) jo.get("redb")).intValue();
        int greenb=((BigDecimal) jo.get("greenb")).intValue();
        int blueb=((BigDecimal) jo.get("blueb")).intValue(); 
        Color boarder =new Color(redb, greenb, blueb);
        
        setPosition(pos1);
        setSecondPoint(pos2);
        
        setColor(boarder);
        
        
        
        
        
    }
    
    
    
    
    
    
    
}
