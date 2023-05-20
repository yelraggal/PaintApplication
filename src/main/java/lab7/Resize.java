/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lab7;

import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author Mariam Mohamed
 */
public interface Resize {
    
    public Rectangle[] getRio();
    public void setRio(Rectangle[] rio);
    public void deletedots(Graphics canvas);
    public void setDots ();
    public void drawdots(Graphics canvas);
    public void drawdotsWhileDragging(Graphics canvas,int k, Point currentCorPoint);

    
}
