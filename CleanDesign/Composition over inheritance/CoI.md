Let’s compare two approaches for implementing an `EmployeeRepository` class that interacts with a database:

1. **Inheritance Approach:** The `EmployeeRepository` class inherits from a `SQLDatabase` class.
2. **Composition Approach:** The `EmployeeRepository` class contains an instance of a `SQLDatabase` class.

We’ll analyze both approaches and highlight why **composition is generally preferred**.

---

### **Scenario:**
We want to create an `EmployeeRepository` class that interacts with a SQL database to perform CRUD (Create, Read, Update, Delete) operations for employees.

---

### **1. Inheritance Approach (Not Recommended):**
```python
class SQLDatabase:
    def connect(self):
        return "Connected to SQL database."

    def execute_query(self, query):
        return f"Executed query: {query}"

# EmployeeRepository inherits from SQLDatabase
class EmployeeRepository(SQLDatabase):
    def get_employee(self, employee_id):
        query = f"SELECT * FROM employees WHERE id = {employee_id}"
        return self.execute_query(query)

    def add_employee(self, name, position):
        query = f"INSERT INTO employees (name, position) VALUES ('{name}', '{position}')"
        return self.execute_query(query)

# Usage
repo = EmployeeRepository()
print(repo.connect())  # Output: Connected to SQL database.
print(repo.get_employee(1))  # Output: Executed query: SELECT * FROM employees WHERE id = 1
print(repo.add_employee("Alice", "Developer"))  # Output: Executed query: INSERT INTO employees (name, position) VALUES ('Alice', 'Developer')
```

**Problems with Inheritance:**
1. **Tight Coupling:** `EmployeeRepository` is tightly coupled to `SQLDatabase`. If you want to switch to a different database (e.g., NoSQL), you’ll need to rewrite the `EmployeeRepository` class.
2. **Violates Single Responsibility Principle:** `EmployeeRepository` is responsible for both employee-related logic and database operations.
3. **Inflexibility:** You cannot easily reuse the `EmployeeRepository` logic with a different database implementation.

---

### **2. Composition Approach (Recommended):**
```python
class SQLDatabase:
    def connect(self):
        return "Connected to SQL database."

    def execute_query(self, query):
        return f"Executed query: {query}"

# EmployeeRepository contains an instance of SQLDatabase
class EmployeeRepository:
    def __init__(self, database):
        self.database = database

    def get_employee(self, employee_id):
        query = f"SELECT * FROM employees WHERE id = {employee_id}"
        return self.database.execute_query(query)

    def add_employee(self, name, position):
        query = f"INSERT INTO employees (name, position) VALUES ('{name}', '{position}')"
        return self.database.execute_query(query)

# Usage
sql_db = SQLDatabase()
repo = EmployeeRepository(sql_db)

print(repo.database.connect())  # Output: Connected to SQL database.
print(repo.get_employee(1))  # Output: Executed query: SELECT * FROM employees WHERE id = 1
print(repo.add_employee("Alice", "Developer"))  # Output: Executed query: INSERT INTO employees (name, position) VALUES ('Alice', 'Developer')
```

---

### **Advantages of Composition:**
1. **Loose Coupling:** `EmployeeRepository` is not tied to a specific database implementation. You can easily switch to a different database (e.g., NoSQL) by passing a different database object.
2. **Single Responsibility Principle:** `EmployeeRepository` is only responsible for employee-related logic, while the database operations are delegated to the `SQLDatabase` class.
3. **Reusability:** You can reuse the `EmployeeRepository` class with different database implementations.
4. **Testability:** You can easily mock the `SQLDatabase` class for unit testing.

---

### **Switching to a Different Database (Flexibility Example):**
Suppose you want to switch to a NoSQL database. With composition, you can do this without modifying the `EmployeeRepository` class:

```python
class NoSQLDatabase:
    def connect(self):
        return "Connected to NoSQL database."

    def execute_query(self, query):
        return f"Executed NoSQL query: {query}"

# Usage with NoSQL
nosql_db = NoSQLDatabase()
repo = EmployeeRepository(nosql_db)

print(repo.database.connect())  # Output: Connected to NoSQL database.
print(repo.get_employee(1))  # Output: Executed NoSQL query: SELECT * FROM employees WHERE id = 1
print(repo.add_employee("Alice", "Developer"))  # Output: Executed NoSQL query: INSERT INTO employees (name, position) VALUES ('Alice', 'Developer')
```

---

### **Key Takeaway:**
- **Inheritance Approach:** Tightly couples `EmployeeRepository` to `SQLDatabase`, making it inflexible and harder to maintain.
- **Composition Approach:** Decouples `EmployeeRepository` from the database implementation, making it more flexible, reusable, and maintainable.

**Use composition when:**
- You want to avoid tight coupling.
- You want to adhere to the **Single Responsibility Principle**.
- You need flexibility to switch implementations (e.g., different databases).

This example demonstrates why composition is generally preferred over inheritance, even when there is a clear "is-a" relationship.