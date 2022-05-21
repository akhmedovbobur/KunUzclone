package uz.isystem.kunuzclone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.isystem.kunuzclone.model.Region;
import uz.isystem.kunuzclone.model.User;
import uz.isystem.kunuzclone.service.RegionService;

@RestController
@RequestMapping("regions")
public class RegionController {
    @Autowired
    private RegionService regionService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Region region){
        Region result=regionService.create(region);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id) {
        Region result = regionService.get(id);
        return ResponseEntity.ok(result);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?>update(@PathVariable("id")Integer id,
                                   @RequestBody Region region){
        Region result=regionService.update(id, region);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>delete(@PathVariable("id")Integer id){
        boolean result= regionService.delete(id);
        return  ResponseEntity.ok(result);
    }
}
