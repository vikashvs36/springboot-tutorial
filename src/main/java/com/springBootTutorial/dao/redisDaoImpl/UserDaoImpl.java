package com.springBootTutorial.dao.redisDaoImpl;

import com.springBootTutorial.dao.UserDao;
import com.springBootTutorial.domain.User;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {

    private RedisTemplate<Object, Object> redisTemplate;

    private HashOperations hashOperations;

    private final String KEY = "USER";

    public UserDaoImpl(RedisTemplate<Object, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(User user) {
        hashOperations.put(KEY, user.getId(), user);
    }

    @Override
    public Map<String, User> findAll() {
        return hashOperations.entries(KEY);
    }

    @Override
    public User findById(String id) {
        Object user = hashOperations.get(KEY, id);
        return user != null ? (User) user : null ;
    }

    @Override
    public void update(User user) {
        save(user);
    }

    @Override
    public void delete(String id) {
        hashOperations.delete(KEY, id);
    }
}
