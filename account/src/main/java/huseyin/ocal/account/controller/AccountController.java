package huseyin.ocal.account.controller;

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

    @GetMapping("/accounts")
    public Account getAccountDetails(@RequestBody Customer customer) {
        return accountRepository.findById(customer.getId())
            .orElseThrow();
    }

}
