package repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import model.Cards;

public class CardRepository {

    private final Map<String, Cards> database = new HashMap<>();

    public Cards save(Cards card) {
        database.put(card.getCardNumber(), card);
        return card;
    }

    public Optional<Cards> findById(String cardNumber) {
        return Optional.ofNullable(database.get(cardNumber));
    }

    public List<Cards> findAll() {
        return new ArrayList<>(database.values());
    }

    public boolean deleteById(String cardNumber) {
        return database.remove(cardNumber) != null;
    }
}