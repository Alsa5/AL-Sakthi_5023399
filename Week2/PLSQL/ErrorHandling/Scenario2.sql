CREATE OR REPLACE PROCEDURE UpdateSalary(
  p_employee_id IN NUMBER,
  p_percentage IN NUMBER
) IS
  employee_not_found EXCEPTION;
BEGIN
  -- Update the salary
  UPDATE employees
  SET salary = salary + salary * (p_percentage / 100)
  WHERE employee_id = p_employee_id;
  
  IF SQL%ROWCOUNT = 0 THEN
    RAISE employee_not_found;
  END IF;
  
  COMMIT;
  
EXCEPTION
  WHEN employee_not_found THEN
    DBMS_OUTPUT.PUT_LINE('Error: Employee ID ' || p_employee_id || ' does not exist.');
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END UpdateSalary;
/
