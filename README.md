# springboot-tutorial
This tutorial is for beginners and it's purpose to create that learn one by one from zero to hero.


> **Crud Operation Using Rest API**

    Branch : 'operation/crud' 
    Commit : 1 parent 2658880 commit 081860a8ce8c56fdf92cb6e0b9f33feffa07d1ef 
    
> **H2 Database Implementation**

    Branch : 'database/h2_db'
    Commit : 1 parent 2658880 commit c0d3430c4f772be2fb6f9b3f760607f9b60f455a,
             2 parents c0d3430 + 081860a commit 32796154a1a29eae7873cf935a5214650a0be6d9
             
> **Execute Liquibase Database Migrations on Startup**

     Branch : 'database/liquibase'
     Commit : 1 parent e3763a9 commit dea58a43977b4802f3b2072aa5ba4af4f52cdca2
              2 parents dea58a4 + 081860a commit 1f4fd54066cb543eb195d0c0ed126be9f8dfbb57
              
> **Flyway Database Migrations Tool**
    
    Branch : 'database/flyway'
    Commit : 1 parent 3796626 commit 2569dac4d86c4951b784285872c46447212cdb6b
              
> **MySql Database Implementation**

    Branch : 'database/mysql_db'
    commit : 1 parent 3cdbae1 commit 6228a44c6a986229131c8ae1007cd0218635245d
    
> **MongoDb Database Implementation**

    Branch : 'database/mongo_db'
    commit : 1 parent 4242600 commit ab766431a7c4c1f4e94bbccdabc3cc4fbe79f85c
    
> **Developer Tools**

    Branch : 'dependency/devtool'
    Commit : 'Implement Devtools Dependency'
    1 parent 89ca782 commit 29fc9251da4168eeab1bb3520e6a70e104fb0be1
    
> **Log Format**

By default, if you use the “Starters”, Logback is used for logging. Appropriate Logback routing is also included to ensure that dependent libraries that use Java Util Logging, Commons Logging, Log4J, or SLF4J all work correctly.

The default log output from Spring Boot resembles the following example:

    2019-03-05 10:57:51.112  INFO 45469 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet Engine: Apache Tomcat/7.0.52
    2019-03-05 10:57:51.253  INFO 45469 --- [ost-startStop-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
    
The following items are output:

* Date and Time: Millisecond precision and easily sortable.
* Log Level: ERROR, WARN, INFO, DEBUG, or TRACE.
* Process ID.
* A --- separator to distinguish the start of actual log messages.
* Thread name: Enclosed in square brackets (may be truncated for console output).
* Logger name: This is usually the source class name (often abbreviated).
* The log message.

