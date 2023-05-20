/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lab7;

import java.awt.Point;

/**
 *
 * @author Mariam Mohamed
 */
public interface Moveable {

void setDraggingPoint(Point b);
Point getDraggingPoint();
boolean contains(Point b);
void moveTo (Point b);
   
}
