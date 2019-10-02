# springboot-tutorial
This tutorial is for beginners and it's purpose to create that learn one by one from zero to hero.

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