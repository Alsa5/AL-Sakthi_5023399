CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

  PROCEDURE HireEmployee(
    p_employee_id IN NUMBER,
    p_name IN VARCHAR2,
    p_department_id IN NUMBER,
    p_salary IN NUMBER
  ) IS
  BEGIN
    INSERT INTO employees (employee_id, name, department_id, salary)
    VALUES (p_employee_id, p_name, p_department_id, p_salary);
    COMMIT;
  EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
      DBMS_OUTPUT.PUT_LINE('Error: Employee ID ' || p_employee_id || ' already exists.');
    WHEN OTHERS THEN
      DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
  END HireEmployee;
  
  PROCEDURE UpdateEmployeeDetails(
    p_employee_id IN NUMBER,
    p_name IN VARCHAR2,
    p_department_id IN NUMBER,
    p_salary IN NUMBER
  ) IS
  BEGIN
    UPDATE employees
    SET name = p_name, department_id = p_department_id, salary = p_salary
    WHERE employee_id = p_employee_id;
    COMMIT;
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      DBMS_OUTPUT.PUT_LINE('Error: Employee ID ' || p_employee_id || ' does not exist.');
    WHEN OTHERS THEN
      DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
  END UpdateEmployeeDetails;
  
  FUNCTION CalculateAnnualSalary(
    p_employee_id IN NUMBER
  ) RETURN NUMBER IS
    v_salary NUMBER;
  BEGIN
    SELECT salary INTO v_salary
    FROM employees
    WHERE employee_id = p_employee_id;
    
    RETURN v_salary * 12;
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RETURN NULL;
    WHEN OTHERS THEN
      RETURN NULL;
  END CalculateAnnualSalary;

END EmployeeManagement;
/
