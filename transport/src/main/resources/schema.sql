-- create table type_transport
CREATE TABLE type_transport (
  id SERIAL PRIMARY KEY,
  name VARCHAR(50) NOT NULL UNIQUE
);

-- create table transport
CREATE TABLE transport (
  id SERIAL PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  price FLOAT(2) NOT NULL CONSTRAINT  positive_price CHECK (price > 0),
  date_create DATE,
  type_transport_id INT REFERENCES type_transport(id)
);