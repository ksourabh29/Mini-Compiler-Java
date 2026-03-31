# 🧠 Mini Compiler in Java

## 📌 Overview
This project is a Mini Compiler developed in Java that simulates the basic phases of a compiler. It processes arithmetic expressions by performing lexical analysis, syntax validation, and evaluation. The compiler takes user input, validates it, and computes the correct result while handling errors like invalid syntax and divide-by-zero.

## 🚀 Features
- Lexical Analysis (Tokenization)
- Syntax Validation (Parser)
- Expression Evaluation
- Operator Precedence Handling (+, -, *, /)
- Parentheses Support
- Multi-digit Number Support
- Error Handling (Invalid Expression, Divide by Zero)

## 🧠 Working Flow
User Input → Lexer → Parser → Evaluator → Output

## 🔍 Compiler Phases

### 1. Lexer (Tokenization)
Breaks the input string into tokens.

Example:
Input: 10+2*5  
Tokens: NUMBER(10), PLUS(+), NUMBER(2), MULTIPLY(*), NUMBER(5)

### 2. Parser (Syntax Validation)
Checks whether the expression follows valid syntax rules.

Valid Expressions:
5+3  
(2+3)*4  
10+2*5  

Invalid Expressions:
5+*3  
(2+3  
+5  

### 3. Evaluator (Execution)
Evaluates the expression using stack data structure, operator precedence, and parentheses handling.

Example:
Input: 2+3*4  
Output: 14  

## ⚠️ Error Handling
Invalid Expression Example:
Input: (2+3  
Output: Invalid Expression  

Divide by Zero Example:
Input: 10/0  
Output: Error: Divide by zero  

## 🛠️ Technologies Used
- Java  
- Object-Oriented Programming (OOP)  
- Data Structures (Stack)  
- Basic Compiler Design Concepts  

## 📂 Project Structure
MiniCompiler  
 ├── Main.java  
 ├── Token.java  
 ├── Lexer.java  
 ├── Parser.java  
 ├── Evaluator.java  

## Future Enhancements
- Variable support (a = 5)  
- Symbol table implementation  
- Support for additional operators (^, %)  
- GUI using Java Swing  
- File input support  
- Advanced error messages  

##  Author
Sourabh Kulkarni  

