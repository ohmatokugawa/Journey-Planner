package model;

import model.Trip;
import model.TripRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

// Serwis do zarządzania podróżami
@Service
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