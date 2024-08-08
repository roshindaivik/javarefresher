CREATE TABLE campaign (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    bidding DECIMAL(10, 2) NOT NULL,
    total_budget DECIMAL(10, 2) NOT NULL,
    balance_budget DECIMAL(10, 2) NOT NULL
);