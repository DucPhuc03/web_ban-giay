package bt1.web_ban_giay.service;

import bt1.web_ban_giay.entity.User;
import bt1.web_ban_giay.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;
    public User createUser(User user) {
        String ps=passwordEncoder.encode(user.getPassword());
        user.setPassword(ps);
        return userRepository.save(user);
    }
}
