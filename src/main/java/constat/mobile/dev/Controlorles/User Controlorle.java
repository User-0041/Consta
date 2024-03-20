package constat.mobile.dev.Controlorles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import constat.mobile.dev.Entitys.Chouffeur;
import constat.mobile.dev.Entitys.Constat;
import constat.mobile.dev.Repositorys.UserController;
import constat.mobile.dev.Repositorys.ConstatReporsitory;


@RestController
@RequestMapping("/user")
public class UserControlorle {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User Controlorle> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User Controlorle getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + id));
    }

    @PostMapping
    public UserControlorle createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public UserControlorle updateUser(@PathVariable Long id, @RequestBody User user) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + id));
        existingUser.setName(user.getName());
        return userRepository.save(existingUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

}
