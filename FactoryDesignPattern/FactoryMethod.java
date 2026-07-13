package FactoryDesignPattern;

public class FactoryMethod {
  
}
interface Burger{
  void prepare();
}
class VegBurger implements Burger{
  public void prepare() {
    System.out.println("Preparing Veg Burger");
  }
}
class ChickenBurger implements Burger{
  public void prepare() {   
    System.out.println("Preparing Chicken Burger"); 
  }
}
class WheetVegBurger implements Burger{
  public void prepare() {
    System.out.println("Preparing Wheet Veg Burger");
  }
}
class WheetChickenBurger implements Burger{
  public void prepare() {   
    System.out.println("Preparing Wheet Chicken Burger"); 
  }
}
abstract class BurgerFactory{
  public abstract Burger getBurger(String type);
}
class VegBurgerFactory extends BurgerFactory{
  public Burger getBurger(String type) {
    if(type.equalsIgnoreCase("Veg")) {
      return new VegBurger();
    } else if(type.equalsIgnoreCase("WheetVeg")) {    
      return new WheetVegBurger();
    }
    return null;
  }
}
class ChickenBurgerFactory extends BurgerFactory{
  public Burger getBurger(String type) {
    if(type.equalsIgnoreCase("Chicken")) {    
      return new ChickenBurger();
    } else if(type.equalsIgnoreCase("WheetChicken")) {    
      return new WheetChickenBurger();
    }
    return null;
  }
}
class Restaurant{
  public static void main(String[] args) {
    BurgerFactory vegBurgerFactory = new VegBurgerFactory();
    Burger vegBurger = vegBurgerFactory.getBurger("Veg");   
    vegBurger.prepare();
    BurgerFactory chickenBurgerFactory = new ChickenBurgerFactory();
    Burger chickenBurger = chickenBurgerFactory.getBurger("Chicken");
    chickenBurger.prepare();
  }
}
