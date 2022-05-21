package uz.isystem.kunuzclone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.isystem.kunuzclone.model.User;
import uz.isystem.kunuzclone.model.Usertype;
import uz.isystem.kunuzclone.service.UserTypeService;

import javax.persistence.criteria.CriteriaBuilder;

@RestController
@RequestMapping("user_type")
public class UserTypeController {
    @Autowired
    private UserTypeService userTypeService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Usertype usertype){
        Usertype result= userTypeService.create(usertype);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id){
        Usertype result =userTypeService.get(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id,
                                    @RequestBody Usertype usertype){
        Usertype result= userTypeService.update(id, usertype);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")Integer id){
        boolean result= userTypeService.delete(id);
        return ResponseEntity.ok(result);
    }
}
