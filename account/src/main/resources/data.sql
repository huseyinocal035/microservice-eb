DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS account;

CREATE TABLE customer
(
    id            int AUTO_INCREMENT PRIMARY KEY,
    created_date  date DEFAULT NULL,
    updated_date  date DEFAULT NULL,
    name          varchar(100) NOT NULL,
    email         varchar(100) NOT NULL,
    mobile_number varchar(20)  NOT NULL
);

CREATE TABLE account
(
    customer_id    int          NOT NULL,
    created_date   date DEFAULT NULL,
    updated_date   date DEFAULT NULL,
    account_number int AUTO_INCREMENT PRIMARY KEY,
    type           varchar(100) NOT NULL,
    branch_address varchar(200) NOT NULL
);

INSERT INTO customer (created_date, updated_date, name, email, mobile_number)
VALUES (CURRENT_DATE, CURRENT_DATE, 'Hüseyin Öcal', 'ho@gmail.com', '5054263819');

INSERT INTO account (customer_id, created_date, updated_date, type, branch_address)
VALUES (1, CURRENT_DATE, CURRENT_DATE, 'Yatırım', '25. Sokak Gebze, Kocaeli');