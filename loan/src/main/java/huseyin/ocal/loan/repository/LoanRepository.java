package huseyin.ocal.loan.repository;

import huseyin.ocal.loan.entity.Loan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends CrudRepository<Loan, Integer> {

    List<Loan> findByCustomerIdOrderByStartedDateDesc(int customerId);
}
