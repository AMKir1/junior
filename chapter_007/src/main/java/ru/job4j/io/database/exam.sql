--// 1) Retrieve in a single query:
--// - names of all persons that are NOT in the company with id = 5
--// - company name for each person

SELECT p.name AS person_name, c.name AS company_name FROM person AS p LEFT OUTER JOIN company AS c ON p.company_id = c.id WHERE p.company_id != 5;

--// 2) Select the name of the company with the maximum number of persons + number of persons in this company

SELECT c.name AS company_name, COUNT(p.id) AS number_of_preson FROM company AS c LEFT OUTER JOIN person AS p ON c.id = p.company_id GROUP BY c.name ORDER BY number_of_preson DESC LIMIT 1
