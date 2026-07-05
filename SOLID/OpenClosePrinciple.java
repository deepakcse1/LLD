package SOLID;
// Voilation of Open Close Principle as it is not open for extension and closed for modification.
// We have to modify the existing code to add new database support.
class DatabaseSaver{
  void saveToDatabase(ShoppingCartSRP cart) {
    // Code to save the shopping cart to a database
  }
  void saveToMongo(ShoppingCartSRP cart) {
    // Code to save the shopping cart to a database
  }
  void saveToPostgres(ShoppingCartSRP cart) {
    // Code to save the shopping cart to a database
  }
}
// Adhering to Open Close Principle as it is open for extension and closed for modification.
// We can add new database support without modifying the existing code.
interface DatabaseSaverOCP{
  void save(ShoppingCartSRP cart);
}
class MySQLDatabaseSaver implements DatabaseSaverOCP{
  public void save(ShoppingCartSRP cart) {
    // Code to save the shopping cart to a MySQL database
  }
}
class MongoDatabaseSaver implements DatabaseSaverOCP{
  public void save(ShoppingCartSRP cart) {
    // Code to save the shopping cart to a MongoDB database
  }
}
class PostgresDatabaseSaver implements DatabaseSaverOCP{
  public void save(ShoppingCartSRP cart) {
    // Code to save the shopping cart to a PostgreSQL database
  }
}