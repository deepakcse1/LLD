package SOLID.LSP;

public class LiskovSubstitution {
  
}
interface Account {
  public void withdraw(double amount);
  public void deposit(double amount);
}
class SavingsAccount implements Account {
  public void withdraw(double amount) {
    // Code to withdraw money from the savings account
  }
  public void deposit(double amount) {
    // Code to deposit money into the account
  }
}
class CurrentAccount implements Account {
  public void withdraw(double amount) {
    // Code to withdraw money from the checking account
  }
  public void deposit(double amount) {
    // Code to deposit money into the account
  }
}
// This class violates the Liskov Substitution Principle as it does not support withdrawal operation so either we will skip this method or throw an exception.
// It is a fixed deposit account and does not allow withdrawal before maturity.
// If we replace the Account class with fixedDepositAccount class, it will break the functionality of the code.
class fixedDepositAccount implements Account {
  // public void withdraw(double amount) {
  // }
  public void withdraw(double amount) {
    throw new UnsupportedOperationException("Withdrawal not allowed for fixed deposit account");
  }
  public void deposit(double amount) {
    // Code to deposit money into the account
  }
}
// To adhere to the Liskov Substitution Principle, we can create a separate interface for withdrawable accounts and have the SavingsAccount and CurrentAccount classes implement that interface. The fixedDepositAccount class will not implement that interface as it does not support withdrawal operation.
interface NonWithdrawable {
  void deposit(double amount);
}
interface Withdrawable extends NonWithdrawable {
  void withdraw(double amount);
}

class SavingsAccountLSP implements Withdrawable {
  public void withdraw(double amount) {
  }
  public void deposit(double amount) {
  }
}
class CurrentAccountLSP implements Withdrawable {
  public void withdraw(double amount) {
    // Code to withdraw money from the savings account
  }
  public void deposit(double amount) {

  }
}
class FixedDepositAccountLSP implements NonWithdrawable {
  public void deposit(double amount) {
  }
}