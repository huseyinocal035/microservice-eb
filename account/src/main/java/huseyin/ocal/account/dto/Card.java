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
public class Card {

    private int id;

    private Instant createdDate;

    private Instant updatedDate;

    private int customerId;

    private String cardNumber;

    private String type;

    private int totalLimit;

    private int amountUsed;

    private int availableAmount;

}
