package SOLID;

public class LSPMethodSignatureRule {
  
}
class Food{

}
class PlantBasedFood extends Food{
}
class AnimalBasedFood extends Food{
}
class Seed extends PlantBasedFood{
}
class Bird{
  public void eat(PlantBasedFood food){}
}

class Parrot extends Bird{
  @Override
  public void eat(PlantBasedFood food){}
  
  // this also not allowed because java does not allow this as it became overloading
  // @Override
  // public void eat(Food food){}

  // //this is not allowed as it violates the Liskov Substitution Principle. The method signature of the eat method in the subclass should be the same as the method signature of the eat method in the superclass. The method signature of the eat method in the Parrot class is different from the method signature of the eat method in the Bird class. The method signature of the eat method in the Parrot class is more specific than the method signature of the eat method in the Bird class. This means that if we replace a Bird object with a Parrot object, it will break the functionality of the code.
  // @Override
  // public void eat(Seed food){}
}
