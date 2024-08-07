CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
  p_department_id IN NUMBER,
  p_bonus_percentage IN NUMBER
) IS
BEGIN
  -- Update the salary of employees in the given department by adding the bonus percentage
  UPDATE employees
  SET salary = salary + salary * (p_bonus_percentage / 100)
  WHERE department_id = p_department_id;
  
  COMMIT;
END UpdateEmployeeBonus;
/
