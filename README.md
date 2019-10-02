# springboot-tutorial
This tutorial is for beginners and it's purpose to create that learn one by one from zero to hero.

> **H2 Database Implementation**

**Step 1 : Add Dependency**

    <!-- H2 Database dependency -->
    <dependency>
        <groupId>com.h2database</groupId>
    	<artifactId>h2</artifactId>
    	<scope>runtime</scope>
    </dependency>
    
    <!-- JPA dependency -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
       	<artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    
**Step 2 : application.properties**

    # Configure H2 database
    spring.datasource.url=jdbc:h2:mem:testdb
    spring.datasource.driverClassName=org.h2.Driver
    spring.datasource.username=sa
    spring.datasource.password=
    spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
