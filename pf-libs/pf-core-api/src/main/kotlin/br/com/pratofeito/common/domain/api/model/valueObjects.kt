package br.com.pratofeito.common.domain.api.model

import java.math.BigDecimal
import java.util.Date

data class AuditEntry(val who: String, val `when`: Date)

data class PersonName(val firstName: String, val lastName: String)

data class Money(val amount: BigDecimal, val currency: String) {
    fun add(money: Money): Money {
        if (currency != money.currency) {
            throw IllegalArgumentException("Currency mismatch")
        }
        return Money(amount + money.amount, currency)
    }

    fun multiply(multiplier: BigDecimal): Money {
        return Money(amount.multiply(multiplier), currency)
    }

    fun isGreaterThanOrEqualTo(money: Money): Boolean {
        if (currency != money.currency) {
            throw IllegalArgumentException("Currency mismatch")
        }
        return amount >= money.amount
    }
}