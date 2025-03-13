# User Story: Dynamic Price Computation Service  

## Title: Dynamic Price Computation for E-commerce Products  

### As a  
Product Manager of an E-commerce Platform  

### I want  
to have a **Dynamic Price Computation Service** that calculates the **quality** and **cost per unit** of different product types based on predefined rules and external conditions.  

### So that  
I can ensure accurate, competitive, and dynamic pricing for products, reflecting their quality and market conditions in real-time.  

---

## Acceptance Criteria  

### 1. Product Identification & Categorization  
- Each product type is uniquely identified by a **Product Type ID**.  
- The system must retrieve and categorize products based on their Product Type ID.  

### 2. Quality Computation  
- Each product type has a **Quality Function** with a value range between **0 and 50**.  
- The **Quality Function rules** are static and depend **only on the product type**.  
- The system must calculate the quality score of a product based on its type.  

### 3. Cost Per Unit Computation  
- Each product type has a **Cost Per Unit Function** (value > 0 USD).  
- The **cost computation rules** depend on:  
  - The **product type**  
  - **External conditions** (e.g., demand, supplier costs, market fluctuations, etc.)  
- The system should **dynamically update the cost** based on changing external conditions.  

### 4. Dynamic Rule Management  
- The system must allow **dynamic rule updates** for cost per unit computation.  
- The **rules engine** should support modifications without requiring changes to the core application logic.  
- The system must apply the latest rules in real-time or scheduled intervals.  


