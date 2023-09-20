# hexagonal-architecture
# Service Architecture

The service follows a Hexagonal Architecture design pattern in a Spring Boot framework, organized into three distinct modules:

1. **Domain Module**:
    - This module exclusively houses the core business logic.
    - It avoids incorporating any technical dependencies, ensuring a clean and untangled domain layer.
    - It includes business classes, service methods, and outlines of repositories, without their actual implementations.
2. **Infrastructure Module**:
    - The Infrastructure Module is dedicated to managing all technological dependencies.
    - It encompasses APIs, controllers, validation logic, and the implementation of domain blueprints such as repositories.
    - This module is responsible for integrating technical components with the domain's business logic.
3. **Bootstrap Module**:
    - The Bootstrap Module serves as the application's startup and configuration layer.
    - It encompasses the creation of beans and configuration files for the domain module.
    - The MainApplication.kt file within this module serves as the entry point for the entire application.
    - It also manages configuration files like application.yml for configuring the Spring application.

The project is structured as a multimodule project, with each module having its own pom.xml.

This modular approach facilitates separation of concerns and maintainability, making it easier to manage different aspects of the application independently.

In summary, this service is designed with a clear separation of concerns, where the domain module encapsulates the core business logic, the infrastructure module handles technical dependencies, and the bootstrap module manages application startup and configuration. This modular approach enhances maintainability and ensures that the domain logic remains clean and free from unnecessary technical clutter.
