package huseyin.ocal.card.entity;

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
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreationTimestamp
    @Column(updatable = false)
    private Instant createdDate;

    @CreationTimestamp
    private Instant updatedDate;

    private int customerId;

    private String cardNumber;

    private String type;

    private int totalLimit;

    private int amountUsed;

    private int availableAmount;

}
