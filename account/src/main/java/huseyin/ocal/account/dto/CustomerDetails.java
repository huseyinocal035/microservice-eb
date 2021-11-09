package huseyin.ocal.account.dto;

import huseyin.ocal.account.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDetails {

    private Account account;

    private List<Loan> loans;

    private List<Card> cards;

}
