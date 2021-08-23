CREATE TABLE space_objects(
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  ngc VARCHAR(255) NOT NULL,
  year_discovered INTEGER
);
