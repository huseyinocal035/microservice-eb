package huseyin.ocal.account.service.client;

import huseyin.ocal.account.dto.Card;
import huseyin.ocal.account.entity.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient("card")
public interface CardFeignClient {

    @PostMapping(value = "card", consumes = "application/json")
    List<Card> getCardDetails(@RequestBody Customer customer);
}
