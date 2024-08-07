CREATE OR REPLACE PACKAGE CustomerManagement AS
  PROCEDURE AddNewCustomer(
    p_customer_id IN NUMBER,
    p_name IN VARCHAR2,
    p_age IN NUMBER,
    p_balance IN NUMBER
  );
  
  PROCEDURE UpdateCustomerDetails(
    p_customer_id IN NUMBER,
    p_name IN VARCHAR2,
    p_age IN NUMBER
  );
  
  FUNCTION GetCustomerBalance(
    p_customer_id IN NUMBER
  ) RETURN NUMBER;
END CustomerManagement;
/
