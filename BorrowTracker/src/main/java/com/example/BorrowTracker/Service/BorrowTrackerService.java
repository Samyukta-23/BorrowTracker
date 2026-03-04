package com.example.BorrowTracker.Service;

import com.example.BorrowTracker.Entity.BorrowTrackerEntity;
import com.example.BorrowTracker.Repository.BorrowTrackerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowTrackerService{
    private final BorrowTrackerRepository repo;
    public BorrowTrackerService(BorrowTrackerRepository repo){
        this.repo=repo;
    }
    public BorrowTrackerEntity save(BorrowTrackerEntity data){
        return repo.save(data);
    }
    public List<BorrowTrackerEntity> getAll(){
        return repo.findAll();
    }
    public Optional<BorrowTrackerEntity> getById(Long id){
        return repo.findById(id);
    }
    public List<BorrowTrackerEntity> getByName(String name){
        return repo.findByName(name);
    }
    public BorrowTrackerEntity update(Long id, BorrowTrackerEntity data){
        BorrowTrackerEntity existing=repo.findById(id).orElseThrow();
        existing.setReturned(data.getReturned());
        existing.setReturnDate(data.getReturnDate());
        existing.setNotes(data.getNotes());
        return repo.save(existing);
    }
    public void delete(Long id){
        repo.deleteById(id);
    }
}