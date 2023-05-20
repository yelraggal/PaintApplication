
package lab7;

import java.nio.file.Path;
import java.util.ArrayList;


public interface DrawingEngine {
/* manage shapes objects */
public void addShape(Shape shape);
public void removeShape(Shape shape);
/* return the created shapes objects */
public Shape[] getShapes();
/* redraw all shapes on the canvas */
public void refresh(java.awt.Graphics canvas);
  public void save(Path path) ;
  public ArrayList<Shape> getter();

}
