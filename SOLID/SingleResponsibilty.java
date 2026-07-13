package SOLID;

import java.util.Arrays;
import java.util.List;

class Product{
  private String name;
  private double price;

  public Product(String name, double price) {
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }
}

// Voilation of Single Responsibility Principle as it is responsible for calculating total price, generating invoice and saving to database.
class ShopingCart{
  static List<Product> products;
  static double calculateTotalPrice() {
    double total = 0;
    for (Product product : products) {
      total += product.getPrice();
    }
    return total;
  }

  static void printInvoice() {
    double totalPrice = calculateTotalPrice();
    System.out.println("Invoice:");
    for (Product product : products) {
      System.out.println(product.getName() + " - $" + product.getPrice());
    }
    System.out.println("Total Price: $" + totalPrice);
  }

  static void saveToDatabase() {
    // Code to save the shopping cart to a database
  }
  public static void main(String[] args) {
    calculateTotalPrice();
    printInvoice();
    saveToDatabase();
  }
}

// ------------------Adhering to Single Responsibility Principle--------------------
class ShoppingCartSRP {
  List<Product> products;
  double calculateTotalPrice() {
    double total = 0;
    for (Product product : products) {
      total += product.getPrice();
    }
    return total;
  }
}

class InvoicePrinter {
  ShoppingCartSRP cart;
  public InvoicePrinter(ShoppingCartSRP cart) {
    this.cart = cart;
  }

  void printInvoice() {
    double totalPrice = cart.calculateTotalPrice();
    System.out.println("Invoice:");
    for (Product product : cart.products) {
      System.out.println(product.getName() + " - $" + product.getPrice());
    }
    System.out.println("Total Price: $" + totalPrice);
  }
}

class DatabaseSaver {
  ShoppingCartSRP cart;
  public DatabaseSaver(ShoppingCartSRP cart) {
    this.cart = cart;
  }
  void saveToDatabase() {
    // Code to save the shopping cart to a database
  }
}

class MainKart {
  public static void main(String[] args) {

    ShoppingCartSRP cart = new ShoppingCartSRP();
    cart.products = Arrays.asList(
        new Product("Laptop", 70000),
        new Product("Mouse", 1200),
        new Product("Keyboard", 2500));

    InvoicePrinter invoicePrinter = new InvoicePrinter(cart);
    // DatabaseSaver databaseSaver = new DatabaseSaver(cart);

    System.out.println("Total Price = " + cart.calculateTotalPrice());

    invoicePrinter.printInvoice();

    // databaseSaver.saveToDatabase();
  }
}

