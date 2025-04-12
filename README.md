# Survey Data Analyzer

![Java](https://img.shields.io/badge/Java-8+-blue.svg)
![License](https://img.shields.io/badge/License-MIT-green.svg)

This project is a Java-based application designed to analyze survey data related to life quality and demographic information. It features a custom hash table implementation to efficiently store and manage survey responses, enabling fast retrieval and comprehensive analysis. The project highlights proficiency in data structures, file I/O, object-oriented programming, and data analysis, making it a strong addition to a professional portfolio.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Installation and Setup](#installation-and-setup)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Features

- **Custom Hash Table Implementation**:
  - Uses integer keys (response IDs) and `Response` objects as values.
  - Implements linear probing for collision resolution.
  - Supports dynamic resizing based on a load factor of 0.5.
  - Provides methods for insertion, search, deletion, and printing the table.
- **Data Parsing**:
  - Reads tab-separated survey data from a file (`responses.txt`) and populates the hash table.
- **Demographic Analysis**:
  - Distributions for gender, age group, residence, education level, income source, marital status, and smoking status.
- **Life Quality Analysis**:
  - Calculates average life quality scores overall and segmented by demographic factors (e.g., gender, age, residence).
  - Analyzes life quality based on mixed conditions (e.g., marital status and residence) and specific survey responses.
- **Additional Insights**:
  - Identifies the most common treatments, symptoms, and affected life aspects using sorting algorithms.
- **Testing**:
  - Includes a test suite (`Tests.java`) to verify the accuracy of analysis methods against expected results.

## Technologies Used

- **Java**: Built with standard Java (JDK 8 or higher), leveraging its object-oriented capabilities and core libraries for file handling and data processing.

## Installation and Setup

Follow these steps to set up and run the project locally:

1. **Prerequisites**:
   - Install Java Development Kit (JDK) 8 or higher on your system.

2. **Clone the Repository**:
   ```bash
   git clone https://github.com/yourusername/survey-data-analyzer.git
   ```
3. **Navigate to the Project Directory**:
  ```bash
  cd survey-data-analyzer
  ```
4. **Prepare the Survey Data File**:
  - Place the `responses.txt` file in the `src` directory. This file should contain tab-separated survey responses (see `ReadFile.java` for the expected format).
5. **Compile the Java Files**:
  - Navigate to the `src` directory (if applicable):
  ```bash
  cd src
  ```
  - Compile all Java files:
  ```bash
  javac *.java
  ```
6. **Run the Application**:
   - Execute the `Tests` class to run the analysis and tests:
   ```bash
   java Tests
   ```

## Usage
- **Input**: The program reads survey data from `responses.txt` in the `src` directory. Each line represents a response with fields like ID, gender, age, and survey answers (tab-separated).
- **Output**: Running `java Tests` executes a suite of tests that invoke analysis methods and print results to the console, comparing them against expected values for validation.
- **Customization**: Modify `Tests.java` to explore different analyses or adapt `ReadFile.java` to handle alternative file formats or paths.

**Example Command**:
```bash
java Tests
```
This runs the predefined tests, displaying whether each analysis matches the expected output.

## Project Structure
- `CustomHashTable.java`:
  - Implements a hash table with linear probing and dynamic resizing.
  - Supports insertion, search, deletion, and printing of entries.
- `ReadFile.java`:
  - Reads and parses responses.txt, creating Response objects and inserting them into the hash table.
- `Response.java`:
  - Encapsulates a single survey response with demographic data and survey answers.
  - Computes a Quality score based on specific survey questions.
- `SurveyDataAnalyzer.java`:
 - Contains methods for demographic and life quality analysis, including distribution counts and averages.
 - Identifies common treatments, symptoms, and life aspects using insertion sort.
- `TestResponse.java`:
  - A simple test class to demonstrate Response object creation and printing.
- `Tests.java`:
-   Main entry point with a test suite to validate analysis methods against expected results.

## License
This project is licensed under the MIT License.

## Contact
For inquiries or further discussion, reach out to me at `akiliu1116@gmail.com`
