package huseyin.ocal.loan.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import huseyin.ocal.loan.configuration.LoanServiceConfig;
import huseyin.ocal.loan.configuration.Properties;
import huseyin.ocal.loan.dto.Customer;
import huseyin.ocal.loan.entity.Loan;
import huseyin.ocal.loan.repository.LoanRepository;
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
public class LoanController {

    private final LoanRepository loanRepository;

    private final LoanServiceConfig loanServiceConfig;

    @PostMapping("/loan")
    public List<Loan> getLoanDetails(@RequestBody Customer customer) {
        log.info("*** Start of getLoanDetails() method ***");
        List<Loan> loans = loanRepository.findByCustomerIdOrderByStartedDateDesc(customer.getId());
        log.info("*** End of getLoanDetails() method ***");
        return loans;
     }

    @GetMapping("/loan/properties")
    public String getPropertyDetails() throws JsonProcessingException {
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(loanServiceConfig.getMsg(), loanServiceConfig.getBuildVersion(),
            loanServiceConfig.getMailDetails(), loanServiceConfig.getActiveBranches());
        return objectWriter.writeValueAsString(properties);
    }
}
