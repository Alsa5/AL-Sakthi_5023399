CREATE OR REPLACE FUNCTION CalculateAge(
  p_date_of_birth DATE
) RETURN NUMBER IS
  v_age NUMBER;
BEGIN
  -- Calculate age in years
  v_age := TRUNC((SYSDATE - p_date_of_birth) / 365.25);
  RETURN v_age;
END CalculateAge;
/
