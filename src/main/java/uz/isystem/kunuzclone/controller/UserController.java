package uz.isystem.kunuzclone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.isystem.kunuzclone.model.User;
import uz.isystem.kunuzclone.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody User user) {
        User reslut = userService.create(user);
        return ResponseEntity.ok(reslut);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id) {
        User result = userService.get(id);
        return ResponseEntity.ok(result);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?>update(@PathVariable("id")Integer id,
                                   @RequestBody User user){
        User result=userService.update(id, user);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>delete(@PathVariable("id")Integer id){
        boolean result= userService.delete(id);
        return  ResponseEntity.ok(result);
    }

}
