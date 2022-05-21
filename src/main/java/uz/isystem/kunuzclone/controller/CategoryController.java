package uz.isystem.kunuzclone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.isystem.kunuzclone.model.Category;
import uz.isystem.kunuzclone.service.CategoryService;

@RestController
@RequestMapping("categore")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Category category){
        Category result= categoryService.create(category);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id){
        Category result= categoryService.get(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?>update(@PathVariable("id") Integer id,
                                   @RequestBody Category category){
        Category result=categoryService.update(id, category);
        return ResponseEntity.ok(result);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?>delete(@PathVariable("id")Integer id){
        boolean result =categoryService.delete(id);
        return ResponseEntity.ok(result);
    }

}
