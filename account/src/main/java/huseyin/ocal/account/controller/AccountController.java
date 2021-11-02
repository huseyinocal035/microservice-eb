package huseyin.ocal.account.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import huseyin.ocal.account.configuration.AccountServiceConfig;
import huseyin.ocal.account.configuration.Properties;
import huseyin.ocal.account.entity.Account;
import huseyin.ocal.account.entity.Customer;
import huseyin.ocal.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountRepository accountRepository;

    private final AccountServiceConfig accountServiceConfig;

    @GetMapping("/accounts")
    public Account getAccountDetails(@RequestBody Customer customer) {
        return accountRepository.findById(customer.getId())
            .orElseThrow();
    }

    @GetMapping("/account/properties")
    public String getPropertyDetails() throws JsonProcessingException {
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(accountServiceConfig.getMsg(), accountServiceConfig.getBuildVersion(),
            accountServiceConfig.getMailDetails(), accountServiceConfig.getActiveBranches());
        return objectWriter.writeValueAsString(properties);
    }


}
