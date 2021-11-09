package huseyin.ocal.account.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Loan {

    private int loanNumber;

    private int customerId;

    private Instant createdDate;

    private Instant updatedDate;

    private String type;

    private int totalLoan;

    private int amountPaid;

    private int outstandingAmount;

    private Instant startedDate;

}
