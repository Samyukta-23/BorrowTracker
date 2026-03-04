package com.example.BorrowTracker.Controller;

import com.example.BorrowTracker.Entity.BorrowTrackerEntity;
import com.example.BorrowTracker.Service.BorrowTrackerService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/borrow")
@CrossOrigin(origins = "http://localhost:3000")
public class BorrowTrackerController{
    private final BorrowTrackerService service;
    public BorrowTrackerController(BorrowTrackerService service){
        this.service=service;
    }

    @PostMapping
    public BorrowTrackerEntity save(@RequestBody BorrowTrackerEntity data){
        return service.save(data);
    }
    @GetMapping
    public List<BorrowTrackerEntity> getAll(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public BorrowTrackerEntity getById(@PathVariable Long id) {
        return service.getById(id).orElseThrow();
    }
    @GetMapping("/name/{name}")
    public List<BorrowTrackerEntity> getByName(@PathVariable String name){
        return service.getByName(name);
    }
    @PutMapping("/{id}")
    public BorrowTrackerEntity update(@PathVariable Long id,@RequestBody BorrowTrackerEntity data){
        return service.update(id, data);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}