package StrategyDesignPattern;

public class StrategyDesignPattern {
  
}
interface Talkable{
  void talk();
}
class NormalTalk implements Talkable{
  public void talk() {
    System.out.println("Normal talking");
  }
}
class NoTalk implements Talkable{
  public void talk() {
    System.out.println("No talking");
  }
}
interface Walkable{
  void walk();
}
class NormalWalk implements Walkable{
  public void walk() {
    System.out.println("Normal walking");
  } 
}
class NoWalk implements Walkable{
  public void walk() {
    System.out.println("No walking");
  } 
}
interface Flyable{
  void fly();
}
class NormalFly implements Flyable{
  public void fly() {
    System.out.println("Normal flying");
  } 
}
class NoFly implements Flyable{
  public void fly() {
    System.out.println("No flying");
  } 
}
interface Projectionable{
  void projection();
}
class BirdProjection implements Projectionable{
  public void projection() {
    System.out.println("Bird Robot Projection");
  }
}
class DogProjection implements Projectionable{
  public void projection() {
    System.out.println("Dog Robot Projection");
  }
}
// It just deligate its request
class Robot{
  private Talkable talkBehavior;
  private Walkable walkBehavior;
  private Flyable flyBehavior;
  private Projectionable projectionBehavior;
  public Robot(Talkable talkBehavior, Walkable walkBehavior, Flyable flyBehavior, Projectionable projectionBehavior) {
    this.talkBehavior = talkBehavior;
    this.walkBehavior = walkBehavior;
    this.flyBehavior = flyBehavior;
    this.projectionBehavior = projectionBehavior;
  }
  public void talk() {
    talkBehavior.talk();
  }
  public void walk() {
    walkBehavior.walk();
  }
  public void fly() {
    flyBehavior.fly();
  }
  public void projection() {
    projectionBehavior.projection();
  }
}

class MainClass {
  public static void main(String[] args) {
    // Robot birdRobot = new BirdRobot(new NormalTalk(), new NormalWalk(), new NormalFly(), new BirdProjection());
    // birdRobot.talk(); // Output: Normal talking
    // birdRobot.walk(); // Output: Normal walking
    // birdRobot.fly();  // Output: Normal flying
    // birdRobot.projection(); // Output: Bird Robot Projection

    // Robot dogRobot = new DogRobot(new NoTalk(), new NormalWalk(), new NoFly() , new DogProjection());
    // dogRobot.talk(); // Output: No talking
    // dogRobot.walk(); // Output: Normal walking
    // dogRobot.fly();  // Output: No flying
    // dogRobot.projection(); // Output: Dog Robot Projection
  }
}
