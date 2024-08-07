DECLARE
  CURSOR c_loans IS
    SELECT customer_id, loan_id, due_date
    FROM loans
    WHERE due_date BETWEEN SYSDATE AND SYSDATE + 30;
    
  v_customer_id loans.customer_id%TYPE;
  v_loan_id loans.loan_id%TYPE;
  v_due_date loans.due_date%TYPE;
BEGIN
  OPEN c_loans;
  LOOP
    FETCH c_loans INTO v_customer_id, v_loan_id, v_due_date;
    EXIT WHEN c_loans%NOTFOUND;
    
    -- Print reminder message
    DBMS_OUTPUT.PUT_LINE('Reminder: Customer ID ' || v_customer_id || 
                         ', Loan ID ' || v_loan_id || 
                         ' is due on ' || TO_CHAR(v_due_date, 'DD-MON-YYYY'));
  END LOOP;
  CLOSE c_loans;
END;
/
