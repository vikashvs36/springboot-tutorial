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

**Step 1 : Create Dependency**

    <!-- Mongodb Dependency -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
    	<artifactId>spring-boot-starter-data-mongodb</artifactId>
    </dependency>
    
    Note : Make sure there is no need to Jpa dependency if exist in pom.xml, imediatly commented it.
   
**Step 2 : application.properties**

    spring.data.mongodb.uri=mongodb://localhost:27017/test
    
    Note : 'test' db by default present into mongo db.
    

**Step 3 : Domain Class**

* Table should annotated with @Document.
* Id should annotated with @Id and It would be String type.

      Example : 
      
      @Document
      public class User {
        @Id
        private String id;
        private String username;
        private String password;
      
        // Setter, getter and toString() method. 
      }
      
**Step 4 : Repository Class**

MongoRepository interface will be extended into UserDao interface and pass two argument 
first one is domain class type and second one is for id which is String type.

    @Repository
    public interface UserDao extends MongoRepository<User, String> {
    }
    
**Note :** By default mongodb port is 27017.
