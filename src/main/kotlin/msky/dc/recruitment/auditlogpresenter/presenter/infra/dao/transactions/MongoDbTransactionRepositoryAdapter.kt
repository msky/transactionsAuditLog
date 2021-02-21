package msky.dc.recruitment.auditlogpresenter.presenter.infra.dao.transactions

import msky.dc.recruitment.auditlogpresenter.presenter.domain.ShowTransactionsQuery
import msky.dc.recruitment.auditlogpresenter.presenter.domain.impl.Transaction
import msky.dc.recruitment.auditlogpresenter.presenter.domain.impl.TransactionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class MongoDbTransactionRepositoryAdapter(@Autowired private val mongoRepository: MongoDbTransactionRepository) :
        TransactionRepository {

    override fun findTransactionsByQueryOrderByAmountAsc(query: ShowTransactionsQuery): List<Transaction> {
        return when {
            query.noFiltersAreDefined() -> mongoRepository.findAllByOrderByTransactionAmountAsc()
            query.showAllAccounts() -> mongoRepository.findAllByCustomerIdInOrderByTransactionAmountAsc(query.customersIds)
            query.showAllCustomers() -> mongoRepository.findAllByAccountTypeIdInOrderByTransactionAmountAsc(query.accountTypesIds)
            else -> return mongoRepository.findAllByAccountTypeIdInAndCustomerIdInOrderByTransactionAmountAsc(
                    query.accountTypesIds,
                    query.customersIds)
        }
    }

    override fun save(transaction: Transaction) {
        mongoRepository.save(transaction)
    }

}