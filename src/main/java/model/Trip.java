// Ta cześć jest do komunikacji z formularzem podróży
package model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity

public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long id; // ID jest unikatowe dla każdej podróży i ma służyć wyłącznie do identyfikacji w bazie danych
    private String destination;
    private LocalDate startDate;
    private LocalDate endDate;
    private String transport;


    public Trip(){
    }
// Tutaj masz dane, które mają się wyświetlać. Chłopaki mieli uzupełnić dane z formularze oprócz tego, które ja dodałem. Więc albo to uzupełnią albo mamy full.
    public Trip(Long id, String destination, LocalDate startDate, LocalDate endDate, String transport) {
        this.id = id;
        this.destination = destination;
        this.startDate = startDate;
        this.endDate = endDate;
        this.transport = transport;
    }
// tutaj masz gettery i settery do danych w formularzu

    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getTransport() {
        return transport;
    }
    public void setTransport(String transport) {
        this.transport = transport;
    }
}
