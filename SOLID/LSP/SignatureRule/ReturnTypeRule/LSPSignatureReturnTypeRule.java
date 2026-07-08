package SOLID.LSP.SignatureRule.ReturnTypeRule;

public class LSPSignatureReturnTypeRule {
  
}
class Organism{ //super Parent
}
class Animal extends Organism{ //parent
}
class Dog extends Animal{ //chile
}

class Parent{
  public Animal getAnimal(){
    return new Animal();
  }
}
class Child extends Parent{
  @Override
  public Animal getAnimal(){
    return new Dog();
  }

  // this is allowed
  // @Override
  // public Dog getAnimal(){
  //   return new Dog();
  // }

  // this is not allowed
  // @Override
  // public Organism getAnimal(){
  //   return new Dog();
  // }
}

