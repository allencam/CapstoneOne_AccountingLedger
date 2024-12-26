DROP DATABASE IF EXISTS ledger_db;
CREATE DATABASE IF NOT EXISTS ledger_db;
USE ledger_db;

CREATE TABLE `transaction` (
    `transaction_id`        INT NOT NULL AUTO_INCREMENT,
    `date`                  DATE NOT NULL,
    `time`                  TIME NOT NULL,
    `description`           VARCHAR(255),
    `vendor`                VARCHAR(50),
    `amount`                DECIMAL(8,2),

    PRIMARY KEY (`transaction_id`)
);