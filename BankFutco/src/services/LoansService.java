package services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import model.Loans;
import repositories.LoansRepository;

public class LoansService implements ILoansService {

    private final LoansRepository loansRepository;

    public LoansService() {
        this(new LoansRepository());
    }

    public LoansService(LoansRepository loansRepository) {
        this.loansRepository = loansRepository;
    }

    @Override
    public Loans save(Loans loan) {
        return loansRepository.save(loan);
    }

    @Override
    public Optional<Loans> findById(String id) {
        return loansRepository.findById(id);
    }

    public Optional<Loans> findById(String id, LocalDate date) {
        return loansRepository.findById(id, date);
    }

    @Override
    public List<Loans> findAll() {
        return loansRepository.findAll();
    }

    @Override
    public boolean deleteById(String id) {
        return loansRepository.deleteById(id);
    }

    public boolean deleteById(String id, LocalDate date) {
        return loansRepository.deleteById(id, date);
    }
}

