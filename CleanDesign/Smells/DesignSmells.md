Here's a comprehensive guide to design smells in C# with real-world examples for each category:

### 1. **Alternative Classes with Different Interfaces**
```csharp
// Smell: Similar functionality but different method names
class JsonParser {
    public object Parse(string input) { /* ... */ }
}

class XmlConverter {
    public object ConvertFromXml(string xml) { /* ... */ } 
}

// Solution: Standardize interfaces
interface IDataParser {
    object Parse(string input);
}
```

### 2. **Broken Hierarchy**
```csharp
class Bird {
    public virtual void Fly() { /* ... */ }
}

class Penguin : Bird {  // Penguins can't fly!
    public override void Fly() => throw new NotSupportedException();
}
```

### 3. **Data Clumps**
```csharp
// Smell: Repeated parameter groups
void CreateUser(string firstName, string lastName, string street, string city, string zip) { /* ... */ }
void PlaceOrder(Product p, string street, string city, string zip) { /* ... */ }

// Solution: Introduce Address class
record Address(string Street, string City, string Zip);
```

### 4. **God Class**
```csharp
class OrderManager {  // Does everything
    public void ProcessOrder() { /* ... */ }
    public void ValidatePayment() { /* ... */ }
    public void GenerateInvoice() { /* ... */ }
    public void SendNotification() { /* ... */ }
    public void UpdateInventory() { /* ... */ }
}
```

### 5. **Feature Envy**
```csharp
class OrderProcessor {
    public decimal CalculateTotal(Order order) {
        // Smell: Knows too much about Customer's discount logic
        return order.Items.Sum(i => i.Price) * (1 - order.Customer.DiscountRate);
    }
}
```

### 6. **Primitive Obsession**
```csharp
// Smell: Using primitives for domain concepts
void RecordTemperature(double value) { /* ... */ }

// Solution: Value object
record Celsius(double Value) {
    public static Celsius From(double value) => 
        value is >= -20 and <= 60 ? new(value) : throw new ArgumentOutOfRangeException();
}
```

### 7. **Shotgun Surgery**
```csharp
// Smell: Changing one feature requires modifying many classes
class Order { /* ... */ }  // Has tax logic
class Invoice { /* ... */ } // Also has tax logic
class Report { /* ... */ }  // Also has tax logic
```

### 8. **Switch Statements**
```csharp
// Smell: Type-checking switch
decimal CalculateShippingCost(object carrier) {
    return carrier switch {
        USPS => 5.00m,
        FedEx => 8.50m,
        UPS => 7.25m,
        _ => throw new ArgumentException()
    };
}

// Solution: Polymorphism
interface IShippingCarrier {
    decimal CalculateCost();
}
```

### 9. **Inappropriate Intimacy**
```csharp
class Order {
    private Customer _customer;
    
    public string GetCustomerCreditCardNumber() {  // Smell: Exposing private details
        return _customer.CreditCard.Number;
    }
}
```

### 10. **Lazy Class**
```csharp
class OrderHelper {  // Does almost nothing
    public void Print(Order order) => Console.WriteLine(order.ToString());
}
```

### 11. **Message Chains**
```csharp
// Smell: Deep property access chain
var city = customer.Address.Street.Location.City;
```

### 12. **Speculative Generality**
```csharp
interface IFutureFeature {  // Never actually implemented
    void DoSomethingWeMightNeed();
}
```

### 13. **Refused Bequest**
```csharp
class Vehicle {
    protected int WheelCount;
    public virtual void Drive() { /* ... */ }
}

class Car : Vehicle { /* Uses WheelCount */ }

class Hovercraft : Vehicle {  // Doesn't use WheelCount
    public override void Drive() => Levitate();
}
```

### 14. **Cyclic Dependency**
```csharp
// Smell: Two classes directly depending on each other
class Order {
    private Invoice _invoice;
}

class Invoice {
    private Order _order;
}
```

### 15. **Data Class**
```csharp
// Smell: Just fields with getters/setters
class PatientRecord {
    public string Name { get; set; }
    public DateTime BirthDate { get; set; }
    // No behavior
}
```

### 16. **Spaghetti Code**
```csharp
void Process() {  // No structure, mixed concerns
    var data = ReadFile();
    if (data != null) {
        var cleaned = data.Trim();
        decimal total = 0;
        foreach (var line in cleaned.Split('\n')) {
            if (line.Contains("USD")) {
                var parts = line.Split(' ');
                // ... 200 more lines of mixed logic
            }
        }
    }
}
```

### 17. **Poltergeist**
```csharp
class TempController {  // Only exists to call other objects
    public void DoWork() {
        new Validator().Validate();
        new Processor().Process();
        new Logger().Log();
    }
}
```

### 18. **Duplicate Abstraction**
```csharp
interface IDataReader { /* ... */ }
interface IDataLoader { /* ... */ }  // Same purpose as IDataReader
```

### 19. **Incomplete Abstraction**
```csharp
interface IShape {
    double GetArea();
    // Missing GetPerimeter() that all shapes should have
}
```

### 20. **Leaky Encapsulation**
```csharp
class Account {
    public decimal Balance { get; private set; }
    
    // Smell: Exposes internal state modification
    public void SetBalance(decimal amount) => Balance = amount;
}
```

Each example demonstrates:
1. The problematic code pattern
2. Why it's considered a design smell
3. Often includes a suggested solution direction

The smells cover:
- Inheritance issues
- Encapsulation problems
- Modularity violations
- Abstraction failures
- Code organization anti-patterns
- Object collaboration issues

