package huseyin.ocal.account.service.client;

import huseyin.ocal.account.dto.Loan;
import huseyin.ocal.account.entity.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient("loan")
public interface LoanFeignClient {

    @PostMapping(value = "loan", consumes = "application/json")
    List<Loan> getLoanDetails(@RequestHeader("huseyinocal-correlation-id") String correlationId, @RequestBody Customer customer);
}
