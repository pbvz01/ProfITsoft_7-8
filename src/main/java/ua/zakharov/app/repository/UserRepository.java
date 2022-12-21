package ua.zakharov.app.repository;

import org.springframework.stereotype.Repository;
import ua.zakharov.app.model.User;
import ua.zakharov.app.repository.common.CommonRepository;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserRepository implements CommonRepository<User> {
    private final static AtomicLong ID_COUNTER = new AtomicLong(1);
    private final Map<Long,User> userData = new ConcurrentHashMap<>();

     {
        for(int i = 0; i < 5; i++) {
            User user = new User(ID_COUNTER.get(), "SomeLogin", "SomePassword", "SomeName");
            userData.put(user.getId(), user);
            ID_COUNTER.addAndGet(1);
        }
    }

    @Override
    public User save(User model) {

         if (model.getId() != null) {
             User user = userData.get(model.getId());
             user.setName(model.getName());
             user.setUsername(model.getUsername());
             user.setPassword(model.getPassword());
             return userData.get(user.getId());
         }
         model.setId(ID_COUNTER.get());
         ID_COUNTER.addAndGet(1);
        return userData.put(model.getId(), model);
    }

    @Override
    public Iterable<User> findAll() {
        return userData.values();
    }

    @Override
    public User findById(Long id) {
        return userData.get(id);
    }

    @Override
    public User findByLogin(String login) {
        return userData.values().stream()
                .filter(user -> user.getUsername().equals(login))
                .findFirst().orElse(null);
    }

    @Override
    public User findByLoginAndPassword(String login, String password) {
        return userData.values().stream()
                .filter(user -> user.getUsername().equals(login) &&
                        user.getPassword().equals(password))
                .findFirst().orElse(null);
    }
}
