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
    
## Spring Data

### Redis
Redis is popular in-memory data structure store. Redis is driven by a keystore-based data structure to persist data and 
can be used as a database, cache, message broker, etc.

**Step to implement Redis**

* **Install Into System or Server**

      1. Download the redis from redis.io/download
      2. How to run the redis server
        a. /opt/redis-5.0.5$ make
        b. :$ cd /opt/redis-5.0.5/src
        c. :$ redis-server
      3. How to use redis client
        a. :$ cd /opt/redis-5.0.5/src
        b. :$ ./redis-cli
        c. 127.0.0.1:6379> ping 
        
*  **Add Dependencies**

       <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-redis</artifactId>
       </dependency>
       
* **Java Configuration**

      @Bean
      JedisConnectionFactory jedisConnectionFactory() {
          return new JedisConnectionFactory();
      }
       
      @Bean
      public RedisTemplate<Object, Object> redisTemplate() {
          RedisTemplate<Object, Object> template = new RedisTemplate<>();
          template.setConnectionFactory(jedisConnectionFactory());
          return template;
      }
      
* **RedisTemplate**

    @Repository
    public class UserDaoImpl {
    
        private RedisTemplate<Object, Object> redisTemplate;
    
        private HashOperations hashOperations;
    
        private final String KEY = "USER";
    
        public UserDaoImpl(RedisTemplate<Object, Object> redisTemplate) {
            this.redisTemplate = redisTemplate;
            this.hashOperations = redisTemplate.opsForHash();
        }

        public void save(User user) {
            hashOperations.put(KEY, user.getId(), user);
        }
    
        public Map<String, User> findAll() {
            return hashOperations.entries(KEY);
        }
    
        public User findById(String id) {
            return  hashOperations.get(KEY, id) ;
        }
    
        public void update(User user) {
            save(user);
        }
    
        public void delete(String id) {
            hashOperations.delete(KEY, id);
        }
    }
    
**Note :** Domain should be implemented to the Serializable interface.  

### Redis Cache

**Step required to implement Redis Cache using Redis Server as backend**

* **Add Dependency**

      Add spring-boot-starter-data-redis dependency given as above.
      
* **application.properties**

      spring.cache.type=redis
      spring.redis.host=localhost
      spring.redis.port=6379
      
      # If you don't need to store nullable cache. 
      spring.cache.redis.cache-null-values=false
      # Set the cache time to live
      spring.cache.redis.time-to-live=600000
      # By default "cacheName::key" is entries, If you don't need to use prefix
      spring.cache.redis.use-key-prefix=false
      
* **Redis Cache implementation**

      @RestController
      @EnableCaching
      @RequestMapping("/api")
      public class UserController { 
      
              @CachePut(value="itemCache",key = "#item")
              @PostMapping(value = "/item")
                  public void addItem(Item item) { }
                    
              @Cacheable(value="itemCache", key="#id")
              @GetMapping(value = "/item/{id}")
                  public Item getItem(int id) { }
                  
              @CachePut(value="itemCache",key = "#item",condition = "#result != null")
              @PutMapping("/items/{item}")
                  public void updateItem(Item item) { }
                  
              @CacheEvict(value="itemCache",key = "#id")
              @DeleteMapping("/item/{id}")
                  public void deleteItem(int id) { }        
      }
            
          
