DECLARE
  CURSOR c_loans IS
    SELECT loan_id, interest_rate
    FROM loans;
    
  v_loan_id loans.loan_id%TYPE;
  v_interest_rate loans.interest_rate%TYPE;
  v_new_interest_rate CONSTANT NUMBER := 0.05; -- New interest rate (example: 5%)
BEGIN
  OPEN c_loans;
  LOOP
    FETCH c_loans INTO v_loan_id, v_interest_rate;
    EXIT WHEN c_loans%NOTFOUND;
    
    -- Update the interest rate based on the new policy
    UPDATE loans
    SET interest_rate = v_new_interest_rate
    WHERE loan_id = v_loan_id;
  END LOOP;
  CLOSE c_loans;
  
  COMMIT;
END;
/
