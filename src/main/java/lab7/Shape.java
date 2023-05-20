package lab7;

import com.github.cliftonlabs.json_simple.JsonObject;


public interface Shape   {
public void setPosition(java.awt.Point position);
public java.awt.Point getPosition();
public void setColor(java.awt.Color color);
public java.awt.Color getColor();
public void setFillColor(java.awt.Color color);
public java.awt.Color getFillColor();
public void draw(java.awt.Graphics canvas);  

  public JsonObject tojsonObject();
    
    public void fromjsonObject(JsonObject jo);

}
