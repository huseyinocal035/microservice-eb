package huseyin.ocal.loan.controller;

import huseyin.ocal.account.entity.Customer;
import huseyin.ocal.loan.entity.Loan;
import huseyin.ocal.loan.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoanController {

    private final LoanRepository loanRepository;

    @GetMapping
    public List<Loan> getLoanDetails(@RequestBody Customer customer) {
        return loanRepository.findByCustomerIdOrderByStartedDateDesc(customer.getId());
     }
}
