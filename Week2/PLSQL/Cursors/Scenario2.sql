DECLARE
  CURSOR c_accounts IS
    SELECT account_id, balance
    FROM accounts;
    
  v_account_id accounts.account_id%TYPE;
  v_balance accounts.balance%TYPE;
  v_annual_fee CONSTANT NUMBER := 50; -- Annual fee amount
BEGIN
  OPEN c_accounts;
  LOOP
    FETCH c_accounts INTO v_account_id, v_balance;
    EXIT WHEN c_accounts%NOTFOUND;
    
    -- Deduct the annual maintenance fee
    UPDATE accounts
    SET balance = balance - v_annual_fee
    WHERE account_id = v_account_id;
  END LOOP;
  CLOSE c_accounts;
  
  COMMIT;
END;
/
