# Architecture Document: SWRPG Sheet Manager

## 1. Overview
This document defines the high-level architecture for the SWRPG Sheet Manager application. The primary goal is to create a clean, scalable, and maintainable codebase for a multiplatform application targeting Android, Windows, and Linux.

## 2. Architectural Pattern: Model-View-ViewModel (MVVM)
We will use the **MVVM (Model-View-ViewModel)** pattern. This pattern separates the application's logic into three interconnected components:

- **Model:** Represents the data and business logic of the application. This includes data classes for characters, vehicles, skills, talents, and the logic for dice rolls and character state calculations. The Model is completely UI-agnostic.
- **View:** The UI layer of the application, built with Compose Multiplatform. The View is responsible for displaying the data from the ViewModel and forwarding user interactions to it. It remains "dumb," meaning it doesn't contain any business logic.
- **ViewModel:** Acts as a bridge between the Model and the View. It holds the UI state, fetches data from the Model, formats it for display, and exposes it to the View. It also handles user input from the View and executes the corresponding business logic in the Model.

This separation of concerns makes the code easier to test, debug, and scale.

## 3. Project Structure (Modules)
The project will follow the standard Compose Multiplatform structure:

- `commonMain`: This is the core module where the vast majority of the code will live.
    - **Data Models:** Kotlin data classes for `Character`, `Vehicle`, `Weapon`, etc.
    - **ViewModels:** The logic for each screen (e.g., `CharacterSheetViewModel`, `DiceRollerViewModel`).
    - **Business Logic:** Dice cancellation logic, character stat calculators.
    - **UI (Composables):** All shared UI screens and components will be defined here.
    - **Data Persistence:** A common interface for database operations.

- `androidMain`: Contains Android-specific code.
    - The main `Activity` that hosts the Compose UI.
    - Platform-specific implementations (e.g., file system access if needed).
    - The actual implementation of the database (e.g., the Android driver for SQLDelight).

- `desktopMain`: Contains desktop-specific (Windows, Linux) code.
    - The main `main` function to create the application window.
    - Desktop-specific database driver implementation.

## 4. Data Persistence
For local data storage, we will use **SQLDelight**.

- **Why SQLDelight?** It's a multiplatform library that generates type-safe Kotlin APIs from SQL statements. This allows us to write our database schema and queries once in `commonMain` and use them across Android and desktop with full compile-time safety.

- **Implementation:**
    1. Define `.sq` schema files in `commonMain` to describe the tables for characters, vehicles, inventory, etc.
    2. Write named SQL queries in the `.sq` files for all CRUD (Create, Read, Update, Delete) operations.
    3. SQLDelight will auto-generate Kotlin classes and functions for these queries.
    4. Implement platform-specific database drivers in `androidMain` and `desktopMain`.
    5. A `Repository` class in `commonMain` will use these generated functions to provide a clean data access API to the ViewModels.

## 5. Dependency Injection
To manage dependencies and further decouple components, a lightweight dependency injection library like **Koin** will be considered. It works well in Kotlin Multiplatform projects and can help manage the lifecycle of ViewModels and Repositories.

## 6. Diagram: High-Level Flow
```
+----------------+      +-----------------+      +----------------+
|      View      |      |    ViewModel    |      |      Model     |
|  (Compose UI)  |<---->|  (UI State &   |<---->| (Business Logic|
|                |      |   Logic)        |      | & Data Classes)|
+----------------+      +-----------------+      +----------------+
       ^                      ^                      ^
       |                      |                      |
       |                      |                      |
+------+----------------------+----------------------+------+
|                 commonMain (Shared Code)                   |
+------------------------------------------------------------+
       ^                                      ^
       |                                      |
+------+------+                        +-------+-------+
| androidMain |                        |  desktopMain  |
+-------------+                        +---------------+
```
