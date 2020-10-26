DROP TABLE IF EXISTS transactions;
DROP TABLE IF EXISTS billionaires;

CREATE TABLE transactions (
                              id VARCHAR(255) PRIMARY KEY,
                              type VARCHAR(250) NOT NULL,
                              vendor VARCHAR(250) NOT NULL,
                              amount FLOAT NOT NULL
);

INSERT INTO transactions (id, type, vendor, amount) VALUES
('495234ed-4104-4238-926e-da50d890832c', 'Education', 'Udemy', 120.0),
('721bbd82-1f57-450c-a6aa-c5837dd2c431', 'Takeout', 'Huzur Kebab', 15.0),
('89a8b62c-feb7-4fda-a94e-aa801bfb43be', 'Shopping', 'Amazon.de', 11.0);
