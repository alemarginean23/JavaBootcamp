# Store Inventory App

A simple Java application to simulate a store's inventory management system. The app allows you to add products (electronics, clothing, shoes) to the inventory, view the inventory, and remove products (or decrease their quantity). The app employs design patterns to ensure maintainability and scalability.

## Features
- **Add Products:** Users can add products to the inventory by specifying the product type (electronics, clothing, shoe), name, price, and quantity.
- **View Inventory:** Users can view a list of all products in the inventory, including their name, price, and quantity.
- **Remove Products or Quantity:** Users can remove a specific product from the inventory or reduce its quantity if desired.
- **Input Validation:** The app ensures valid input for price and quantity (e.g., price cannot be negative, quantity must be a positive integer).
  
## Design Patterns Used
### 1. **Factory Pattern**
   - **Purpose:** The Factory Pattern is used to create instances of different product types (Electronics, Clothing, Shoes) based on user input. This allows easy extension if more product types need to be added in the future.
   - **How It Works:** 
     - The `ProductFactory` class defines a method to create a product. The type of product (e.g., electronics, clothing, shoe) is determined by user input, and the corresponding product object is created and returned.

### 2. **Singleton Pattern**
   - **Purpose:** The Singleton Pattern ensures that there is only one instance of the inventory (i.e., one list of products).
   - **How It Works:** 
     - The `Inventory` class is designed as a singleton, meaning that no matter how many times it's called, only one instance of the inventory is used. This is managed by the `getInstance()` method.

### 3. **Controller-Service-Repository Pattern**
   - **Purpose:** This structure separates concerns within the app. The Controller handles user interactions, the Service handles business logic (e.g., adding, removing products), and the Repository manages data storage (i.e., the inventory).
   - **How It Works:** 
     - The `StoreController` class acts as the controller that interacts with the user. It uses the `ProductService` class for business logic and the `ProductRepository` class to store and retrieve product data.

# Store Inventory App - Package and Class Explanation

## 1. Model Package
### Classes:
- **`Product` (Abstract Class):**  
  The base class for all products, containing attributes like `name`, `price`, and `quantity`.

- **`Electronics`, `Clothing`, `Shoe` (Subclasses):**  
  Concrete implementations of `Product`, each representing a specific product type.

- **`Inventory`:**  
  A singleton class that holds the list of products. Provides methods to add, remove, and retrieve products.

### Purpose:  
Encapsulates data and domain-specific logic for products and inventory.

---

## 2. Controller Package
### Classes:
- **`StoreController`:**  
  Handles user commands by interacting with `ProductService` to perform actions like adding, viewing, or removing products.

### Purpose:  
Bridges the user interface (`StoreView`) and the service layer (`ProductService`).

---

## 3. Service Package
### Classes:
- **`ProductService`:**  
  Contains business logic for adding products, checking inventory, and removing products or quantities.

### Purpose:  
Acts as a middle layer that processes user commands and interacts with the repository.

---

## 4. Repository Package
### Classes:
- **`ProductRepository`:**  
  Stores and retrieves product data. Maintains the inventory as a list of products.

### Purpose:  
Provides an abstraction for data storage and retrieval.

---

## 5. View (Entry Point)
### Classes:
- **`StoreView`:**  
  The user interface layer that provides the menu, collects user inputs, and interacts with the controller to perform actions.

### Purpose:  
Handles user interactions and displays results.

---

## Example Usage

### **1. Adding a Product:**
```plaintext
Enter product type (electronics/clothing/shoe): shoe
Enter product name: sneakers
Enter product price: 50
Enter product quantity: 5
Product added to inventory.

