package msky.dc.recruitment.auditlogpresenter.presenter.domain.impl

import msky.dc.recruitment.auditlogpresenter.hardcodeddata.NewTransactionCompleted

class TransactionProjectionBuilder(private val customerRepository: CustomerRepository,
                                   private val accountTypeRepository: AccountTypeRepository,
                                   private val transactionRepository: TransactionRepository) {

    fun buildTransactionProjection(newTransactionCompleted: NewTransactionCompleted) {
        val customer = customerRepository.findOrThrow(newTransactionCompleted.customerId)
        val accountType = accountTypeRepository.findOrThrow(newTransactionCompleted.accountTypeId)

        val transaction = buildTransactionProjection(newTransactionCompleted, customer, accountType)
        transactionRepository.save(transaction)
    }

    private fun buildTransactionProjection(newTransactionCompleted: NewTransactionCompleted,
                                           customer: Customer,
                                           accountType: AccountType): Transaction {
        return Transaction(newTransactionCompleted.transactionId,
                newTransactionCompleted.transactionAmount,
                newTransactionCompleted.transactionDate,
                Transaction.AccountType(accountType.id,
                        accountType.name),
                Transaction.Customer(customer.firstName,
                        customer.lastName)
        )
    }
}