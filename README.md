# Employee Management Application

A simple console-based application for managing employee data using Java and PostgreSQL.

## Features

- Add new employees to the database
- Fetch details of all employees
- Update employee details
- Delete employees from the database

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed
- PostgreSQL server running
- An IDE or text editor for coding

### Setup

1. **Clone the repository:**
   ```bash
   git clone https://github.com/yourusername/EmpManagementApp.git
   cd EmpManagementApp
   ```

2. **Create the `employees` table in PostgreSQL:**
   ```sql
   CREATE TABLE employees (
       id INT PRIMARY KEY,
       name VARCHAR(100),
       age INT
   );
   ```

3. **Update the database connection details in `Empservice.java`:**
   ```java
   private static final String URL = "jdbc:postgresql://localhost:5432/yourdbname?user=yourusername&password=yourpassword";
   ```

### Running the Application

1. **Compile the Java files:**
   ```bash
   javac -d bin src/com/empmanagement/service/Empservice.java src/empsmanagement/driver/Empdriver.java
   ```

2. **Run the application:**
   ```bash
   java -cp bin empsmanagement.driver.Empdriver
   ```

## Usage

- Follow the on-screen instructions to add, fetch, update, or delete employees.
- Select the appropriate option from the menu by entering the corresponding number.

