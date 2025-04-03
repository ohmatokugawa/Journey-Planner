package model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

// Repozytorium do sortowania podróży
public interface TripRepository extends JpaRepository <Trip, Long> {
    List<Trip> findByStartDateAferOrderByStartDateAsc (java.time.LocalDate date);
    List<Trip> findByEndDateBeforeOrderByEndDateDesc(java.time.LocalDate date);
}
