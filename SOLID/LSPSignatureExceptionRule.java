package SOLID;

public class LSPSignatureExceptionRule {
  
}
class ParentException{
  public void doSomething() throws RuntimeException{
    // code
  }
}
class ChildException extends ParentException{
  @Override
  public void doSomething() throws NullPointerException, ArrayIndexOutOfBoundsException, ArithmeticException{ 
    // code
  }    
}

//this is not allowed as it violates the Liskov Substitution Principle. 
// The method signature of the doSomething method in the ChildException2 class is more general than the method signature of the doSomething method in the ParentException class. This means that if we replace a ParentException object with a ChildException2 object, it will break the functionality of the code.
// class ChildException2 extends ParentException{
//   @Override
//   public void doSomething() throws Exception{ 
//     // code
//   }    
// } 



