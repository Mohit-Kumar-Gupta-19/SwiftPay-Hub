CREATE DATABASE swiftpay;
USE swiftpay;

CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(255)
);

CREATE TABLE accounts (
    account_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    balance DOUBLE DEFAULT 0
);

CREATE TABLE transactions (
    tx_id INT AUTO_INCREMENT PRIMARY KEY,
    account_id INT,
    type VARCHAR(20),
    amount DOUBLE,
    tx_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE contact (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    subject VARCHAR(100),
    message TEXT
);

CREATE TABLE feedback (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    message TEXT
);
