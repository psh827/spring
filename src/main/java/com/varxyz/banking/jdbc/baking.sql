SELECT * FROM Customer;

DELETE FROM Customer WHERE cid=1003;
DELETE FROM Account WHERE aid=3002;
SHOW TABLES;

SELECT * FROM Account;

UPDATE Account SET balance = balance - ? WHERE accountNum=?;
UPDATE Account SET balance = balance + ? WHERE accountNum=?;
jdbcTemplate.update(sql, money, withdrawAccountNum);
jdbcTemplate.update(sql2, money, depositAccountNum);