E-Commerce System (Java OOP Project)
Project Overview
This project is a menu-driven E-Commerce System implemented in Java using Object-Oriented Programming (OOP) concepts.
The system allows users to view products, add items to a shopping cart, update quantities, and checkout orders with GST calculation.
The project demonstrates key OOP concepts such as Abstraction, Inheritance, Polymorphism, and Encapsulation.

Features

View available products
Add products to shopping cart
Update product quantity in cart
View cart details
Checkout with GST calculation
Menu-driven console application

Technologies Used

Java
Object-Oriented Programming
Collections Framework (HashMap)
Git & GitHub


OOP Concepts Implemented
1. Abstraction

The Product class is an abstract class that defines common properties and methods for all product types.

2. Inheritance

Product types extend the Product class:

ElectronicsProduct

ClothingProduct

BookProduct

3. Polymorphism

Each product implements its own version of the method:

calculateDiscount()
4. Encapsulation

Product attributes are protected and accessed through getter methods.

Discount Rules
Product Type	Discount
Electronics	10%
Clothing	20%
Books	5%
Sample Output
=== E-COMMERCE SYSTEM ===
1. View Products
2. Add to Cart
3. View Cart
4. Update Cart
5. Checkout
6. Exit

Example Cart:

=== SHOPPING CART ===
E001 Smartphone X Qty:1 Total: ₹45000
C001 Cotton T-Shirt Qty:2 Total: ₹1920
---------------------
Total Amount: ₹46920

Checkout:

=== ORDER DETAILS ===
Order ID: ORD1000
Subtotal: ₹46920
GST (18%): ₹8445.6
Final Amount: ₹55365.6
🎉 ORDER CONFIRMED!
How to Run the Project

Clone the repository

git clone https://github.com/yourusername/Ecommerce-OOP-Java.git

Open the project in Eclipse or any Java IDE

Compile and run:

MainApp.java
Future Enhancements

Add database integration (MySQL)

Implement user authentication

Add GUI using JavaFX or Swing

Implement product inventory management

Author

Sri Vishnu
