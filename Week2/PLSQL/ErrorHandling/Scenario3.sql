CREATE OR REPLACE PROCEDURE AddNewCustomer(
  p_customer_id IN NUMBER,
  p_name IN VARCHAR2,
  p_age IN NUMBER,
  p_balance IN NUMBER
) IS
  duplicate_customer EXCEPTION;
BEGIN
  -- Insert the new customer
  INSERT INTO customers (customer_id, name, age, balance)
  VALUES (p_customer_id, p_name, p_age, p_balance);
  
  COMMIT;
  
EXCEPTION
  WHEN DUP_VAL_ON_INDEX THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('Error: Customer ID ' || p_customer_id || ' already exists.');
  WHEN OTHERS THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END AddNewCustomer;
/
