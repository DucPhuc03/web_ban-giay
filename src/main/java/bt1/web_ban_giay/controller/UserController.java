package bt1.web_ban_giay.controller;

import bt1.web_ban_giay.entity.User;
import bt1.web_ban_giay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/user/create")
    public ResponseEntity<User> createUser(@RequestBody User user){
        return ResponseEntity.ok(userService.createUser(user));
    }

    @PutMapping("/user/update")
    public ResponseEntity<Void> updateUser(@RequestBody User user){
        userService.updateUser(user);
        return ResponseEntity.ok(null);
    }
}
