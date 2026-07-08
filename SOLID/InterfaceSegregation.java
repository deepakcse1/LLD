package SOLID;

public class InterfaceSegregation {
  
}

interface Shape{
  void area();
  void volume();
}
// This violates the Interface Segregation Principle as the Circle and Square classes are forced to implement the volume method which is not applicable to them.
class Circle implements Shape{
  public void area(){}
  public void volume(){
    throw new UnsupportedOperationException("Volume not supported for Circle");
  }
}
class Square implements Shape{
  public void area(){}
  public void volume(){
    throw new UnsupportedOperationException("Volume not supported for Square");
  }   
}

// To adhere to the Interface Segregation Principle, we can create separate interfaces for 2D and 3D shapes and have the Circle and Square classes implement the 2D shape interface
interface Shape2D{
  void area();
}
interface Shape3D{  
  public void area();
  void volume();
}
class Circle2D implements Shape2D{
  public void area(){}
}
class cube2 implements Shape3D{
  public void area(){}
  public void volume(){}
}