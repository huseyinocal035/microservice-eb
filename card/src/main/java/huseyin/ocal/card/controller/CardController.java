package huseyin.ocal.card.controller;

import huseyin.ocal.card.dto.Customer;
import huseyin.ocal.card.entity.Card;
import huseyin.ocal.card.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CardController {

    private final CardRepository cardsRepository;

    @GetMapping("/cards")
    public List<Card> getCardDetails(@RequestBody Customer customer) {
        return cardsRepository.findByCustomerId(customer.getCustomerId());
    }

}
