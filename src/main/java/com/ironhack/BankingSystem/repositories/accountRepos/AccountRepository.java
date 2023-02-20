package com.ironhack.BankingSystem.repositories.accountRepos;

import com.ironhack.BankingSystem.models.Users.AccountHolder;
import com.ironhack.BankingSystem.models.acc.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findById(Long id);
    List<Account> findAllByPrimaryOwner(AccountHolder primaryOwner);
    List<Account> findAllBySecondaryOwner(AccountHolder secondaryOwner);
    Optional<Account> findBySecretKey(String secretKey);
    List<Account> findAllByBalanceLessThan(BigDecimal balance);

    boolean existsBySecretKey(String secretKey);

    Optional<Account> findByAccountIdAndPrimaryOwnerName(Integer receiverAccountId, String receiverName);

    Optional<Account> findByAccountId(Integer senderAccountId);

    List<Account> findAllByPrimaryOwner_Id(Integer userId);
}
