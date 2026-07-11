SELECT (SELECT DISTINCT salary FROM Employee  ORDER BY salary DESC LIMIT 1 OFFSET 1) AS SecondHighestSalary;

-- SELECT DISTINCT salary FROM Employee  ORDER BY salary LIMIT 1 OFFSET 1;



-- The outer SELECT (...)

-- If the inner query finds no value, SQL automatically returns NULL instead of an error.