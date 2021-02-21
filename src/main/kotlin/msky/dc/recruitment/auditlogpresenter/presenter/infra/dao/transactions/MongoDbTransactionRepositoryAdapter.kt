package msky.dc.recruitment.auditlogpresenter.presenter.infra.dao.transactions

import msky.dc.recruitment.auditlogpresenter.presenter.domain.impl.Transaction
import msky.dc.recruitment.auditlogpresenter.presenter.domain.impl.TransactionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class MongoDbTransactionRepositoryAdapter(@Autowired private val mongoRepository: MongoDbTransactionRepository) :
        TransactionRepository {

    override fun findAllByAccountTypeIdInAndCustomerIdInOrderByTransactionAmountAsc(requestedAccountTypesIds: List<String>,
                                                                                    requestedCustomersIds: List<String>)
            : List<Transaction> {
        return if (noFiltersAreDefined(requestedAccountTypesIds, requestedCustomersIds))
            mongoRepository.findAllByOrderByTransactionAmountAsc()
        else if (noFilterForAccountTypesIsDefined(requestedAccountTypesIds))
            mongoRepository.findAllByCustomerIdInOrderByTransactionAmountAsc(requestedCustomersIds)
        else if (noFilterForCustomersIsDefined(requestedCustomersIds))
            mongoRepository.findAllByAccountTypeIdInOrderByTransactionAmountAsc(requestedAccountTypesIds)
        else
            return mongoRepository.findAllByAccountTypeIdInAndCustomerIdInOrderByTransactionAmountAsc(requestedAccountTypesIds,
                    requestedCustomersIds)

    }

    private fun noFiltersAreDefined(requestedAccountTypesIds: List<String>,
                                    requestedCustomersIds: List<String>): Boolean {
        return noFilterForAccountTypesIsDefined(requestedAccountTypesIds)
                && noFilterForCustomersIsDefined(requestedCustomersIds)
    }

    private fun noFilterForAccountTypesIsDefined(requestedAccountTypesIds: List<String>): Boolean {
        return requestedAccountTypesIds.isEmpty()
    }

    private fun noFilterForCustomersIsDefined(requestedCustomersIds: List<String>): Boolean {
        return requestedCustomersIds.isEmpty()
    }

    override fun save(transaction: Transaction) {
        mongoRepository.save(transaction)
    }

}