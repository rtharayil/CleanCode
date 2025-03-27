# Clean Code: Naming Variables, Functions, and Classes 

Writing clean code is essential for maintaining readability, scalability, and maintainability of software. One of the most critical aspects of clean code is how we name variables, functions, and classes. In this write-up, we'll explore best practices for naming in C#, along with examples.

---

## 1. **Naming Variables**

Variables should have meaningful and descriptive names that clearly indicate their purpose. Avoid single-letter names or ambiguous terms.

### Best Practices:
- Use **camelCase** for local variables and private fields.
- Use **PascalCase** for public fields and properties.
- Avoid abbreviations unless they are widely understood.
- Be specific about the variable's purpose.

### Examples:

#### Bad:
```csharp
int x; // What does 'x' represent?
string n; // What is 'n'?
int d; // No context
```

#### Good:
```csharp
int userAge; // Clearly describes the variable's purpose
string userName; // Indicates the variable holds a user's name
int daysSinceLastLogin; // Specific and descriptive
```

#### Private Field Example:
```csharp
private int _maxRetryAttempts; // Private fields often use an underscore prefix
```

#### Public Property Example:
```csharp
public string FirstName { get; set; } // PascalCase for properties
```

---

## 2. **Naming Functions**

Functions should have names that clearly describe what they do. The name should be a verb or a verb phrase, as functions perform actions.

### Best Practices:
- Use **PascalCase** for method names.
- Start with a verb to indicate action (e.g., `Calculate`, `Get`, `Validate`).
- Be specific about the function's purpose.
- Avoid vague names like `Process` or `Handle`.

### Examples:

#### Bad:
```csharp
void DoStuff(); // What does this function do?
void Process(); // Too vague
void HandleData(); // What kind of handling?
```

#### Good:
```csharp
void CalculateTotalPrice(); // Clearly describes the action
string GetUserFullName(); // Indicates what the function returns
bool ValidateEmailAddress(string email); // Specific and descriptive
```

#### Example with Parameters:
```csharp
public void SendEmail(string recipient, string subject, string body)
{
    // Function logic here
}
```

---

## 3. **Naming Classes**

Class names should represent what the class is or does. They should be nouns or noun phrases, as classes represent objects or concepts.

### Best Practices:
- Use **PascalCase** for class names.
- Be specific and avoid generic names.
- Avoid abbreviations unless they are widely accepted.

### Examples:

#### Bad:
```csharp
class Manager; // What does this class manage?
class Helper; // Too generic
class Utils; // What kind of utilities?
```

#### Good:
```csharp
class UserAccount; // Represents a user account
class EmailService; // Handles email-related functionality
class PaymentProcessor; // Specific and descriptive
```

#### Example with Inheritance:
```csharp
public abstract class Shape
{
    public abstract double CalculateArea();
}

public class Circle : Shape
{
    public double Radius { get; set; }

    public override double CalculateArea()
    {
        return Math.PI * Radius * Radius;
    }
}
```

---

## 4. **Additional Tips for Clean Naming**

### Avoid Magic Numbers and Strings
Instead of hardcoding values, use constants or enums with meaningful names.

#### Bad:
```csharp
if (userRole == "Admin") // Magic string
{
    // Do something
}
```

#### Good:
```csharp
const string AdminRole = "Admin";

if (userRole == AdminRole)
{
    // Do something
}
```

### Use Enums for Fixed Sets of Values
Enums provide a clear and type-safe way to represent a set of related values.

#### Example:
```csharp
public enum UserRole
{
    Admin,
    Moderator,
    Guest
}

UserRole role = UserRole.Admin;
```

### Avoid Redundant Names
Do not include the type of the variable or class in its name.

#### Bad:
```csharp
string userNameString; // Redundant
int userAgeInt; // Redundant
class UserClass; // Redundant
```

#### Good:
```csharp
string userName;
int userAge;
class User;
```

---

## 5. **Real-World Example**

Let's put it all together with a real-world example.

### Scenario:
We are building a simple e-commerce application. We need to create a class to handle shopping cart functionality.

#### Clean Code Implementation:
```csharp
public class ShoppingCart
{
    private List<CartItem> _items;

    public ShoppingCart()
    {
        _items = new List<CartItem>();
    }

    public void AddItem(CartItem item)
    {
        if (item == null)
        {
            throw new ArgumentNullException(nameof(item));
        }

        _items.Add(item);
    }

    public decimal CalculateTotalPrice()
    {
        return _items.Sum(item => item.Price * item.Quantity);
    }
}

public class CartItem
{
    public string ProductName { get; set; }
    public decimal Price { get; set; }
    public int Quantity { get; set; }
}
```

#### Usage:
```csharp
var cart = new ShoppingCart();
cart.AddItem(new CartItem { ProductName = "Laptop", Price = 1200, Quantity = 1 });
cart.AddItem(new CartItem { ProductName = "Mouse", Price = 25, Quantity = 2 });

decimal totalPrice = cart.CalculateTotalPrice();
Console.WriteLine($"Total Price: {totalPrice}");
```

---

## Conclusion

Clean code starts with meaningful and descriptive names for variables, functions, and classes. By following these best practices, you can write code that is easy to read, understand, and maintain. Remember:

- Use **camelCase** for variables and private fields.
- Use **PascalCase** for methods, classes, and properties.
- Be specific and avoid ambiguity.
- Avoid redundancy and magic numbers/strings.


