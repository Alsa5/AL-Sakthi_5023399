DECLARE
  CURSOR c_monthly_transactions IS
    SELECT customer_id, transaction_id, transaction_type, amount, transaction_date
    FROM transactions
    WHERE EXTRACT(MONTH FROM transaction_date) = EXTRACT(MONTH FROM SYSDATE)
      AND EXTRACT(YEAR FROM transaction_date) = EXTRACT(YEAR FROM SYSDATE);
    
  v_customer_id transactions.customer_id%TYPE;
  v_transaction_id transactions.transaction_id%TYPE;
  v_transaction_type transactions.transaction_type%TYPE;
  v_amount transactions.amount%TYPE;
  v_transaction_date transactions.transaction_date%TYPE;
BEGIN
  OPEN c_monthly_transactions;
  LOOP
    FETCH c_monthly_transactions INTO v_customer_id, v_transaction_id, v_transaction_type, v_amount, v_transaction_date;
    EXIT WHEN c_monthly_transactions%NOTFOUND;
    
    -- Print the statement for each transaction
    DBMS_OUTPUT.PUT_LINE('Customer ID: ' || v_customer_id || 
                         ', Transaction ID: ' || v_transaction_id || 
                         ', Type: ' || v_transaction_type || 
                         ', Amount: ' || v_amount || 
                         ', Date: ' || TO_CHAR(v_transaction_date, 'DD-MON-YYYY'));
  END LOOP;
  CLOSE c_monthly_transactions;
END;
/
