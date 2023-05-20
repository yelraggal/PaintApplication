/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab7;

import java.awt.Point;

/**
 *
 * @author Mariam Mohamed
 */
public class CalculateDistance {
    
    public static double distance(Point p1,Point p2)
    {
     
        double x2=Math.pow(Math.abs(p1.x-p2.x), 2);
        double y2=Math.pow(Math.abs(p1.y-p2.y), 2);
        return Math.sqrt(x2+y2);
        
        
        
        
        
    }
    
    
}
