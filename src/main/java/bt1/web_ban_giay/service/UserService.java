package bt1.web_ban_giay.service;

import bt1.web_ban_giay.entity.User;
import bt1.web_ban_giay.exception.InvalidException;
import bt1.web_ban_giay.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;
    public User createUser(User user) {
        Boolean checkUser=userRepository.existsByUsername(user.getUsername());
        if(checkUser){
            throw new InvalidException("tai khoan da ton tai");
        }
        String ps=passwordEncoder.encode(user.getPassword());
        user.setPassword(ps);
        return userRepository.save(user);
    }
    public void updateUser(User user){
        Optional<User> userOptional=userRepository.findById(user.getId());
        User userDB=userOptional.get();
        userDB.setUsername(user.getUsername());
        userDB.setPhone(user.getPhone());
        userDB.setAddress(user.getAddress());
         userRepository.save(userDB);
    }
}
