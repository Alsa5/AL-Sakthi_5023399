CREATE OR REPLACE PROCEDURE SafeTransferFunds(
  p_from_account_id IN NUMBER,
  p_to_account_id IN NUMBER,
  p_amount IN NUMBER
) IS
  insufficient_funds EXCEPTION;
BEGIN
  -- Check if the from account has sufficient funds
  DECLARE
    v_balance NUMBER;
  BEGIN
    SELECT balance INTO v_balance
    FROM accounts
    WHERE account_id = p_from_account_id;
    
    IF v_balance < p_amount THEN
      RAISE insufficient_funds;
    END IF;
  END;
  
  -- Perform the transfer
  UPDATE accounts
  SET balance = balance - p_amount
  WHERE account_id = p_from_account_id;
  
  UPDATE accounts
  SET balance = balance + p_amount
  WHERE account_id = p_to_account_id;
  
  COMMIT;
  
EXCEPTION
  WHEN insufficient_funds THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('Error: Insufficient funds in the source account.');
  WHEN OTHERS THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END SafeTransferFunds;
/
