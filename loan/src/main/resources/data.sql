DROP TABLE IF EXISTS loan;

CREATE TABLE loan
(
    loan_number        int          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    customer_id        int          NOT NULL,
    created_date       date DEFAULT NULL,
    updated_date       date DEFAULT NULL,
    type               varchar(100) NOT NULL,
    total_loan         int          NOT NULL,
    amount_paid        int          NOT NULL,
    outstanding_amount int          NOT NULL,
    started_date       date DEFAULT NULL
);

INSERT INTO loan (customer_id, created_date, updated_date, type, total_loan, amount_paid, outstanding_amount, started_date)
VALUES (1, CURRENT_DATE, CURRENT_DATE, 'Home', 2500000, 500000, 2000000, CURRENT_DATE),
       (1, CURRENT_DATE, CURRENT_DATE, 'Vehicle', 240000, 100000, 140000, CURRENT_DATE),
       (1, CURRENT_DATE, CURRENT_DATE, 'Home', 500000, 100000, 400000, CURRENT_DATE),
       (1, CURRENT_DATE, CURRENT_DATE, 'Personal', 75000, 35000, 40000, CURRENT_DATE);