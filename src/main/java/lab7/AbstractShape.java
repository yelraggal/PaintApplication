/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab7;

import java.awt.Color;
import java.awt.Point;
/**
 *
 * @author Mariam Mohamed
 */
public abstract class AbstractShape implements Shape,Moveable,Resize{
    
    private Point position;
    private Color color;
    private Color fillcolor;
    private Point draggingPoint;
    
    
    public AbstractShape(Point position) {
        this.position = position;
    }
     @Override
    public void setPosition(Point position) {
        this.position = position;
    }

    @Override
    public Point getPosition() {
        return position;
    }

   @Override
    public void setColor(java.awt.Color c) {
        this.color =c;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setFillColor(java.awt.Color c) {
        this.fillcolor = c;
    }

    @Override
    public Color getFillColor() {
        return fillcolor;
    }  
    
    
    
    public Point getDraggingPoint() {
        return draggingPoint;
    }

    public void setDraggingPoint(Point draggingPoint) {
        this.draggingPoint = draggingPoint;
    }

    
    
}
