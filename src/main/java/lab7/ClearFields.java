/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab7;

import javax.swing.JTextField;

/**
 *
 * @author Dell
 */
public class ClearFields {
    public static boolean  isEmptyFeild(JTextField...textFields)
    {
         for( JTextField jflds: textFields){
             if(jflds.getText().isBlank())
             return true;
         }
         return false;
    }
     public static boolean  isNonNumeric(JTextField...textFields)
    {
         for( JTextField jflds: textFields)
         {
         try{
         double d = Double.parseDouble(jflds.getText());             
                 }catch(NumberFormatException n){
                     return true;
                 }
//             System.out.println("hi");
      
         }   
          return false;
       
    }
    
     public static void clearFields (JTextField...textFields)
    {
         for(JTextField jflds: textFields)
             jflds.setText("");
    }
}
