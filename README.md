# Lensoria
 Lensoria – Eyewear Shop Management System

Lensoria is a Java-based console application that simulates a complete eyewear shopping experience.
It allows customers to purchase lenses, glasses, or both, apply features, generate bills with GST and discounts, and receive a confirmation message using multithreading.

This project demonstrates strong usage of Object-Oriented Programming, Exception Handling, Collections, File Handling, Lambda Expressions, and Multithreading.

 Features

User-friendly menu-driven console interface

Purchase options:

Lenses only

Glasses only

Both lenses and glasses

Dynamic selection of:

Lens types & features

Glass types, frames, colors & features

Automatic billing with GST & discounts

Free sunglasses offer for eligible purchases

Multithreaded thank-you message

Bill saved automatically to a file

Strong input validation using custom exceptions

 Technologies Used

Language: Java

Concepts:

OOP (Inheritance, Polymorphism, Abstraction, Encapsulation)

Interfaces & Abstract Classes

Exception Handling

Multithreading

Collections Framework (ArrayList)

File Handling

Lambda Expressions

String Handling

 OOP Concepts Implemented

Classes & Objects

Constructors & Method Overloading

Inheritance (LensType, GlassType)

Method Overriding

Interfaces (Selectable)

Abstract Classes

final class (StandardGlass)

Custom Exceptions

Multithreading (ThankYouThread)

 Project Structure
Lensoria/
├── Main.java
│
├── user/
│   ├── UserInfo.java
│   ├── InvalidInputException.java
│   └── InvalidChoiceException.java
│
├── interfaces/
│   └── Selectable.java
│
├── lenses/
│   ├── LensType.java
│   ├── StandardLens.java
│   ├── LensManager.java
│   └── InvalidLensException.java
│
├── glasses/
│   ├── GlassType.java
│   ├── StandardGlass.java
│   ├── GlassesManager.java
│   └── InvalidGlassException.java
│
├── billing/
│   ├── BillingManager.java
│   ├── NegativePriceException.java
│   └── InvalidPaymentException.java
│
├── threads/
│   └── ThankYouThread.java
│
├── utils/
│   ├── BillNumberGenerator.java
│   ├── DateTimeUtil.java
│   ├── TextProcessor.java
│   └── FileHandler.java
│
└── bills/
    ├── Bill_08_10_2025.txt
    ├── Bill_09_10_2025.txt

 Exception Handling

Custom exceptions ensure reliable input validation:

InvalidInputException

InvalidChoiceException

InvalidLensException

InvalidGlassException

NegativePriceException

InvalidPaymentException

 Multithreading

A separate ThankYouThread runs after billing

Uses sleep() for animation

Uses join() to synchronize with the main thread

 File Handling

Bills are automatically saved in the bills/ directory

Each bill includes:

Customer details

Item list

GST, discount, final amount

Payment method
