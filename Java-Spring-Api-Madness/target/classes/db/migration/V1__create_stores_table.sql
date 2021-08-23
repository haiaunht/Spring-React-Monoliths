CREATE TABLE stores(
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  type VARCHAR(255) NOT NULL,
  average_cost INTEGER NOT NULL,
  operating_status BOOLEAN NOT NULL
);
