package ua.zakharov.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.zakharov.app.model.User;
import ua.zakharov.app.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(Long id) {
        return userRepository.findById(id);
    }

}
