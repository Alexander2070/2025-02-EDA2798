package repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.Account;

public class AccountRepository {

    private final List<Account> storage = new ArrayList<>();

    public AccountRepository() {
        initData();
    }

    private void initData() {
        // 10 registros iniciales (accountNumber únicos)
        storage.add(new Account("ACC001", "Ana Perez", "ana.perez@example.com", "3000000001", "Savings", "Calle 1"));
        storage.add(new Account("ACC002", "Luis Gomez", "luis.gomez@example.com", "3000000002", "Checking", "Calle 2"));
        storage.add(new Account("ACC003", "María Ruiz", "maria.ruiz@example.com", "3000000003", "Savings", "Calle 3"));
        storage.add(new Account("ACC004", "Carlos Díaz", "carlos.diaz@example.com", "3000000004", "Checking", "Calle 4"));
        storage.add(new Account("ACC005", "Sofia Morales", "sofia.morales@example.com", "3000000005", "Savings",
                "Calle 5"));
        storage.add(new Account("ACC006", "Diego Torres", "diego.torres@example.com", "3000000006", "Checking", "Calle 6"));
        storage.add(new Account("ACC007", "Lucia Herrera", "lucia.herrera@example.com", "3000000007", "Savings",
                "Calle 7"));
        storage.add(new Account("ACC008", "Miguel Ramos", "miguel.ramos@example.com", "3000000008", "Checking", "Calle 8"));
        storage.add(new Account("ACC009", "Natalia Vega", "natalia.vega@example.com", "3000000009", "Savings", "Calle 9"));
        storage.add(new Account("ACC010", "Jorge Castro", "jorge.castro@example.com", "3000000010", "Checking",
                "Calle 10"));
    }
    /**
     * Implementación solicitada: Crea una nueva cuenta.
     */
    public Account crearCuenta(Account newAccount) {
        if (newAccount == null || newAccount.getAccountNumber() == null) {
            throw new IllegalArgumentException("La cuenta y el accountNumber no pueden ser nulos al crear.");
        }

        // Verifica si ya existe una cuenta con el mismo número
        if (existsById(newAccount.getAccountNumber())) {
            // No se puede crear, ya existe. Retornamos null o lanzamos una excepción,
            // dependiendo de la política de errores. Aquí retornamos null.
            System.out.println("ERROR: La cuenta con número " + newAccount.getAccountNumber() + " ya existe. No se puede crear.");
            return null;
        }

        // Si no existe, usa el método save para añadirla al almacenamiento.
        return save(newAccount);
    }

    // CREATE - Save new account
    public Account save(Account account) {
        if (account == null || account.getAccountNumber() == null) {
            throw new IllegalArgumentException("Account o accountNumber no puede ser null");
        }

        // Check if account already exists using functional approach
        storage.removeIf(a -> a.getAccountNumber().equals(account.getAccountNumber()));
        storage.add(account);
        return account;
    }

    // UPDATE - Update existing account using Optional
    public Optional<Account> update(String accountNumber, Account updatedAccount) {
        if (accountNumber == null || updatedAccount == null) {
            throw new IllegalArgumentException("AccountNumber y Account no pueden ser null");
        }

        return findById(accountNumber)
                .map(existingAccount -> {
                    storage.removeIf(acc -> acc.getAccountNumber().equals(accountNumber));
                    updatedAccount.setAccountNumber(accountNumber);
                    storage.add(updatedAccount);
                    return updatedAccount;
                });
    }

    // READ - Find by ID
    public Optional<Account> findById(String accountNumber) {
        if (accountNumber == null) {
            return Optional.empty();
        }

        return storage.stream()
                .filter(account -> account.getAccountNumber().equals(accountNumber))
                .findFirst();
    }

    // READ ALL - Get all accounts
    public List<Account> findAll() {
        return new ArrayList<>(storage);
    }

    // DELETE - Remove account by ID
    public boolean deleteById(String accountNumber) {
        return findById(accountNumber)
                .map(account -> storage.remove(account))
                .orElse(false);
    }

    // Check if account exists
    public boolean existsById(String accountNumber) {
        return storage.stream()
                .anyMatch(account -> account.getAccountNumber().equals(accountNumber));
    }
}