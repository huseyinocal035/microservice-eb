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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoanController {

    private final LoanRepository loanRepository;

    private final LoanServiceConfig loanServiceConfig;

    @GetMapping
    public List<Loan> getLoanDetails(@RequestBody Customer customer) {
        return loanRepository.findByCustomerIdOrderByStartedDateDesc(customer.getId());
     }

    @GetMapping("/loan/properties")
    public String getPropertyDetails() throws JsonProcessingException {
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(loanServiceConfig.getMsg(), loanServiceConfig.getBuildVersion(),
            loanServiceConfig.getMailDetails(), loanServiceConfig.getActiveBranches());
        return objectWriter.writeValueAsString(properties);
    }
}
