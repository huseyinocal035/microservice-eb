DROP TABLE IF EXISTS card;

CREATE TABLE card
(
    id               int          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    created_date     date DEFAULT NULL,
    updated_date     date DEFAULT NULL,
    card_number      varchar(100) NOT NULL,
    customer_id      int          NOT NULL,
    type             varchar(100) NOT NULL,
    total_limit      int          NOT NULL,
    amount_used      int          NOT NULL,
    available_amount int          NOT NULL
);


INSERT INTO card (card_number, created_date, updated_date, customer_id, type, total_limit, amount_used, available_amount)
VALUES ('5368XXXXXXXX1459', CURRENT_DATE, CURRENT_DATE, 1, 'Credit', 10000, 500, 9500),
       ('4596XXXXXXXX5749', CURRENT_DATE, CURRENT_DATE, 1, 'Credit', 7500, 600, 6900),
       ('3526XXXXXXXX9748', CURRENT_DATE, CURRENT_DATE, 1, 'Credit', 20000, 4000, 16000);
