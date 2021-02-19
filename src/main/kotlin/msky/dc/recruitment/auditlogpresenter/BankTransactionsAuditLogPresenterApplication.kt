package msky.dc.recruitment.auditlogpresenter

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BankTransactionsAuditLogPresenterApplication

fun main(args: Array<String>) {
	runApplication<BankTransactionsAuditLogPresenterApplication>(*args)
}
