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
    
    
# AOP (Aspect Oriented Programming) with Spring

> **Add Dependency**

    <!-- Spring Aop -->
    <dependency>
        <groupId>org.springframework</groupId>
    	<artifactId>spring-aop</artifactId>
    </dependency> 
    
    <!-- H2 Database (Optional)-->
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>
    
 > **PointCut**

An example will help make this distinction between a pointcut signature and a pointcut expression clear. The following 
example defines a pointcut named 'serviceLayer' that will match the execution of any method named 'updateAccountBalance':

     // Example 1 :
     @Pointcut("execution(* updateAccountBalance(..))")// the pointcut expression
     private void serviceLayer() {}// the pointcut signature
    
     // Example 2 :
     @Aspect
     public class PointcutDefinition {
       @Pointcut("within(com.springBootTutorial.service..*)")
       public void serviceLayer() { }
     }
     
* execution - for matching method execution join points, this is the primary pointcut designator you will use when working with Spring AOP
* within - limits matching to join points within certain types (simply the execution of a method declared within a matching type when using Spring AOP)     
* target - limits matching to join points (the execution of methods when using Spring AOP) where the target object 
(application object being proxied) is an instance of the given type
* args - limits matching to join points (the execution of methods when using Spring AOP) where the arguments are instances of the given types
* @annotation - limits matching to join points where the subject of the join point (method being executed in Spring AOP) has the given annotation

**Note :**
* In the @AspectJ annotation-style of AOP, a pointcut signature is provided by a regular method definition, and the pointcut 
  expression is indicated using the @Pointcut annotation (the method serving as the pointcut signature must have a void return type).
    
* Pointcut expressions can be combined using '&&', '||' and '!'. It is also possible to refer to pointcut expressions by name.

> **Difference between Within and Excution**

**Execution** matches a method and **Within** matches a type.

    @Pointcut("execution(* updateAccountBalance(..))")// the pointcut expression
    private void serviceLayer() {}// the pointcut signature
    
    @Pointcut("within(com.springBootTutorial.service..*)")
    public void serviceLayer() { }

**Note :** In my point of view if we are using acecution then pointcut will be optional. 
    
> **@Before Advice**

    @Before(value = "com.springBootTutorial.aop.pointcut.PointcutDefinition.serviceLayer()")
    public void beforeAccountMethodExecution() {
        System.out.println("Before Logging Account Access.");
    }
    
> **@After Advice**

After advice must be prepared to handle both normal and exception return conditions.

    @After("com.springBootTutorial.aop.pointcut.PointcutDefinition.serviceLayer()")
    public void afterAccountMethodExecution() {
        System.out.println("After Logging Account Access.");
    }
    
**Note :** It is mandatry to annotate with **@Aspect** and **@Component** in that class where we will use **@Before** and **@After** advice