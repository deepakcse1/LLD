package FactoryDesignPattern;

public class AbstractFactoryMethod {
  
}
interface Burger{
  void prepare();
}
class VegNormalBurger implements Burger{
  public void prepare() {
    System.out.println("Preparing Veg Normal Burger");
  }
}
class VegPremiumBurger implements Burger{
  public void prepare() {   
    System.out.println("Preparing Veg Premium Burger");
  }
}
class ChickenNormalBurger implements Burger{
  public void prepare() {
    System.out.println("Preparing Chicken Normal Burger");
  }
}
class ChickenPremiumBurger implements Burger{
  public void prepare() {   
    System.out.println("Preparing Chicken Premium Burger");
  }
}
interface GarlicBread{
  void prepare();
}
class VegNormalGarlicBread implements GarlicBread{
  public void prepare() {
    System.out.println("Preparing Veg Normal Garlic Bread");
  }
}
class VegPremiumGarlicBread implements GarlicBread{
  public void prepare() {   
    System.out.println("Preparing Veg Premium Garlic Bread");
  }
}
class ChickenNormalGarlicBread implements GarlicBread{
  public void prepare() {
    System.out.println("Preparing Chicken Normal Garlic Bread");
  }
} 
class ChickenPremiumGarlicBread implements GarlicBread{
  public void prepare() {   
    System.out.println("Preparing Chicken Premium Garlic Bread");
  }
}

interface FastFoodFactory{
  Burger createBurger(String type);
  GarlicBread createGarlicBread(String type);
}

class VegFastFoodFactory implements FastFoodFactory{
  public Burger createBurger(String type) {
    if(type.equalsIgnoreCase("Normal")) {
      return new VegNormalBurger();
    } else if(type.equalsIgnoreCase("Premium")) {    
      return new VegPremiumBurger();
    }
    return null;
  }
  public GarlicBread createGarlicBread(String type) {
    if(type.equalsIgnoreCase("Normal")) {
      return new VegNormalGarlicBread();
    } else if(type.equalsIgnoreCase("Premium")) {    
      return new VegPremiumGarlicBread();
    }
    return null;
  }
}
class NonvegFastFoodFactory implements FastFoodFactory{
  public Burger createBurger(String type) {
    if(type.equalsIgnoreCase("Normal")) {    
      return new ChickenNormalBurger();
    } else if(type.equalsIgnoreCase("Premium")) {    
      return new ChickenPremiumBurger();
    }
    return null;
  }
  public GarlicBread createGarlicBread(String type) {
    if(type.equalsIgnoreCase("Normal")) {    
      return new ChickenNormalGarlicBread();
    } else if(type.equalsIgnoreCase("Premium")) {    
      return new ChickenPremiumGarlicBread();
    }
    return null;
  }
}
class Restaurant{
  public static void main(String[] args) {
    FastFoodFactory vegFactory = new VegFastFoodFactory();
    Burger vegBurger = vegFactory.createBurger("Normal");
    vegBurger.prepare();
    GarlicBread vegGarlicBread = vegFactory.createGarlicBread("Premium");
    vegGarlicBread.prepare();   

    FastFoodFactory nonvegFactory = new NonvegFastFoodFactory();
    Burger chickenBurger = nonvegFactory.createBurger("Premium");
    chickenBurger.prepare();
    GarlicBread chickenGarlicBread = nonvegFactory.createGarlicBread("Normal");
    chickenGarlicBread.prepare();   

    
  }
}



