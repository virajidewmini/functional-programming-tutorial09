object Q4 {
  class Account(val accountNumber: String, val balance: Double) {
    override def toString: String = s"Account $accountNumber - Balance: $balance"
  }

  def negativeBalanceAccounts(accounts: List[Account]): List[Account] = {
    accounts.filter(_.balance < 0)
  }

  def calculateTotalBalance(accounts: List[Account]): Double = {
    accounts.map(_.balance).sum
  }

  def applyInterest(accounts: List[Account]): List[Account] = {
    def interestFunction(balance: Double): Double = {
      if (balance >= 0) balance * 0.05
      else balance * 0.1
    }
    accounts.map(account => new Account(account.accountNumber, account.balance + interestFunction(account.balance)))
  }
  def main(args: Array[String]): Unit = {
    val accounts = List(
      new Account("A123", 1000.0),
      new Account("B456", -500.0),
      new Account("C789", 200.0),
      new Account("D987", -150.0)
    )

    val negativeBalances = negativeBalanceAccounts(accounts)
    println("Accounts with negative balances:")
    negativeBalances.foreach(println)

    val totalBalance = calculateTotalBalance(accounts)
    println(s"Total balance of all accounts: $totalBalance")

    val finalBalances = applyInterest(accounts)
    println("Final balances after applying interest:")
    finalBalances.foreach(println)
  }
}
