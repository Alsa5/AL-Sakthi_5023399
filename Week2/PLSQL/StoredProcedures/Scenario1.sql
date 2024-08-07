CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
  -- Update the balance of all savings accounts by applying a 1% interest rate
  UPDATE savings_accounts
  SET balance = balance + balance * 0.01;
  
  COMMIT;
END ProcessMonthlyInterest;
/
