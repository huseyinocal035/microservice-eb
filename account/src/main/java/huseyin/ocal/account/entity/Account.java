package huseyin.ocal.account.entity;

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
public class Account {

    private Long customerId;

    @CreationTimestamp
    @Column(updatable = false)
    private Instant createdDate;

    @CreationTimestamp
    private Instant updatedDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountNumber;

    private String type;

    private String branchAddress;

}
