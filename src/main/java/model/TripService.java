package model;

import java.time.LocalDate;
import java.util.List;

// Serwis do zarządzania podróżami i komunikacją z bazą danych

public class TripService {
    private final TripRepository tripRepository;

    public TripService (TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    // Pobiera nadchodzące podróże
    public List<Trip> getUpcomingTrips() {
        return tripRepository.findByStartDateAferOrderByStartDateAsc(LocalDate.now());
    }
    // Pobiera ostatnie podróże
    public List <Trip> getPastTrips() {
        return tripRepository.findByEndDateBeforeOrderByEndDateDesc(LocalDate.now());
    }

    // Dodaje nową podróż do bazy danych
    public Trip addTrip(Trip trip) {
        return tripRepository.save(trip);
    }
    // Usuwa podróż z bazy danych pod id
    public void deleteTrip(Long id) {
        tripRepository.deleteById(id);
    }
}