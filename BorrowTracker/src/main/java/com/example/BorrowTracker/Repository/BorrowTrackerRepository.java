package com.example.BorrowTracker.Repository;

import com.example.BorrowTracker.Entity.BorrowTrackerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BorrowTrackerRepository extends JpaRepository<BorrowTrackerEntity, Long>{
    List<BorrowTrackerEntity> findByName(String name);
    List<BorrowTrackerEntity> findByReturned(Boolean returned);
}