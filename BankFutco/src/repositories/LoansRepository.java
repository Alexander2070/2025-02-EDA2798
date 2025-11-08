package repositories;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import model.Loans;

public class LoansRepository {

    private final Map<String, Loans> database = new HashMap<>();

    public Loans save(Loans loan) {
        // Usamos la fecha como ID (date.toString())
        String id = loan.getDate().toString();
        database.put(id, loan);
        return loan;
    }

    public Optional<Loans> findById(String id) {
        return Optional.ofNullable(database.get(id));
    }

    public Optional<Loans> findById(String id, LocalDate date) {
        return Optional.ofNullable(database.get(id));
    }

    public List<Loans> findAll() {
        return new ArrayList<>(database.values());
    }

    public boolean deleteById(String id) {
        return database.remove(id) != null;
    }

    public boolean deleteById(String id, LocalDate date) {
        return database.remove(id) != null;
    }
}
