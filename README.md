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

Spring Boot includes an additional set of tools that can make the application development experience a little more pleasant.

**Add Dependency**

    <!-- Devtools Dependency -->
    <dependency>
    	<groupId>org.springframework.boot</groupId>
   	    <artifactId>spring-boot-devtools</artifactId>
   		<optional>true</optional>
    </dependency>
    
By adding this dependency, It can be reflect the changes without restart the application.

**Note :** If your project not auto reload yet, you can check your IDE settings. Like if you are using intellij idea then 
go to "run/debug configuration" and change the settings as given below: 
running application update policy:
1. On update action      :  Update trigger file
2. On frame deactivation :  update classes and resources.
 
