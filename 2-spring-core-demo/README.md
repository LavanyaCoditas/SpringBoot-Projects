# Spring Container

**Primary Functions**
- Create and manage objects (IoC)
- Inject object's dependencies (DI)

**Injection Types**
- Constructor injection
    - Use this when you have required dependencies
    - Generally recommended by the spring.io dev team as first choice
- Setter Injection
    - Use this when you have optional dependencies
    - If dependency is not provided, your app can provide reasonable default logic
- Field Injection(not recommended)

**AutoWiring**
- For DI, Spring can use autowiring
- Spring will look for a class that matches
    - matches by type: class or interface
- Spring will inject it automatically ... hence it is autowired
- Example
    - Injecting a Coach implementation
    - Spring will scan for @Components
    - Any one implements the Coach interface
    - If so, let's inject them. For eg, CricketCoach

**Component Scanning**

*Annotations*
- @SpringBootApplication is composed of the following annotations
  - @EnableAutoConfiguration: 
    - Enables Spring Boot's auto-configuration support
  - @ComponentScan: 
    - Enables component scanning of current package
    - Also, recursively scans sub-packages
  - @Configuration:
    - Able to register extra beans with @Bean 
    - or Import other configuration classes

*More on Component Scanning*
- By default, Spring Boot starts component scanning
  - From same packages as your main Spring Boot application
  - Also scans sub-packages recursively
- This implicitly defines a base package 
  - Allows to leverage default component scanning
  - No need to explicitly reference the base package name
- Default Scanning is fine if everything is under our base package("com.example.spring_core_demo")
- But what about other packages 
  - Use this @SpringBootApplication(scanBasePackages={"com.example.spring_core_demo", "com.example.util", ... "other packages"})

**@Primary and @Qualifier**
- @Primary 
  - leaves it up to the implementation classes
  - could have the issue of multiple @Primary classes leading to an error
- @Qualifier
  - allows to you be very specific on which bean you want 
- In general, @Qualifier is recommended
  - more specific
  - higher priority