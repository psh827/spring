SELECT * FROM Customer;

DELETE FROM Customer WHERE cid=1003;
DELETE FROM Account WHERE aid=3002;
SHOW TABLES;

SELECT * FROM Account;

SELECT c.name, a.accountNum FROM Customer c INNER JOIN Account a ON c.cid = a.customerId;

UPDATE Account SET balance = balance - ? WHERE accountNum=?;
UPDATE Account SET balance = balance + ? WHERE accountNum=?;
jdbcTemplate.update(sql, money, withdrawAccountNum);
jdbcTemplate.update(sql2, money, depositAccountNum);