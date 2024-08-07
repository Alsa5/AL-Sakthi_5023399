CREATE OR REPLACE PACKAGE EmployeeManagement AS
  PROCEDURE HireEmployee(
    p_employee_id IN NUMBER,
    p_name IN VARCHAR2,
    p_department_id IN NUMBER,
    p_salary IN NUMBER
  );
  
  PROCEDURE UpdateEmployeeDetails(
    p_employee_id IN NUMBER,
    p_name IN VARCHAR2,
    p_department_id IN NUMBER,
    p_salary IN NUMBER
  );
  
  FUNCTION CalculateAnnualSalary(
    p_employee_id IN NUMBER
  ) RETURN NUMBER;
END EmployeeManagement;
/
