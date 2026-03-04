package com.example.BorrowTracker.Entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BorrowTrackerEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String itemName;
    private String type;
    private LocalDate date;
    private LocalDate returnDate;
    private Boolean returned;
    private String notes;
}