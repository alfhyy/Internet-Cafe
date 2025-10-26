# Internet Cafe Billing System

A simple Java-based billing system for managing internet cafe sessions, food orders, and payment calculations.

## 📋 Table of Contents

- [About](#about)
- [Features](#features)
- [Project Structure](#project-structure)
- [Requirements](#requirements)
- [Installation](#installation)
- [Usage](#usage)
- [Code Refactoring Techniques](#code-refactoring-techniques)
- [API Documentation](#api-documentation)
- [Contributing](#contributing)
- [License](#license)

## 📖 About

This project is an Internet Cafe management system that handles customer billing, including internet bundle packages, food orders, and additional charges. The system automatically calculates taxes (PPN 15%) and provides a complete billing summary.

## ✨ Features

- **Customer Management**: Track customer information including name, seat number, and selected bundle
- **Bundle Selection**: Support for various internet time packages
- **Food Ordering**: Customers can order food items with automatic price tracking
- **Additional Billing**: Add extra charges for penalties or additional services
- **Tax Calculation**: Automatic PPN (15%) calculation on base prices
- **Billing Summary**: Complete itemized billing information display

## 📁 Project Structure
```
internet_cafe_refactored/
├── InternetCafe.java       # Main billing system class
├── MainApp.java            # Application entry point
└── customerAction.java     # Interface for customer actions
```

## 💻 Requirements

- Java Development Kit (JDK) 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, NetBeans, VS Code)
- Basic understanding of Java programming

## 🚀 Installation

1. Clone or download this repository
2. Open the project in your preferred Java IDE
3. Ensure the package structure is maintained: `internet_cafe_refactored`
4. Compile the Java files

### Using Command Line:
```bash
# Navigate to the project directory
cd path/to/project

# Compile all Java files
javac internet_cafe_refactored/*.java

# Run the application
java internet_cafe_refactored.MainApp
```

### Using IDE:

1. Import the project into your IDE
2. Right-click on `MainApp.java`
3. Select "Run" or "Run As > Java Application"

## 📝 Usage

### Basic Example
```java
// Create a new customer session
InternetCafe customer = new InternetCafe(
    "John Doe",              // Customer name
    "Paket Hikki (10 jam)",  // Bundle package
    "PC-12",                 // Seat number
    15000                    // Base price
);

// Add additional billing (e.g., penalty)
customer.adBil(5000);

// Order food items
customer.orderFood("Instant Noodles", 10000);
customer.orderFood("Caffe Latte", 8000);

// Display complete billing information
customer.memberInfo();
```

### Sample Output
```
Added extra billing: Rp5000.0
John Doe ordered: Instant Noodles for Rp10000.0
John Doe ordered: Caffe Latte for Rp8000.0

=== Internet Café Billing ===
Seat number: PC-12
Username: John Doe
Selected Bundle: Paket Hikki (10 jam)
Base Price + PPN 15%: 17250.0

--- Food Orders ---
Instant Noodles (Rp10000.0)
Caffe Latte (Rp8000.0)

Additional Billing: Rp5000.0
Total to Pay: Rp40250.0
```

## 🔧 Code Refactoring Techniques

This project implements several refactoring techniques:

1. **Encapsulate Field**: All fields are private with public getter methods
2. **Extract Interface**: `customerAction` interface for food ordering functionality
3. **Introduce Constant**: `PPN` constant for tax rate (0.15)
4. **Introduce Method**: `priceCalculation()` method for base price + tax
5. **Move Members**: Main method moved to separate `MainApp` class

## 📚 API Documentation

### InternetCafe Class

#### Constructor
```java
InternetCafe(String customerName, String bundle, String seatNumber, double price)
```

#### Methods
- `void orderFood(String item, float price)` - Add food order
- `void adBil(float bil)` - Add additional billing charge
- `double calculateTotal()` - Calculate total amount to pay
- `void memberInfo()` - Display complete billing information

### customerAction Interface
```java
void orderFood(String item, float price)
```

For complete JavaDoc documentation, generate docs using:
```bash
javadoc -d docs internet_cafe_refactored/*.java
```
