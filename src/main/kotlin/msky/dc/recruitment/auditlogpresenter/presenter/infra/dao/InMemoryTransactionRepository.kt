package msky.dc.recruitment.auditlogpresenter.presenter.infra.dao

import msky.dc.recruitment.auditlogpresenter.presenter.domain.impl.Transaction
import msky.dc.recruitment.auditlogpresenter.presenter.domain.impl.TransactionRepository
import org.springframework.stereotype.Repository
import java.util.Collections.synchronizedList

@Repository
class InMemoryTransactionRepository(private val transactions: MutableList<Transaction> = synchronizedList(ArrayList())) : TransactionRepository {

    override fun findAllByAccountTypeIdInAndCustomerIdInOrderByTransactionAmountAsc(requestedAccountTypesIds: List<String>,
                                                                                    customersIds: List<String>): List<Transaction> {
        return transactions
                .filter {
                    requestedAccountTypesIds.isEmpty() || requestedAccountTypesIds.contains(it.accountTypeId())
                }.filter {
                    customersIds.isEmpty() || customersIds.contains(it.customerId())
                }
                .sortedBy { it.transactionAmount }
    }

    override fun save(transaction: Transaction) {
        transactions.add(transaction)
    }
}