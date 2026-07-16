package FactoryDesignPattern;

public class SimpleFactory {
  
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
class BurgerFactory{
  public Burger getBurger(String type) {
    if(type.equalsIgnoreCase("Veg")) {
      return new VegBurger();
    } else if(type.equalsIgnoreCase("Chicken")) {
      return new ChickenBurger();
    } 
    return null;
  } 
}
class Restaurant{
  public static void main(String[] args) {
    BurgerFactory burgerFactory = new BurgerFactory();
    Burger vegBurger = burgerFactory.getBurger("Veg"); 
    vegBurger.prepare();
    
    Burger chickenBurger = burgerFactory.getBurger("Chicken");
    chickenBurger.prepare();
  }
}