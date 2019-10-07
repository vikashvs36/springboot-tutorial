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

    Branch : 'database/mysql_db'
    commit : 1 parent 3cdbae1 commit 6228a44c6a986229131c8ae1007cd0218635245d
    
> **MongoDb Database Implementation**

    Branch : 'database/mongo_db'
    commit : 1 parent 4242600 commit ab766431a7c4c1f4e94bbccdabc3cc4fbe79f85c
    
> **Flyway Database Migrations Tool**

**Step 1 : Add Dependency**

    <!-- Mysql dependancy to create or update table-->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <scope>runtime</scope>
    </dependency>
    
    <!--Flyway dependency (Database Migration Tool)-->
    <dependency>
        <groupId>org.flywaydb</groupId>
        <artifactId>flyway-core</artifactId>
    </dependency>
 
**Step 2 : Create Folder in "Resources"**

By default, **"V{VERION}__{NAME}.sql"** are in a folder called classpath:db/migration, but you can modify that location by setting **spring.flyway.locations**. This is a comma-separated list of one or more classpath: or filesystem: locations. For example, the following configuration would search for scripts in both the default classpath location and the /opt/migration directory:


    spring.flyway.locations=classpath:db/migration,filesystem:/opt/migration

**Step 3 : How to create table or insert data in Flyway file**

    -- Create a user table 
    CREATE TABLE `user` (
      `id` bigint(20) NOT NULL,
      `username` varchar(255) DEFAULT NULL,
      `password` varchar(255) DEFAULT NULL,
      PRIMARY KEY (`id`)
    );
    
    -- Insert two entry in user table
    insert into user(id,username,password) values(101,'Vikash', 'A1234567');
    insert into user(id,username,password) values(102,'Keshav', 'B1234568');

**Step 4 : Configure Flyway database in application.properties**

    # Hibernate ddl auto (create, create-drop, validate, update)
    #spring.jpa.hibernate.ddl-auto=none
    
    spring.datasource.url=jdbc:mysql://localhost:3306/testDb
    spring.datasource.username=root
    spring.datasource.password=root
    
    spring.flyway.enabled=true
    spring.flyway.locations=classpath:/db/migration
    
    Note: Make sure 'spring.jpa.hibernate.ddl-auto=none' or comment this line becouse we want to create or manage database by Fylyway.

**Note :** 
* Inside "db/migration" location file can be created in formate "V{VERSION}__{NAME}.sql"
* Because of Flyway works on version, don't need to add 'delete if exist commond' before create the table because Flyway migration tool doesn't create it if it created before.