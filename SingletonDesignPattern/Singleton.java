package SingletonDesignPattern;

public class Singleton {
  public Singleton() {
    System.out.println("Singleton instance created");
  }
}
class SingletonDemo {
  public static void main(String[] args) {
    Singleton s1 = new Singleton();
    Singleton s2 = new Singleton();
    System.out.println(s1 == s2); // Output: false, as two different instances are created
  }
}
//------------------Singleton with Lazy Initialization Type 1--------------------
class SingletonLazy1 {
  private static SingletonLazy1 instance;
  private SingletonLazy1() {
    System.out.println("SingletonLazy instance created");
  } 
  public static SingletonLazy1 getInstance() {
    if (instance == null) {
      instance = new SingletonLazy1();
    }
    return instance;
  }
}

//------------------Singleton with Lazy Initialization Type 2--------------------
class SingletonLazy2 {
  private static SingletonLazy2 instance;
  private SingletonLazy2() {
    System.out.println("SingletonLazy instance created");
  } 
  public static synchronized SingletonLazy2 getInstance() {
    if (instance == null) {
      instance = new SingletonLazy2();
    }
    return instance;
  }
}

//------------------Singleton with Lazy Initialization Type 3--------------------
class SingletonLazy3 {
  private static SingletonLazy3 instance;
  private SingletonLazy3() {
    System.out.println("SingletonLazy instance created");
  } 
  public static SingletonLazy3 getInstance() {
    // But it still locks every time.
    synchronized(SingletonLazy3.class){
      if (instance == null) {
        instance = new SingletonLazy3();
      }
      return instance;
    }
  }
}

//------------------Singleton with Lazy Initialization Type 4--------------------
class SingletonLazy4 {
  private static SingletonLazy4 instance;
  private SingletonLazy4() {
    System.out.println("SingletonLazy instance created");
  } 
  public static SingletonLazy4 getInstance() {
    if(instance == null){
      synchronized(SingletonLazy4.class){
        if(instance == null){
          instance = new SingletonLazy4();
        }
      }
    }
    return instance;
  }
}

//------------------Singleton with Lazy Initialization Type 4--------------------
class SingletonLazy {
  // Private constructor to prevent instantiation from outside
  private SingletonLazy() {
    System.out.println("SingletonLazy instance created");
  }
  // Bill Pugh Singleton Implementation
  private static class Holder{
    private static final SingletonLazy instance = new SingletonLazy();
  }
  public static SingletonLazy getInstance() {
    return Holder.instance;
  }
}

class SingletonLazyDemo {
  public static void main(String[] args) {
    SingletonLazy s1 = SingletonLazy.getInstance();
    SingletonLazy s2 = SingletonLazy.getInstance();
    System.out.println(s1 == s2); // Output: true, as both references point to the same instance
  }
}