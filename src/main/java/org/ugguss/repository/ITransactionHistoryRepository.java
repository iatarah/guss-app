package org.ugguss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ugguss.model.TransactionHistory;

public interface ITransactionHistoryRepository extends JpaRepository<TransactionHistory, Integer> {

}
