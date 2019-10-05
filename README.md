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
            
> **MySql Database Implementation**

**Step 1 : Create Dependency**

    <!-- Add mySQL dependency -->
    <dependency>
        <groupId>mysql</groupId>
    	<artifactId>mysql-connector-java</artifactId>
    	<scope>runtime</scope>
    </dependency>
    
**Step 2 : application.properties**

    # Control the sql db initialization (from schema.sql and data.sql)
    spring.datasource.initialization-mode=always
    
    # Hibernate ddl auto (create, create-drop, validate, update)
    spring.jpa.hibernate.ddl-auto=none
    
    ## Spring DATASOURCE (DataSourceAutoConfiguration & DataSourceProperties)
    spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/testDb
    spring.datasource.username=root
    spring.datasource.password=root
    
**Step 3 : Create schema.sql and data.sql file in resources folder**

     # schema.sql
     
     CREATE TABLE `user` (
       `id` bigint(20) NOT NULL,
       `password` varchar(255) DEFAULT NULL,
       `username` varchar(255) DEFAULT NULL,
       PRIMARY KEY (`id`)
     );
     
     # data.sql
     insert into user(id,username,password) values(101,'Vikash', 'A1234567');
     insert into user(id,username,password) values(102,'Keshav', 'B1234568');

      
**Note :**
* Control the sql db initialization (from schema.sql and data.sql) or if we can want that disable Hibernate DDL generation because the schema will be generated from a sql script
  
        spring.datasource.initialization-mode=always  
* In mysql, if we are using schema.sql either we have to use 

      spring.jpa.hibernate.ddl-auto=none 
   or not use of the same line.
      
* schema.sql and data.sql file name is case sensitive.
* In a JPA-based app, you can choose to let Hibernate create the schema or use schema.sql, but you cannot do both. Make sure to disable 'spring.jpa.hibernate.ddl-auto' if you use schema.sql.
* import.sql file name can be use instead of data.sql, if we are using db initialization by hibernate.

> **Crud Operation Using Rest API**

**Step 1 : Add Dependency**
    
    <!-- Add Jpa dependency for use JpaRepository for DAO -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
    	<artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    
    Note : For testing purpose we can add any database dependency.

**Rest API Details**

    Controller : 'UserController'
        > Get     : '/api/users'
        > Get     : '/api/users/{userId}'
        > Post    : '/api/users'
                    Content-Type: application/json
                    {
    	                "username":"Raj1",
    	                "password" : "A123456"
                    }
        > Delete  : '/api/users/{userId}'
        > Delete  : '/api/users'