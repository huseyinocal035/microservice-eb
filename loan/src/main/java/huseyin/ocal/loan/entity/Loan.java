package huseyin.ocal.loan.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loanNumber;

    private Long customerId;

    @CreationTimestamp
    @Column(updatable = false)
    private Instant createdDate;

    @CreationTimestamp
    private Instant updatedDate;

    private String type;

    private int totalLoan;

    private int amountPaid;

    private int outstandingAmount;

    @CreationTimestamp
    private Instant startedDate;

}
