package uz.isystem.kunuzclone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.isystem.kunuzclone.model.Post;
import uz.isystem.kunuzclone.service.PostService;

import java.util.List;

@RestController
@RequestMapping("post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Post post) {
        Post result = postService.create(post);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id) {
        Post result = postService.get(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id,
                                    @RequestBody Post post) {
        Post result = postService.update(id, post);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        boolean result = postService.delete(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/addView/{id}")
    public ResponseEntity<?> addView(@PathVariable("id") Integer id) {
        Boolean result = postService.addView(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/publishData/{id}")
    public ResponseEntity<?> publishData(@PathVariable("id") Integer id) {
        Boolean result = postService.publishDate(id);
        return ResponseEntity.ok(result);

    }

    @GetMapping("/getByCategory/{id}")
    public ResponseEntity<?> getByCategory(@PathVariable("id") Integer id) {
        List<Post> result = postService.getByCategory(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getByRegion/{id}")
    public ResponseEntity<?> getByRegion(@PathVariable("id") Integer id) {
        List<Post> result = postService.getByRegion(id);
        return ResponseEntity.ok(result);
    }
}
