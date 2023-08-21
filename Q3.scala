object Q3 {
  class Account(val accountNumber: String, var balance: Double) {
    require(balance >= 0, "Balance cannot be negative")

    def deposit(amount: Double): Unit = {
      require(amount > 0, "Deposit amount must be positive")
      balance += amount
    }

    def withdraw(amount: Double): Unit = {
      require(amount > 0, "Withdrawal amount must be positive")
      require(balance >= amount, "Insufficient balance")
      balance -= amount
    }

    def transfer(amount: Double, targetAccount: Account): Unit = {
      require(amount > 0, "Transfer amount must be positive")
      require(balance >= amount, "Insufficient balance for transfer")

      withdraw(amount)
      targetAccount.deposit(amount)
    }

    override def toString: String = s"Account $accountNumber - Balance: $balance"
  }

  def main(args: Array[String]): Unit = {
    val account1 = new Account("A123", 1000.0)
    val account2 = new Account("B456", 500.0)

    println("Initial account states:")
    println(account1)
    println(account2)

    account1.deposit(200.0)
    account2.withdraw(100.0)

    println("\nAccount states after transactions:")
    println(account1)
    println(account2)

    account1.transfer(300.0, account2)

    println("\nAccount states after transfer:")
    println(account1)
    println(account2)
  }
}
