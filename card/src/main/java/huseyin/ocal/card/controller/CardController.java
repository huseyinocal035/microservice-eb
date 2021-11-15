package huseyin.ocal.card.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import huseyin.ocal.card.configuration.CardServiceConfig;
import huseyin.ocal.card.configuration.Properties;
import huseyin.ocal.card.dto.Customer;
import huseyin.ocal.card.entity.Card;
import huseyin.ocal.card.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CardController {

    private final CardRepository cardsRepository;

    private final CardServiceConfig cardServiceConfig;

    @PostMapping("/card")
    public List<Card> getCardDetails(@RequestBody Customer customer) {
        log.info("*** Start of getCardDetails() method ***");
        List<Card> cards = cardsRepository.findByCustomerId(customer.getId());
        log.info("*** End of getCardDetails() method ***");
        return cards;
    }

    @GetMapping("/card/properties")
    public String getPropertyDetails() throws JsonProcessingException {
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(cardServiceConfig.getMsg(), cardServiceConfig.getBuildVersion(),
            cardServiceConfig.getMailDetails(), cardServiceConfig.getActiveBranches());
        return objectWriter.writeValueAsString(properties);
    }

}
