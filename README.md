# OrangeHRM Automation Project
![Selenium](https://img.shields.io/badge/Selenium-43B02A?logo=selenium&logoColor=white)
![TestNG](https://img.shields.io/badge/TestNG-%23D94A26?logo=testng&logoColor=white)
![Allure Report](https://img.shields.io/badge/Allure_Report-%23E40026?logo=allure)
![Java](https://img.shields.io/badge/Java-007396?logo=java&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?logo=apache-maven&logoColor=white)
![Git](https://img.shields.io/badge/Git-F05032?logo=git&logoColor=white)
![Faker](https://img.shields.io/badge/Fake%20Data-JavaFaker-blueviolet?style=flat&logo=databricks&logoColor=white)



This repository contains automated test scripts for the [OrangeHRM Open Source Demo](https://opensource-demo.orangehrmlive.com) application.  
The project follows a **Page Object Model (POM)** structure, integrates **TestNG** for test execution, and uses **Allure** for reporting.

---

## 📌 Project Overview
The automation framework validates multiple functional scenarios such as:
- Login
- Employee creation
- User creation and deletion
- Record count verification
- Reading test data dynamically from **JSON files**

---

## 🛠 Tools & Technologies
| Tool / Library         | Purpose |
|------------------------|---------|
| **Java**               | Programming language |
| **Selenium WebDriver** | Web automation |
| **TestNG**             | Test framework for structuring and running tests |
| **Maven**              | Dependency and build management |
| **Allure Reports**     | Test execution reporting |
| **Faker**              | Generating random test data |
| **JSON Simple / Gson** | Parsing JSON files for test data |
| **Page Object Model (POM)** | Framework design pattern for maintainability |

---
## ⚙️ Setup Instructions

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/AhmedNashaaat/Santechture_Task.git
cd Santechture_Task
```
---

### 2️⃣ Install Dependencies
```bash
mvn clean install

```
---
### 3️⃣ Configure Test Data
```bash
src/test/java/Data/UserData.json

```
---
### 4️⃣ Run the Tests
```bash
mvn test
```
---
## 📊 Generate Allure Report  
```bash
allure generate allure-results --clean -o allure-report  
allure open allure-report  
```
