package huseyin.ocal.account.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import huseyin.ocal.account.configuration.AccountServiceConfig;
import huseyin.ocal.account.configuration.Properties;
import huseyin.ocal.account.dto.Card;
import huseyin.ocal.account.dto.CustomerDetails;
import huseyin.ocal.account.dto.Loan;
import huseyin.ocal.account.entity.Account;
import huseyin.ocal.account.entity.Customer;
import huseyin.ocal.account.repository.AccountRepository;
import huseyin.ocal.account.service.client.CardFeignClient;
import huseyin.ocal.account.service.client.LoanFeignClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountRepository accountRepository;

    private final AccountServiceConfig accountServiceConfig;

    private final CardFeignClient cardFeignClient;

    private final LoanFeignClient loanFeignClient;

    @GetMapping("/accounts")
    public Account getAccountDetails(@RequestBody Customer customer) {
        return accountRepository.findById(customer.getId())
            .orElseThrow();
    }

    @GetMapping("/account/properties")
    public String getPropertyDetails() throws JsonProcessingException {
        var objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        var properties = new Properties(accountServiceConfig.getMsg(), accountServiceConfig.getBuildVersion(),
            accountServiceConfig.getMailDetails(), accountServiceConfig.getActiveBranches());
        return objectWriter.writeValueAsString(properties);
    }

    @PostMapping("/customerDetails")
    @CircuitBreaker(name = "detailsForCustomerSupportApp", fallbackMethod = "getCustomerDetailsFallBack")
    @Retry(name = "retryForCustomerDetails", fallbackMethod = "getCustomerDetailsFallBack")
    public CustomerDetails getCustomerDetails(@RequestBody Customer customer) {
        log.info("*** Start of getCustomerDetails() method ***");
        var account = accountRepository.findByCustomerId(customer.getId());
        List<Loan> loans = loanFeignClient.getLoanDetails(customer);
        List<Card> cards = cardFeignClient.getCardDetails(customer);

        var customerDetails = new CustomerDetails();
        customerDetails.setAccount(account);
        customerDetails.setLoans(loans);
        customerDetails.setCards(cards);

        log.info("*** End of getCustomerDetails() method ***");
        return customerDetails;
    }

    private CustomerDetails getCustomerDetailsFallBack(Customer customer, Throwable throwable) {
        var account = accountRepository.findByCustomerId(customer.getId());
        List<Loan> loans = loanFeignClient.getLoanDetails(customer);

        var customerDetails = new CustomerDetails();
        customerDetails.setAccount(account);
        customerDetails.setLoans(loans);

        return customerDetails;
    }

    @GetMapping("/sayHello")
    @RateLimiter(name = "sayHello", fallbackMethod = "sayHelloFallback")
    public String sayHello() {
        return "Hello, Welcome to Huseyin Ocal Bank";
    }

    private String sayHelloFallback(Throwable throwable) {
        return "Hi, Welcome to Huseyin Ocal Bank with fallback";
    }
}
