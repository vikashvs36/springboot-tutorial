# springboot-tutorial
This tutorial is for beginners and it's purpose to create that learn one by one from zero to hero.


> **Crud Operation Using Rest API**

    Branch : 'operation/crud' 
    Commit : 1 parent 2658880 commit 081860a8ce8c56fdf92cb6e0b9f33feffa07d1ef 
    
> ** H2 Database Implementation **

    Branch : 'database/h2_db'
    Commit : 1 parent 2658880 commit c0d3430c4f772be2fb6f9b3f760607f9b60f455a,
             2 parents c0d3430 + 081860a commit 32796154a1a29eae7873cf935a5214650a0be6d9
     
> **Execute Liquibase Database Migrations on Startup**

**Step 1 : Add Dependency**

    <!-- data-Jpa dependancy for crud operation-->        
    <dependency>
    	<groupId>org.springframework.boot</groupId>
    	<artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    
    <!-- Mysql dependancy to create or update table-->
    <dependency>
    	<groupId>mysql</groupId>
    	<artifactId>mysql-connector-java</artifactId>
    	<scope>runtime</scope>
    </dependency>
    
    <!--Liquibase dependency (Database Migration Tool) referance  -->
    <dependency>
        <groupId>org.liquibase</groupId>
       	<artifactId>liquibase-core</artifactId>
    </dependency>
    
**Step 2 : Create Folder in "Resources"**

By default, the master change log is read from db/changelog/db.changelog-master.yaml, but you can change the location by 
setting spring.liquibase.change-log. In addition to YAML, Liquibase also supports JSON, XML, and SQL change log formats.

    Created a file db.changelog-master.xml in db/changelog folder
    Example : "db/changelog/db.changelog-master.xml"

    We can create multiple xml file and put reference into master.xml
    Created a file db.changelog-1.0.xml in db/changelog folder and refrence into db.changelog-master.xml.
    Exmple : "db/changelog/db.changelog-1.0.xml"


**Step 3 : Configure mysql and liquibase database**

    
    # Hibernate ddl auto (create, create-drop, validate, update)
    spring.jpa.hibernate.ddl-auto=none
    # Spring DATASOURCE (DataSourceAutoConfiguration & DataSourceProperties)
    spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/testDb
    spring.datasource.username=root
    spring.datasource.password=root

    # show sql log
    spring.jpa.show-sql=true

    # liquibase change log
    spring.liquibase.change-log=classpath:db/changelog/db.changelog-master.xml
    
> ***How to create or insert table in liquibase file*** 

    <!-- Create Table -->
    <changeSet id="1" author="Vikash">
        <createTable tableName="user">
            <column autoIncrement="true" name="id" type="int">
                <constraints primaryKey="true"/>
            </column>
            <column name="username" type="VARCHAR(255)"/>
            <column name="password" type="VARCHAR(255)"/>
        </createTable>
    </changeSet>
    
    <!-- Create Index -->
    <changeSet id="2" author="Vikash">
        <createIndex tableName="user" indexName="USERNAME_INDEX">
            <column name="username"></column>
        </createIndex>
    </changeSet>
    
    <!-- Insert Table -->
    <changeSet id="3" author="vikash">
        <insert tableName="user">
            <column name="username" value="Vikash" />
            <column name="password" value="P12345" />
        </insert>
    </changeSet>
    
> **Note :** Make sure 'spring.jpa.hibernate.ddl-auto=none' because table should be created by liquibase not by JPA.
    	    
**Reference :**  "https://docs.spring.io/spring-boot/docs/current/reference/html/howto-database-initialization.html#howto-execute-liquibase-database-migrations-on-startup"

    